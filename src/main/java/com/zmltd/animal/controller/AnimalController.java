package com.zmltd.animal.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zmltd.animal.entity.Animal;
import com.zmltd.animal.service.AnimalService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/Animal")

public class AnimalController {

    private final AnimalService animalService ;

    public AnimalController(AnimalService animalService ){

        this.animalService = animalService;
    }

    //POST request
    @PostMapping("/saveAnimal")
    public Animal animal(@RequestBody Animal animal) {
        
        
        return animalService.saveAnimal(animal);
    }
    //put request
    @PutMapping("add/{id}")
    public String updateAnimal( @RequestBody Animal animal, @PathVariable("id") int id) {
       
        
        return animalService.updateAnimal(id, animal);
    }

    //Delete Request
    @DeleteMapping("delete/{id}")
    public String deleteAnimal(@PathVariable("id") int id ){
        return animalService.deleteAnimal(id);
    }



}
