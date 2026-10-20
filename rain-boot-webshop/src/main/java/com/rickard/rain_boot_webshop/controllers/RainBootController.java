package com.rickard.rain_boot_webshop.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rickard.rain_boot_webshop.dtos.RainBootDto;
import com.rickard.rain_boot_webshop.services.RainBootService;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequestMapping("/rainboot")
@RestController 
public class RainBootController {

    private final RainBootService rainBootService;
    
    public RainBootController(RainBootService rainBootService) {
        this.rainBootService = rainBootService;
    }

    @GetMapping()
    public ResponseEntity<List<RainBootDto>> getRainBoots() {
        List<RainBootDto> rainBootDtos = rainBootService.getAllRainBoots();
        return ResponseEntity.ok(rainBootDtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RainBootDto> getRainBootById(@PathVariable Long id) {
        RainBootDto rainBootDto = rainBootService.getRainBootById(id);
        return ResponseEntity.ok(rainBootDto);
    }
    
}
