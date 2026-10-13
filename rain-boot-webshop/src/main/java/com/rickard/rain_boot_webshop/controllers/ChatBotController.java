package com.rickard.rain_boot_webshop.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.rickard.rain_boot_webshop.dtos.ChatCompletionResponse;
import com.rickard.rain_boot_webshop.dtos.Message;
import com.rickard.rain_boot_webshop.services.ChatBotService;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/chat")
@RestController 
public class ChatBotController {

    private final ChatBotService chatBotService;

    public ChatBotController(ChatBotService chatBotService) {
        this.chatBotService = chatBotService;
    }
    
    @PostMapping("")
    public ResponseEntity<Message> postChatMessage(@RequestBody List<Message> messages) {
        
        ChatCompletionResponse response = this.chatBotService.sendChatCompletionRequest(messages);
        try {
            return ResponseEntity.status(HttpStatus.OK).body(response.choices().getFirst().message());
        } catch(Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    

}
