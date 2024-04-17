package net.javaguides.mpp.tests;
import net.javaguides.mpp.dto.CatDto;
import net.javaguides.mpp.service.Service;

import java.util.List;
import java.util.Objects;

@org.springframework.stereotype.Service
public class ServiceTest {
    private static Service service;

    public static void allTests(){
        testAdd();
        testGetById();
        testGetAll();
        testUpdateCat();
        testDeleteCat();

        System.out.println("Service tests passed.");
    }

    private static void testAdd(){
        service = new Service();
        CatDto catDtoInvalidName = new CatDto(1, "Mittens123", "Playful kitty.", "black", 4);
        CatDto catDtoInvalidDescription = new CatDto(1, "Mittens", "P", "black", 4);
        CatDto catDtoInvalidColor = new CatDto(1, "Mittens", "Playful kitty.", "black123", 4);
        CatDto catDtoInvalidAge = new CatDto(1, "Mittens", "Playful kitty.", "black", -4);

        try{
            service.addCat(catDtoInvalidName);

        }
        catch (RuntimeException e){
            assert e.getMessage().equals("Cat name must contain only letters!");
        }

        try{
            service.addCat(catDtoInvalidDescription);

        }
        catch (RuntimeException e){
            assert e.getMessage().equals("Cat description should be longer than 3 characters!");
        }

        try{
            service.addCat(catDtoInvalidColor);

        }
        catch (RuntimeException e){
            assert e.getMessage().equals("Cat color must contain only letters!");
        }

        try{
            service.addCat(catDtoInvalidAge);

        }
        catch (RuntimeException e){
            assert e.getMessage().equals("Cat age cannot be negative!");
        }

    }

    private static void testGetById(){
        service = new Service();
        try{
            service.getCatById(100);
        }
        catch (RuntimeException e){
            assert e.getMessage().equals("Cat with id 100 not found!");
        }

        CatDto catDto = service.getCatById(1);
        assert catDto.getId() == 1;
    }

    private static void testGetAll(){
        service = new Service();
        List<CatDto> cats = service.getAllCats();
        assert cats.size() == 11;
    }

    private static void testUpdateCat(){
        service = new Service();
        CatDto cat = service.getCatById(1);
        assert Objects.equals(cat.getName(), "Mittens");

        CatDto newCatDtoInvalidName = new CatDto(1, "Mittens123", "Playful kitty.", "black", 4);
        CatDto newCatDtoInvalidDescription = new CatDto(1, "Mittens", "P", "black", 4);
        CatDto newCatDtoInvalidColor = new CatDto(1, "Mittens", "Playful kitty.", "black123", 4);
        CatDto newCatDtoInvalidAge = new CatDto(1, "Mittens", "Playful kitty.", "black", -4);
        CatDto newCatDtoValid = new CatDto(1, "Mittensmi", "Playful kitty.", "black", 4);

        try{
            service.updateCat(1, newCatDtoInvalidName);
        }
        catch (RuntimeException e){
            assert e.getMessage().equals("Cat name must contain only letters!");
        }

        try{
            service.updateCat(1, newCatDtoInvalidDescription);
        }
        catch (RuntimeException e){
            assert e.getMessage().equals("Cat description should be longer than 3 characters!");
        }

        try{
            service.updateCat(1, newCatDtoInvalidColor);
        }
        catch (RuntimeException e){
            assert e.getMessage().equals("Cat color must contain only letters!");
        }

        try{
            service.updateCat(1, newCatDtoInvalidAge);
        }
        catch (RuntimeException e){
            assert e.getMessage().equals("Cat age cannot be negative!");
        }

        CatDto updatedCat = service.updateCat(1, newCatDtoValid);
        assert Objects.equals(updatedCat.getName(), "Mittensmi");
    }

    private static void testDeleteCat(){
        service = new Service();
        try{
            service.deleteCat(50);
        }
        catch (RuntimeException e){
            assert e.getMessage().equals("Cat with id 50 doesn't exist!");
        }

        service.deleteCat(1);
        assert service.getAllCats().size() == 10;
    }


}
