package com.rosajr.br.service.impl;

import com.rosajr.br.dto.AddressDTO;
import com.rosajr.br.service.AddressService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@Transactional
public class AddressServiceImplTest {

    @Autowired
    private AddressService addressService;

    @Test
    void shouldBeRegisterAnAddress() {

        var dto = AddressDTO.builder()
                .cityIbge(1302603)
                .complement("Em frente a Igreja")
                .neighborhood("Parque Dez")
                .zipCode("69050445")
                .number(45)
                .street("Rua Billie Holiday")
                .build();

        var address = addressService.register(dto);

        assertNotNull(address);
        assertNotNull(address.getId());
        assertNotNull(address.getCity());
        assertNotNull(address.getComplement());
        assertNotNull(address.getNeighborhood());
        assertNotNull(address.getNumber());
        assertNotNull(address.getStreet());
        assertNotNull(address.getZipCode());

    }
}
