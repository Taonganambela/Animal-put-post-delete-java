package com.zmltd.animal.service;

import java.util.Optional;
import org.springframework.stereotype.Service;
import com.zmltd.animal.entity.Animal;
import com.zmltd.animal.repo.AnimalRepo;

@Service

public class AnimalService {

    public final AnimalRepo animalRepo;
    String message = null;
    public AnimalService(AnimalRepo animalRepo){
        this.animalRepo = animalRepo;
    }

    public Animal saveAnimal(Animal animal){

        Animal animal1 = new Animal(); 
        animal1.setName(animal.getName());
        animal1.setColor(animal.getColor());
        animal1.setHieght(animal.getHieght());
        animal1.setWeight(animal.getWeight());
        animal1.setAlive(animal.isAlive());
        return animalRepo.save(animal1);
        
    }

    public String updateAnimal(int id, Animal animal){

        Optional<Animal> theAnimal = animalRepo.findById(id);
        theAnimal.ifPresentOrElse(a -> {
            a.setName(animal.getName());
            a.setColor(animal.getColor());
            a.setWeight(animal.getWeight());
            a.setHieght(animal.getHieght());
            a.setAlive(animal.isAlive());


            animalRepo.save(a);
            message = "Animal Updated";
           
        }
        ,() -> {
            message = "Animal Not Updated";
        }
        
        );

        return message;
    }

    public String deleteAnimal(int id) {
        String response = "failed to delete";
          Optional<Animal> animal = animalRepo.findById(id);
          if(animal.isPresent()) {
              
              animalRepo.deleteById(id);
              response = "Book Deleted Succesful";
  
          }                                                        
         
          return response;

        }

}
