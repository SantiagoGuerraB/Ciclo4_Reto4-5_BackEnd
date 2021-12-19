package com.usa.edu.co.ciclo4_reto2.repository;

import com.usa.edu.co.ciclo4_reto2.model.User;
import com.usa.edu.co.ciclo4_reto2.repository.crud.UserCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository {

    @Autowired
    private UserCrudRepository userCrudRepository;

    public List<User> getAll() {
        return userCrudRepository.findAll();
    }

    public Optional<User> getUser(int id) {
        return userCrudRepository.findById(id);
    }

    public Optional<User> lastUserId(){
        return userCrudRepository.findTopByOrderByIdDesc();
    }

    public boolean existEmail(String email){
        Optional<User> usuario = userCrudRepository.findByEmail(email);

        return !usuario.isEmpty();
    }

    public Optional<User> authenticateUser(String email, String password){
        return userCrudRepository.findByEmailAndPassword(email, password);
    }

    public User create(User user){
        return userCrudRepository.save(user);
    }

    public void update(User user){
        userCrudRepository.save(user);
    }

    public void delete(User user){
        userCrudRepository.delete(user);
    }
    public List<User> listBirthtDayMonth(String month){
        return userCrudRepository.findByMonthBirthtDay(month);
    }

}
