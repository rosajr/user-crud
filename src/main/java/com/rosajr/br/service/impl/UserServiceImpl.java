package com.rosajr.br.service.impl;

import com.rosajr.br.domain.User;
import com.rosajr.br.dto.UserDTO;
import com.rosajr.br.exceptions.ObjectNotFoundException;
import com.rosajr.br.repository.UserRepository;
import com.rosajr.br.service.AddressService;
import com.rosajr.br.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AddressService addressService;

    @Override
    public User register(UserDTO dto) {

        var address = addressService.register(dto.getAddress());

        var password = new BCryptPasswordEncoder().encode(dto.getPassword()).getBytes();

        var user = User.builder()
                .address(address)
                .cpf(dto.getCpf())
                .email(dto.getEmail())
                .phone(dto.getPhone())
                .name(dto.getName())
                .password(password).build();

        userRepository.save(user);

        return user;
    }

    @Override
    public User update(UserDTO dto, Long id) {

        var user = findById(id);

        var address = addressService.update(user.getAddress(), dto.getAddress());

        user.setAddress(address);
        user.setCpf(dto.getCpf());
        user.setEmail(dto.getEmail());
        user.setPhone(dto.getPhone());
        user.setName(dto.getName());

        if (dto.getPassword() != null)
            user.setPassword(new BCryptPasswordEncoder().encode(dto.getPassword()).getBytes());

        userRepository.save(user);

        return user;
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Usuário não encontrado"));
    }
}