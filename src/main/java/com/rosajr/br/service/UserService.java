package com.rosajr.br.service;

import com.rosajr.br.domain.User;
import com.rosajr.br.dto.UserDTO;

import java.util.List;

public interface UserService {
    User register(UserDTO dto);

    User update(UserDTO dto, Long id);

    void delete(Long id);

    List<User> findAll();

    User findById(Long id);

}