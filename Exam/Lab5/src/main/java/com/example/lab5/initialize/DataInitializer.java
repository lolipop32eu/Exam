package com.example.lab5.initialize;

import com.example.lab5.entity.Country;
import com.example.lab5.entity.User;
import com.example.lab5.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner { //инициализатор, добавляет 5 пользователей в таблицу
    private final UserRepository userRepository;

    public DataInitializer(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) {

        User user1 = User.builder()
                .firstName("Vitaliy")
                .age(12)
                .country(Country.RUSSIA)
                .build();

        User user2 = User.builder()
                .firstName("Pedro")
                .age(50)
                .country(Country.BRAZIL)
                .build();
        User user3 = User.builder()
                .firstName("Ghandi")
                .age(33)
                .country(Country.INDIA)
                .build();
        User user4 = User.builder()
                .firstName("Mao")
                .age(78)
                .country(Country.CHINA)
                .build();
        User user5 = User.builder()
                .firstName("Tomas")
                .age(39)
                .country(Country.SOUTH_AFRICA)
                .build();
        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);
        userRepository.save(user4);
        userRepository.save(user5);
    }
}
