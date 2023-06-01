package com.example.springboothatbot.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ChatGPTRequest {

    private String model;
    private List<Message> messages;

    private List<Messages> messagesList;;

    public ChatGPTRequest(String model, String prompt) {
        this.model = model;
        this.messages = new ArrayList<>();
        this.messages.add(new Message("user",prompt));
    }

    public  ChatGPTRequest(String model, ImageRequest imageRequest) {
        this.model = model;
        this.messagesList = new ArrayList<>();
        this.messagesList.add(new Messages("user",imageRequest));
    }
}
