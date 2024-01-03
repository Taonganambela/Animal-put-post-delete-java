package com.zmltd.animal.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.zmltd.animal.entity.Animal;

@Repository

public interface AnimalRepo extends JpaRepository <Animal, Integer> {

}
