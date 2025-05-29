package projetogpt.chatgpt.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChatGptResponse {


    public void setChoices(ArrayList<Choice> choices) {
        this.choices = choices;
    }

    private ArrayList<Choice> choices;

        @AllArgsConstructor
        @NoArgsConstructor
        public static class Choice {
            private int index;
            private Message message;

            public int getIndex() {
                return index;
            }

            public void setIndex(int index) {
                this.index = index;
            }

            public Message getMessage() {
                return message;
            }

            public void setMessage(Message message) {
                this.message = message;
            }
        }

    public ArrayList<Choice> getChoices() {
        return choices;
    }
    }

