package com.example.lab5.service;



import com.example.lab5.entity.Country;
import com.example.lab5.entity.User;
import com.example.lab5.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor// здесь нужен конструктор т.к. поле final
public class UserService {

    private final UserRepository userRepository;



    public User addUser(User user){
        return userRepository.save(user);
    }

    public List<User> findAllUsers(){
        //...
        return userRepository.findAll();
    }
    public List<User> findAllByCountry(Country country){
        //...
        return userRepository.findByCountryNotOrderByAgeAsc(country);
    }


}
