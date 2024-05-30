package dev.garces.spring.sec.service;

import java.util.List;

import dev.garces.spring.sec.model.Country;

public interface ICountryService {
    List<Country> listCountry();

    Country getCountryById(Long id);
}
