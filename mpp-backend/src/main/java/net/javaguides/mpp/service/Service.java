package net.javaguides.mpp.service;


import net.javaguides.mpp.dto.CatDto;
import net.javaguides.mpp.entity.Cat;
import net.javaguides.mpp.mapper.CatMapper;
import net.javaguides.mpp.repository.IRepository;
import net.javaguides.mpp.repository.Repository;
import net.javaguides.mpp.validator.Validator;

import java.util.List;

@org.springframework.stereotype.Service
public class Service {
    private final IRepository repo;

    public Service(){
        this.repo = new Repository();
    }

    public CatDto addCat(CatDto catDto){
        Cat cat = new Cat(repo.getNextId(), catDto.getName(), catDto.getDescription(), catDto.getColor(), catDto.getAge());
        Validator.validate(cat);
        repo.add(cat);
        return CatMapper.mapToCatDto(cat);
    }

    public CatDto getCatById(Integer id){
        if (!repo.exists(id)){
            throw new RuntimeException("Cat with id "+ id + " not found!");
        }
        Cat cat = (Cat) repo.getById(id);
        return CatMapper.mapToCatDto(cat);
    }
    public List<CatDto> getAllCats(){
        List<Cat> cats = repo.getAll();
        return cats.stream().map(CatMapper::mapToCatDto).toList();
    }

    public CatDto updateCat(Integer id, CatDto catDto){
        if(!repo.exists(id)){
            throw new RuntimeException("Cat with id "+ id + " doesn't exist!");}
            Cat updatedCat = CatMapper.mapToCat(catDto);
            updatedCat.setId(id);
            Validator.validate(updatedCat);
            repo.update(id, updatedCat);

            Cat currentCat = (Cat) repo.getById(id);
            return CatMapper.mapToCatDto(currentCat);

    }

    public void deleteCat(Integer id){
        if (!repo.exists(id)){
            throw new RuntimeException("Cat with id "+ id + " doesn't exist!");
        }
        repo.delete(id);
    }


}

    


