package com.rickard.rain_boot_webshop.services;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.rickard.rain_boot_webshop.dtos.PictureDto;
import com.rickard.rain_boot_webshop.dtos.UmbrellaDto;
import com.rickard.rain_boot_webshop.enums.Color;
import com.rickard.rain_boot_webshop.models.Picture;
import com.rickard.rain_boot_webshop.models.Umbrella;
import com.rickard.rain_boot_webshop.repositories.UmbrellaRepository;

/* https://www.youtube.com/watch?v=XVFqOFKGeGM */
@ExtendWith(MockitoExtension.class)
public class UmbrellaServiceTest {
    
    @Mock 
    UmbrellaRepository umbrellaRepository;

    @InjectMocks 
    UmbrellaService umbrellaService;

    @Test 
    void getAllUmbrellasShouldReturnListOfUmbrellaDto() {

        Umbrella umbrella = new Umbrella("Paraply", 200, Color.GREEN);
        umbrella.setProductId(1L);
        Picture picture = new Picture("bild", umbrella);
        List<Picture> pictures = new ArrayList<>();
        pictures.add(picture);
        umbrella.setPictures(pictures);
        List<Umbrella> umbrellas = new ArrayList<>();
        umbrellas.add(umbrella);

        PictureDto pictureDto = new PictureDto("bild");
        List<PictureDto> pictureDtos = new ArrayList<>();
        pictureDtos.add(pictureDto);
        UmbrellaDto umbrellaDto = new UmbrellaDto(1L, "Paraply", 200, Color.GREEN, pictureDtos);
        List<UmbrellaDto> umbrellaDtos = new ArrayList<>();
        umbrellaDtos.add(umbrellaDto);

        Mockito.when(umbrellaRepository.findAll()).thenReturn(umbrellas);
        Assertions.assertEquals(umbrellaDtos, umbrellaService.getAllUmbrellas());
    }

    @Test 
    void convertUmbrellaToUmbrellaDtoShouldReturnUmbrellaDtoWithCorrectValues() {

        Umbrella umbrella = new Umbrella("Paraply", 200, Color.GREEN);
        umbrella.setProductId(1L);
        List<Picture> pictures = new ArrayList<>();
        umbrella.setPictures(pictures);

        List<PictureDto> pictureDtos = new ArrayList<>();
        UmbrellaDto umbrellaDto = new UmbrellaDto(1L, "Paraply", 200, Color.GREEN, pictureDtos);

        Assertions.assertEquals(umbrellaDto, umbrellaService.convertUmbrellaToUmbrellaDto(umbrella));
    }


}
