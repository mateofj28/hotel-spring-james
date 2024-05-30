package dev.garces.spring.sec.service;

import java.util.List;

import dev.garces.spring.sec.model.Country;
import dev.garces.spring.sec.model.Department;

public interface IDptoService {

	List<Department> listDpto();

	List<Department> findByCountry(Country country);
}
