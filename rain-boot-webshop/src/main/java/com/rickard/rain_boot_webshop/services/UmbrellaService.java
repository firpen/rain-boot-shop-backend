package com.rickard.rain_boot_webshop.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.rickard.rain_boot_webshop.dtos.PictureDto;
import com.rickard.rain_boot_webshop.dtos.UmbrellaDto;
import com.rickard.rain_boot_webshop.exceptions.ProductNotFoundException;
import com.rickard.rain_boot_webshop.models.Picture;
import com.rickard.rain_boot_webshop.models.Umbrella;
import com.rickard.rain_boot_webshop.repositories.UmbrellaRepository;

@Service 
public class UmbrellaService {
    
    private final UmbrellaRepository umbrellaRepository;

    public UmbrellaService(UmbrellaRepository umbrellaRepository) {
        this.umbrellaRepository = umbrellaRepository;
    }

    public List<UmbrellaDto> getAllUmbrellas() {
        List<Umbrella> umbrellas = umbrellaRepository.findAll();
        List<UmbrellaDto> umbrellaDtos = new ArrayList<>();
        for (Umbrella umbrella : umbrellas) {
           UmbrellaDto umbrellaDto = convertUmbrellaToUmbrellaDto(umbrella);
            umbrellaDtos.add(umbrellaDto);
        }
        return umbrellaDtos;
    }

    public UmbrellaDto getUmbrellaById(Long id) {
        Optional<Umbrella> optionalUmbrella = umbrellaRepository.findById(id);
        if (optionalUmbrella.isEmpty()) {
            throw new ProductNotFoundException();
        }
        Umbrella umbrella = optionalUmbrella.get();
        UmbrellaDto umbrellaDto = convertUmbrellaToUmbrellaDto(umbrella);
        return umbrellaDto;
    }

    private UmbrellaDto convertUmbrellaToUmbrellaDto(Umbrella umbrella) {
        List<PictureDto> pictureDtos = new ArrayList<>();
        for (Picture picture : umbrella.getPictures()) {
            PictureDto pictureDto = new PictureDto(picture.getImg());
            pictureDtos.add(pictureDto);
        }
        UmbrellaDto umbrellaDto = new UmbrellaDto(umbrella.getProductId(), umbrella.getProductName(), umbrella.getPrice(), umbrella.getColor(), pictureDtos);
        return umbrellaDto;
    }

}
