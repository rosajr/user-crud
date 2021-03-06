package com.rosajr.br.controller;

import com.rosajr.br.domain.User;
import com.rosajr.br.dto.UserDTO;
import com.rosajr.br.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    @Autowired
    private UserService userService;

    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping
    public User register(@RequestBody UserDTO dto) {
        return userService.register(dto);
    }

    @ResponseStatus(code = HttpStatus.OK)
    @PutMapping(value = "/{id}")
    public User register(@RequestBody UserDTO dto, @PathVariable Long id) {
        return userService.update(dto, id);
    }

    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping
    public List<User> findAll() {
        return userService.findAll();
    }

    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping(value = "/{id}")
    public User findById(@PathVariable Long id) {
        return userService.findById(id);
    }

    @ResponseStatus(code = HttpStatus.OK)
    @DeleteMapping(value = "/{id}")
    public void deleteById(@PathVariable Long id) {
        userService.delete(id);
    }
}
