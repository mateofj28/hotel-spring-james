package dev.garces.spring.sec.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import dev.garces.spring.sec.model.City;
import dev.garces.spring.sec.model.Country;
import dev.garces.spring.sec.model.Department;
import dev.garces.spring.sec.model.Hotel;
import dev.garces.spring.sec.model.User;
import dev.garces.spring.sec.repository.CityRepository;
import dev.garces.spring.sec.repository.CountryRepository;
import dev.garces.spring.sec.repository.DepartmentRepository;
import dev.garces.spring.sec.repository.HotelRepository;
import dev.garces.spring.sec.repository.UserRepository;
import dev.garces.spring.sec.service.IHotelService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Controller
public class WebController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private CountryRepository countryRepository;

	@Autowired
	private DepartmentRepository departmentRepository;

	@Autowired
	private CityRepository cityRepository;
	
	@Autowired
	private IHotelService hotelService;

	@GetMapping(value = { "/login" })
	public String getLogin() {
		return "login";
	}

	@GetMapping("/admin")
	public String getAdminPanel() {
		return "admin";
	}

	@GetMapping("/home")
	public String getUser(Model model) {
		List<Country> countries = countryRepository.findAll();
		List<Department> departments = departmentRepository.findAll();
		List<City> cities = cityRepository.findAll();

		model.addAttribute("countries", countries);
		model.addAttribute("departments", departments);
		model.addAttribute("cities", cities);
		
		List<Hotel> listhotels = hotelService.listAll();
		model.addAttribute("hotel", "lista Hoteles");
		model.addAttribute("hotels", listhotels);
		
		return "menuAppHotel";
	}

	@GetMapping("/register")
	public String getRegister() {
		return "register-user";
	}

	@PostMapping("register")
	public String registerUser(User user, BCryptPasswordEncoder passwordEncoder) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setRole("ROLE_USER");
		userRepository.save(user);
		return "redirect:/login";
	}

}
