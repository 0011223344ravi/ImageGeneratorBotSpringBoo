/*
package com.example.springboothatbot.dto;

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
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service

public class ChatGPTService {

 @Value("${openai.api.url1}")
 private String url ;


        // Create HTTP client
        HttpClient httpClient = HttpClientBuilder.create().build();

        // Create POST request
        HttpPost request = new HttpPost(url);

        // Set headers


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
}
*/
