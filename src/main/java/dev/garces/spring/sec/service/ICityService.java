package dev.garces.spring.sec.service;

import java.util.List;

import dev.garces.spring.sec.model.City;

public interface ICityService {

	List<City> listCity();

	City getCityById(Long id);

}
