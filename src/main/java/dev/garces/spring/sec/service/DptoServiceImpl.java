package dev.garces.spring.sec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.garces.spring.sec.model.Country;
import dev.garces.spring.sec.model.Department;
import dev.garces.spring.sec.repository.DepartmentRepository;

@Service
public class DptoServiceImpl implements IDptoService {
	@Autowired
	private DepartmentRepository dptoRepository;

	@Override
	public List<Department> listDpto() {

		return (List<Department>) dptoRepository.findAll();
	}

	@Override
	public List<Department> findByCountry(Country country) {
		return dptoRepository.findByCountry(country);
	}

}
