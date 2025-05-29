package projetogpt.chatgpt.config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class OpenAIConfig {

    @Value("${spring.ai.openai.api-key}")
    private String openApiKey;
    @Bean
    public RestTemplate template(){

        RestTemplate resttemplate = new RestTemplate();
        resttemplate.getInterceptors().add((request, body, execution) -> {
            request.getHeaders().add("Authorization", "Bearer " + openApiKey);
            return execution.execute(request, body);
        });
       return resttemplate;
    }

}

