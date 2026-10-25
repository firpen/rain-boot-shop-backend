package com.rickard.rain_boot_webshop.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rickard.rain_boot_webshop.dtos.UmbrellaDto;
import com.rickard.rain_boot_webshop.services.UmbrellaService;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RequestMapping("/umbrella")
@RestController 
public class UmbrellaController {
    
    private final UmbrellaService umbrellaService;

    public UmbrellaController(UmbrellaService umbrellaService) {
        this.umbrellaService = umbrellaService;
    }

    @GetMapping()
    public ResponseEntity<List<UmbrellaDto>> getUmbrellas() {
        List<UmbrellaDto> umbrellaDtos = umbrellaService.getAllUmbrellas();
        return ResponseEntity.ok(umbrellaDtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UmbrellaDto> getUmbrellaById(@PathVariable Long id) {
        UmbrellaDto umbrellaDto = umbrellaService.getUmbrellaById(id);
        return ResponseEntity.ok(umbrellaDto);
    }
    
}
