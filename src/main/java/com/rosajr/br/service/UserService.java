package com.rosajr.br.service;

import com.rosajr.br.domain.User;
import com.rosajr.br.dto.UserDTO;

public interface UserService {
    User register(UserDTO dto);

    User update(UserDTO dto, Long id);
}
