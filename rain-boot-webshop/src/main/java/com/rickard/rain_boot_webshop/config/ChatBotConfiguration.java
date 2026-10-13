package com.rickard.rain_boot_webshop.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/* https://next.plugga.tech/kurs/openai-api-med-java?l=openai-api-med-java-intro&cu=/kurser&s=skip */
@Configuration 
public class ChatBotConfiguration {
    
    @Value("${openai.apiKey}")
    private String openaiApiKey;

    @Bean 
    public RestTemplate openAirestTemplate() {
        
        RestTemplate restTemplate = new RestTemplate();

        restTemplate.getInterceptors().add((request, body, execution) -> {
            request.getHeaders().add("Authorization", "Bearer " + openaiApiKey);
            return execution.execute(request, body);
        });
        
        return restTemplate;
    }

}
