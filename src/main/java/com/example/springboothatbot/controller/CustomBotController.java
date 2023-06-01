package com.example.springboothatbot.controller;

import com.example.springboothatbot.dto.ChatGPTRequest;
import com.example.springboothatbot.dto.ChatGPTResponse;
import com.example.springboothatbot.dto.ImageReponse;
import com.example.springboothatbot.dto.ImageRequest;
import org.apache.http.HttpEntity;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.awt.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Optional;

import static org.springframework.http.HttpMethod.*;

@RestController
@RequestMapping("/bot")
public class CustomBotController {

    @Value("${openai.model}")
    private String model;

    @Value(("${openai.api.url1}"))
    private String apiURL;

    @Autowired
    private RestTemplate template;

    @GetMapping("/chat")
    public String chat(@RequestParam("prompt") String prompt){
        ChatGPTRequest request=new ChatGPTRequest(model, prompt);
        ChatGPTResponse chatGptResponse = template.postForObject(apiURL, request, ChatGPTResponse.class);
        return chatGptResponse.getChoices().get(0).getMessage().getContent();
    }

   /* @PostMapping("/chatImage")
    public ImageReponse chatImage(@RequestBody ImageRequest  imageRequest){
        ChatGPTRequest request=new ChatGPTRequest(model, imageRequest);
        ImageReponse imageReponse = template.exchange( apiURL,request);
        return imageReponse;
    }*/

    @PostMapping(value = "/generate-image")
    public String generateImage(@RequestBody ImageRequest imageRequest , @RequestHeader HashMap<String,String> reqHeader) throws IOException {

    ResponseEntity<ImageReponse> imageReponse  = template.postForEntity(apiURL, imageRequest, ImageReponse.class,reqHeader);
   String str  = imageReponse.getBody().getData().get(0).get("url").toString();
  return  str;

    }
}
