package com.example.Wardrobemanager.Service;

import com.example.Wardrobemanager.Model.Shoes;
import com.example.Wardrobemanager.Repository.ShoesRepository;
import com.example.Wardrobemanager.dto.RequestDto.AddShoesRequestDto;
import com.example.Wardrobemanager.dto.ResponseDto.AddShoesResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShoesService {
    @Autowired
    ShoesRepository shoesRepository;

    public AddShoesResponseDto addShoes(AddShoesRequestDto addShoesRequestDto) {
        Shoes shoes = new Shoes();
        shoes.setColor(addShoesRequestDto.getColor());
        shoes.setName(addShoesRequestDto.getName());
        shoes.setGenre(addShoesRequestDto.getGenre());
        shoes.setGender(addShoesRequestDto.getGender());
        shoes.setColor_type(addShoesRequestDto.getColor_type());

        Shoes savedShoes = shoesRepository.save(shoes);

        AddShoesResponseDto addShoesResponseDto = new AddShoesResponseDto();
        addShoesResponseDto.setName(savedShoes.getName());
        addShoesResponseDto.setGenre(savedShoes.getGenre());
        addShoesResponseDto.setMessage("Congrats! Your "+savedShoes.getName() + " is Added");

        return addShoesResponseDto;
    }
}
