package dev.garces.spring.sec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.garces.spring.sec.model.City;
import dev.garces.spring.sec.repository.CityRepository;

@Service
public class CityServiceImpl implements ICityService {

	
	 @Autowired
	    private CityRepository cityRepository;

	    @Override
	    public List<City> listCity() {
	        return cityRepository.findAll();
	    }

	    @Override
	    public City getCityById(Long id) {
	        return cityRepository.findById(id).orElse(null);
	    }

}
