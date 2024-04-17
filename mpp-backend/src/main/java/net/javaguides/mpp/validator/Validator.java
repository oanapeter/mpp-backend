package net.javaguides.mpp.validator;

import net.javaguides.mpp.entity.Cat;

public class Validator {

    public static void validate(Cat cat){
        if(cat.getId() < 1)
        {
            throw new RuntimeException("Invalid id!");
        }
        if(cat.getName().isEmpty()){
            throw new RuntimeException("Cat name cannot be empty!");
        }
        if(!cat.getName().matches("[a-zA-Z ]+")){
            throw new RuntimeException("Cat name must contain only letters!");
        }
        if(!cat.getColor().matches("[a-zA-Z ]+")){
            throw new RuntimeException("Cat color must contain only letters!");
        }
        if(cat.getDescription().length() < 3){
            throw new RuntimeException("Cat description should be longer than 3 characters!");

        }
        if(cat.getAge() < 0){
            throw new RuntimeException("Cat age cannot be negative!");
        }
    }
}

