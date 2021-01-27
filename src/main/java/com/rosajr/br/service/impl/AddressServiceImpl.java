package com.rosajr.br.service.impl;

import com.rosajr.br.domain.Address;
import com.rosajr.br.dto.AddressDTO;
import com.rosajr.br.exceptions.ObjectNotFoundException;
import com.rosajr.br.repository.AddressRepository;
import com.rosajr.br.repository.CityRepository;
import com.rosajr.br.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    private CityRepository cityRepository;
    @Autowired
    private AddressRepository addressRepository;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Address register(AddressDTO dto) {

        var city = cityRepository.findByCodeIbge(dto.getCityIbge())
                .orElseThrow(() -> new ObjectNotFoundException("Nenhuma cidade com o código ibge informado foi encontrada"));

        var address = Address.builder()
                .city(city)
                .complement(dto.getComplement())
                .neighborhood(dto.getNeighborhood())
                .street(dto.getStreet())
                .zipCode(dto.getZipCode())
                .number(dto.getNumber()).build();

        addressRepository.save(address);


        return address;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Address update(Address address, AddressDTO dto) {

        var city = cityRepository.findByCodeIbge(dto.getCityIbge())
                .orElseThrow(() -> new ObjectNotFoundException("Nenhuma cidade com o código ibge informado foi encontrada"));

        address.setCity(city);
        address.setNeighborhood(dto.getNeighborhood());
        address.setComplement(dto.getComplement());
        address.setNumber(dto.getNumber());
        address.setStreet(dto.getStreet());
        address.setZipCode(dto.getZipCode());

        addressRepository.save(address);

        return address;
    }
}
