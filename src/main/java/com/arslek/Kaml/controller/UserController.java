package com.arslek.Kaml.controller;

import com.arslek.Kaml.dto.UserDto;
import com.arslek.Kaml.service.UserService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("crud")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("user")
    public UserDto upsert(@RequestBody UserDto dto) {
        return userService.create(dto);
    }

    @GetMapping("user/{id}")
    public UserDto read(@PathVariable Long id) {
        return userService.read(id);
    }

    @PutMapping("user/{id}")
    public UserDto update(@PathVariable Long id, @RequestBody UserDto dto) {
        return userService.update(id, dto);
    }

    @DeleteMapping("user/{id}")
    public void delete(@PathVariable Long id) {
        userService.delete(id);
    }

}
