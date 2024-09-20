package com.example.lab5.entity;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Entity
@Table(name = "user1") // имя таблицы user1 т к нельзя использовать имя user
@Transactional
public class User { // это аналог моделей, теперь это сущности. Особенности в данном случае заключается в типах данных
    // типы данных должны быть сериализуемые ТО ЕСТЬ НЕ ПРИМЕТИВНЫЕ, А ССЫЛОЧНЫЕ
    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE)  //если id serial
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "age")
    private Integer age;
    @Enumerated(EnumType.STRING) //эта операция конвертирует название в строку
    private Country country;
    }