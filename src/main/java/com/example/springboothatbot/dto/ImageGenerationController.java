package com.example.springboothatbot.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ImageGenerationController {

    @Autowired
    private OpenAIImageGenerator imageGenerator;

    @GetMapping("/generate-image/{prompt}")
    public String generateImage(@PathVariable String prompt) {
        try {
            String imageUrl = imageGenerator.generateImage(prompt);
            return imageUrl;
        } catch (Exception e) {
            // Handle any exceptions or errors that occur during image generation
            return "Error generating image: " + e.getMessage();
        }
    }
}
