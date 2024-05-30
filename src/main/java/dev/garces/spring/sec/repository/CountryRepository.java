package dev.garces.spring.sec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import dev.garces.spring.sec.model.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {
    Country findByCountryName(String countryName);
}

