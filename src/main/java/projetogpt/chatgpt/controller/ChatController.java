package projetogpt.chatgpt.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import projetogpt.chatgpt.dto.ChatGPTRequest;
import projetogpt.chatgpt.dto.ChatGptResponse;


@RestController
public class ChatController {

    @Value("${spring.ai.openai.chat.model}")
    private String model;

    @Value("${spring.ai.openai.chat.base-url}")
    private String apiUrl;

    @Autowired
    private RestTemplate template;


    @GetMapping("/chat")
    public String chat(@RequestParam("prompt") String prompt) {
        try {
            ChatGPTRequest request = new ChatGPTRequest(model, prompt);
            ChatGptResponse chatGptResponse = template.postForObject(apiUrl, request, ChatGptResponse.class);

            if (chatGptResponse != null && chatGptResponse.getChoices() != null && !chatGptResponse.getChoices().isEmpty()) {
                return chatGptResponse.getChoices().get(0).getMessage().getContent();
            } else {
                return "Erro: Resposta vazia da API";
            }
        } catch (Exception e) {
            e.printStackTrace(); // Para ver o erro no console
            return "Erro interno: " + e.getMessage();
        }
    }
}

