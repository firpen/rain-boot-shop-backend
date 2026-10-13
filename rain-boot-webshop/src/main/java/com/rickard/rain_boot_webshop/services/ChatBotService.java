package com.rickard.rain_boot_webshop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.rickard.rain_boot_webshop.dtos.ChatCompletionRequest;
import com.rickard.rain_boot_webshop.dtos.ChatCompletionResponse;
import com.rickard.rain_boot_webshop.dtos.Message;

@Service 
public class ChatBotService {

    @Value("${openai.model}")
    String model;

    @Value("${openai.url}")
    String apiUrl;

    private final RestTemplate restTemplate;

    public ChatBotService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ChatCompletionResponse sendChatCompletionRequest(List<Message> messages) {
        
        ChatCompletionRequest chatCompletionRequest = new ChatCompletionRequest(model, messages);

        return restTemplate.postForObject(apiUrl, chatCompletionRequest, ChatCompletionResponse.class);
    }

}
