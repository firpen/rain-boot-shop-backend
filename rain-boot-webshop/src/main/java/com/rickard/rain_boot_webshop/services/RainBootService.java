package com.rickard.rain_boot_webshop.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.rickard.rain_boot_webshop.dtos.PictureDto;
import com.rickard.rain_boot_webshop.dtos.RainBootDto;
import com.rickard.rain_boot_webshop.exceptions.ProductNotFoundException;
import com.rickard.rain_boot_webshop.models.Picture;
import com.rickard.rain_boot_webshop.models.RainBoot;
import com.rickard.rain_boot_webshop.repositories.RainBootRepository;

@Service
public class RainBootService {

    private final RainBootRepository rainBootRepository;

    public RainBootService(RainBootRepository rainBootRepository) {
        this.rainBootRepository = rainBootRepository;
    }

    public List<RainBootDto> getAllRainBoots() {
        List<RainBoot> rainboots = rainBootRepository.findAll();
        List<RainBootDto> rainbootDtos = new ArrayList<>();
        for (RainBoot rainboot : rainboots) {
            RainBootDto rainbootDto = convertRainBootToRainBootDto(rainboot);
            rainbootDtos.add(rainbootDto);
        }
        return rainbootDtos;
    }

    public RainBootDto getRainBootById(Long id) {
        Optional<RainBoot> optionalRainboot = rainBootRepository.findById(id);
        if (optionalRainboot.isEmpty()) {
            throw new ProductNotFoundException();
        }
        RainBoot rainboot = optionalRainboot.get();
        RainBootDto rainbootDto = convertRainBootToRainBootDto(rainboot);
        return rainbootDto;
    }

    private RainBootDto convertRainBootToRainBootDto(RainBoot rainboot) {
        List<Picture> pictures = rainboot.getPictures();
        List<PictureDto> pictureDtos = new ArrayList<>();
        for (Picture picture : pictures) {
            PictureDto pictureDto = new PictureDto(picture.getImg());
            pictureDtos.add(pictureDto);
        }
        RainBootDto rainbootDto = new RainBootDto(rainboot.getProductId(), rainboot.getProductName(),
                rainboot.getShaftHeight(), rainboot.getSize(), rainboot.getColor(), rainboot.getPrice(), pictureDtos);
        return rainbootDto;
    }
}
