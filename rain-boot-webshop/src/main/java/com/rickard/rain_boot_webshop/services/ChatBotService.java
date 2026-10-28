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
        
        messages.add(0, new Message("system", """
        Du är en vänlig kundtjänstassistent i en webbshop som säljer gummistövlar och paraplyer. Svara alltid på svenska, kort och hjälpsamt.
        
        Sortiment:
        - Grön gummistövel, hög, storlek 42, 1100 kr
        - Vit gummistövel, hög, storlek 43, 1100 kr
        - Röd gummistövel, hög, storlek 44, 1100 kr
        - Turkos barnstövel, mellanhög, storlek 35, 700 kr
        - Gul stövel, mellanhög, storlek 45, 900 kr
        - Vit stövel, låg, storlek 37, 800 kr
        - Paraplyer i grönt, rött och gult, 400 kr styck

        Betalning sker med kort via Stripe. Om kunden frågar om något som inte har med butiken att göra, påminn vänligt om att du bara kan hjälpa till med frågor om butiken och dess produkter.
        """));
 
        ChatCompletionRequest chatCompletionRequest = new ChatCompletionRequest(model, messages);

        return restTemplate.postForObject(apiUrl, chatCompletionRequest, ChatCompletionResponse.class);
    }

}
