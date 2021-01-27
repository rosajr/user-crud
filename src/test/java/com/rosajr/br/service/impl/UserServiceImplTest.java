package com.rosajr.br.service.impl;

import com.rosajr.br.dto.AddressDTO;
import com.rosajr.br.dto.UserDTO;
import com.rosajr.br.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@Transactional
public class UserServiceImplTest {

    @Autowired
    private UserService userService;

    @Test
    void shouldBeRegisterUser() {

        var addressDTO = AddressDTO.builder()
                .cityIbge(1302603)
                .complement("Em frente a Igreja")
                .neighborhood("Parque Dez")
                .zipCode("69050445")
                .number(45)
                .street("Rua Billie Holiday")
                .build();

        var userDTO = UserDTO.builder()
                .address(addressDTO)
                .cpf("93213786268")
                .email("jrrosa@live.com")
                .password("123456")
                .phone("92993311031")
                .build();

        var user = userService.register(userDTO);

        assertNotNull(user);
        assertNotNull(user.getId());
        assertNotNull(user.getAddress());
        assertNotNull(user.getCpf());
        assertNotNull(user.getEmail());
        assertNotNull(user.getPhone());
        assertNotNull(user.getPassword());

    }
}
