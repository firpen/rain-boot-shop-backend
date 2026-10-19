package com.rickard.rain_boot_webshop.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.rickard.rain_boot_webshop.dtos.PictureDto;
import com.rickard.rain_boot_webshop.dtos.RainBootDto;
import com.rickard.rain_boot_webshop.enums.Color;
import com.rickard.rain_boot_webshop.enums.ShaftHeight;
import com.rickard.rain_boot_webshop.models.Picture;
import com.rickard.rain_boot_webshop.models.RainBoot;
import com.rickard.rain_boot_webshop.repositories.RainBootRepository;

/* https://www.youtube.com/watch?v=XVFqOFKGeGM */
@ExtendWith(MockitoExtension.class)
public class RainBootServiceTest {

    @Mock 
    RainBootRepository rainBootRepository;

    @InjectMocks 
    RainBootService rainBootService;

    @Test
    void getAllRainBootsShouldReturnListOfRainBootDto() {

        RainBoot newRainboot = new RainBoot("Stövel", 100, ShaftHeight.MEDIUM, 42, Color.GREEN);
        newRainboot.setProductId(1L);
        List<Picture> pictures = new ArrayList<>();
        newRainboot.setPictures(pictures);
        List<RainBoot> rainBoots = new ArrayList<>();
        rainBoots.add(newRainboot);

        List<PictureDto> pictureDtos = new ArrayList<>();
        List<RainBootDto> rainBootDtos = new ArrayList<>();
        RainBootDto rainBootDto = new RainBootDto(1L, "Stövel", ShaftHeight.MEDIUM, 42, Color.GREEN, 100, pictureDtos);
        rainBootDtos.add(rainBootDto);

        Mockito.when(rainBootRepository.findAll()).thenReturn(rainBoots);
        Assertions.assertEquals(rainBootDtos, rainBootService.getAllRainBoots());
    } 

    @Test 
    void convertRainBootToRainBootDtoShouldReturnRainBootDtoWithCorrectValues() {

        RainBoot rainBoot = new RainBoot("Stövel", 100, ShaftHeight.MEDIUM, 42, Color.GREEN);
        rainBoot.setProductId(1L);
        List<Picture> pictures = new ArrayList<>();
        Picture picture = new Picture("bild", rainBoot);
        pictures.add(picture);
        rainBoot.setPictures(pictures);

        List<PictureDto> pictureDtos = new ArrayList<>();
        PictureDto pictureDto = new PictureDto("bild");
        pictureDtos.add(pictureDto);
        RainBootDto rainBootDto = new RainBootDto(1L, "Stövel", ShaftHeight.MEDIUM, 42, Color.GREEN, 100, pictureDtos);

        Assertions.assertEquals(rainBootDto, rainBootService.convertRainBootToRainBootDto(rainBoot));
    }

    @Test 
    void getRainBootByIdShouldReturnsRainBootDtoWithCorrectValues() {

        RainBoot rainBoot = new RainBoot("Stövel", 100, ShaftHeight.MEDIUM, 42, Color.GREEN);
        rainBoot.setProductId(1L);
        List<Picture> pictures = new ArrayList<>();
        Picture picture = new Picture("bild", rainBoot);
        pictures.add(picture);
        rainBoot.setPictures(pictures);
        Optional<RainBoot> optionalRainboot = Optional.of(rainBoot);

        List<PictureDto> pictureDtos = new ArrayList<>();
        PictureDto pictureDto = new PictureDto("bild");
        pictureDtos.add(pictureDto);
        RainBootDto rainBootDto = new RainBootDto(1L, "Stövel", ShaftHeight.MEDIUM, 42, Color.GREEN, 100, pictureDtos);

        Mockito.when(rainBootRepository.findById(1L)).thenReturn(optionalRainboot);
        Assertions.assertEquals(rainBootDto, rainBootService.getRainBootById(1L));
    }

}
