package com.rosajr.br.repository;

import com.rosajr.br.domain.City;
import com.rosajr.br.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {
}
