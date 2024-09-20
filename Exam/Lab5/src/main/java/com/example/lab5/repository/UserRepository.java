package com.example.lab5.repository;



import com.example.lab5.entity.Country;
import com.example.lab5.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;


public interface UserRepository extends Repository<User, Long> { //repository - просто метка
    //CRUD

 List<User> findAll();// этот метод мы не задаем так как это интерфейс, спринг сам понимает по какому полю искать
 User save(User user); //  добавление в таблицу
 List<User> findByCountryNotOrderByAgeAsc(Country country);
}
