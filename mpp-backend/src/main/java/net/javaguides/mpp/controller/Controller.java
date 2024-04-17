package net.javaguides.mpp.controller;

import lombok.AllArgsConstructor;
import net.javaguides.mpp.dto.CatDto;
import net.javaguides.mpp.service.Service;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/cats")

public class Controller {
    private Service service;

    @PostMapping
    public ResponseEntity<CatDto> addCat(@RequestBody CatDto catDto){
        CatDto addedCat = service.addCat(catDto);
        return new ResponseEntity<>(addedCat, HttpStatus.CREATED);
    }
    @GetMapping("{id}")
    public ResponseEntity<CatDto> getCatById(@PathVariable Integer id){
        CatDto cat = service.getCatById(id);
        return ResponseEntity.ok(cat);
    }

    @GetMapping
    public ResponseEntity<List<CatDto>> getAllCats(){
        List<CatDto> cats = service.getAllCats();
        return ResponseEntity.ok(cats);
    }

    @PutMapping("{id}")
    public ResponseEntity<CatDto> updateCat(@PathVariable Integer id, @RequestBody CatDto catDto){
        CatDto updatedCat = service.updateCat(id, catDto);
        return ResponseEntity.ok(updatedCat);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteCat(@PathVariable Integer id){
        service.deleteCat(id);
        return ResponseEntity.ok("Cat with id "+ id + " deleted successfully!");
    }


}
