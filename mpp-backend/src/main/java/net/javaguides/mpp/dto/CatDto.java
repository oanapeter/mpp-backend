package net.javaguides.mpp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class CatDto {
    private Integer id;
    private String name;
    private String description;
    private String color;
    private Integer age;
}
