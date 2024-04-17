package net.javaguides.mpp.mapper;

import net.javaguides.mpp.dto.CatDto;
import net.javaguides.mpp.entity.Cat;

public class CatMapper {
    public static CatDto mapToCatDto(Cat cat){
        return new CatDto(
                cat.getId(),
                cat.getName(),
                cat.getDescription(),
                cat.getColor(),
                cat.getAge()

        );
    }
    public static Cat mapToCat(CatDto catDto){
        return new Cat(
                catDto.getId(),
                catDto.getName(),
                catDto.getDescription(),
                catDto.getColor(),
                catDto.getAge()
        );
    }
}
