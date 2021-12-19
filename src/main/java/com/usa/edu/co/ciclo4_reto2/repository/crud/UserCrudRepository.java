package com.usa.edu.co.ciclo4_reto2.repository.crud;
import com.usa.edu.co.ciclo4_reto2.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;
import java.util.Optional;

public interface UserCrudRepository extends MongoRepository<User, Integer> {

    Optional<User> findByEmail(String email);

    Optional<User> findByEmailAndPassword(String email, String password);

    Optional<User> findTopByOrderByIdDesc();

    List<User> findByMonthBirthtDay(String month);
}
