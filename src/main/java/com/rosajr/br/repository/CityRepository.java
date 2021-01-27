package com.rosajr.br.repository;

import com.rosajr.br.domain.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {
    Optional<City> findByCodeIbge(Integer codeIbge);
}
