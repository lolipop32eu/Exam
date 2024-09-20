package com.example.lab5.controller;



import com.example.lab5.entity.Country;
import com.example.lab5.entity.User;
import com.example.lab5.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/user-api") // сюда пишем дополнительный адрес который будет перед основным /v1/test
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

   @GetMapping("/test") // задаем специальный адрес страницы в браузере(в данном случае localhost:8080/test)(GET метод)
   public ModelAndView test(ModelAndView moduleAndView){
       moduleAndView.setViewName("/templates/main.html"); // по этому адресу нашли страницу
        return moduleAndView;
    }
    @ResponseBody // не возвращаем представление, а наполнение
    @GetMapping("/v1/users")
    public List<User> findAllUsers(){
      return userService.findAllUsers();
    }

    @ResponseBody // не возвращаем представление, а наполнение
    @GetMapping("/v1/additional-info")
    public List<User> getUsersByStatus(@RequestParam Country country) {
        return userService.findAllByCountry(country);
    }

    @PostMapping("/v1/users")
    public String addUser(@RequestBody User user){
       userService.addUser(user);
       return "Пользователь добавлен:" + user;
    }

}
