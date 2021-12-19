package com.usa.edu.co.ciclo4_reto2.repository.crud;

import com.usa.edu.co.ciclo4_reto2.model.Laptop;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;
import java.util.List;

public interface LaptopCrudRepository extends MongoRepository<Laptop, Integer> {

    Optional<Laptop> findTopByOrderByIdDesc();

    //Reto 5
    public List<Laptop> findByPriceLessThanEqual(double precio);

    @Query("{'description':{'$regex':'?0','$options':'i'}}")
    public List<Laptop> findByDescriptionLike(String description);
}
