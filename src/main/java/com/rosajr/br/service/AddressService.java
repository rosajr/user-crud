package com.rosajr.br.service;

import com.rosajr.br.domain.Address;
import com.rosajr.br.dto.AddressDTO;

public interface AddressService {
    Address register(AddressDTO addressDTO);
}
