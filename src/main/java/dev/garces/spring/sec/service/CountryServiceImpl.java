package dev.garces.spring.sec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.garces.spring.sec.model.Country;
import dev.garces.spring.sec.repository.CountryRepository;

@Service
public class CountryServiceImpl implements ICountryService {

    @Autowired
    private CountryRepository countryRepository;

    @Override
    public List<Country> listCountry() {
        return (List<Country>) countryRepository.findAll();
    }

    @Override
    public Country getCountryById(Long id) {
        return countryRepository.findById(id).orElse(null);
    }
}
