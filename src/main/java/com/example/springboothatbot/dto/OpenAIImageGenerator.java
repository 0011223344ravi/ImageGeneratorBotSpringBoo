package com.example.springboothatbot.dto;

import com.fasterxml.jackson.core.JsonParser;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

@Component
public class OpenAIImageGenerator {

    private static final String API_KEY = "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";

    public String generateImage(String prompt) throws Exception {
        String apiUrl = "https://api.openai.com/v1/images/generations";

        // Create HTTP client
        HttpClient httpClient = HttpClientBuilder.create().build();

        // Create POST request
        HttpPost request = new HttpPost(apiUrl);

        // Set headers
        request.setHeader(HttpHeaders.AUTHORIZATION, "Bearer " + API_KEY);
        request.setHeader(HttpHeaders.CONTENT_TYPE, "application/json");

        // Set request body (prompt)
        String requestBody = "{\"prompt\": \"" + prompt + "\"}";
        request.setEntity(new StringEntity(requestBody));

        // Send the request
        HttpResponse response = httpClient.execute(request);

        // Get the response body
        HttpEntity responseEntity = response.getEntity();
        String responseBody = EntityUtils.toString(responseEntity);

        // Extract the generated image URL from the response
        // You may need to parse the JSON response depending on its structure
     // return responseBody;
        return getUrl(responseBody);
    }

    private String getUrl(String response) {
        // Create an instance of the Gson class
        Gson gson = new Gson();

        // Convert the string to a JsonObject
        JsonObject jsonObject = gson.fromJson(response, JsonObject.class);

        // Extract the value of a specific key (e.g., "name")
        JsonArray hmResult =  jsonObject.getAsJsonArray("data");
        String str = hmResult.get(0).getAsJsonObject().get("url").toString();
        return str;
    }

    /*private String extractImageUrl(String responseBody) {
        // Implement your logic to parse the JSON response and extract the image URL
        // This will depend on the structure of the response returned by the OpenAI API
        // You can use a JSON library like Jackson or Gson for parsing JSON responses
        // Return the extracted image URL

        // Sample implementation (assuming the response structure is simple)
        // JSON response structure: {"image_url": "https://example.com/image.jpg"}
        JsonObject responseJson = new JsonParser().parse(responseBody).getAsJsonObject();
        String imageUrl = responseJson.get("image_url").getAsString();
        return imageUrl;
    }*/
}

