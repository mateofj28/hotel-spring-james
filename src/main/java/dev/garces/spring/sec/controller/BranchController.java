package dev.garces.spring.sec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import dev.garces.spring.sec.model.City;
import dev.garces.spring.sec.model.Country;
import dev.garces.spring.sec.model.Department;
import dev.garces.spring.sec.model.Hotel;
import dev.garces.spring.sec.model.HotelBranch;
import dev.garces.spring.sec.service.ICityService;
import dev.garces.spring.sec.service.ICountryService;
import dev.garces.spring.sec.service.IDptoService;
import dev.garces.spring.sec.service.IHotelBranchService;
import dev.garces.spring.sec.service.IHotelService;

import java.util.List;

@Controller
@RequestMapping("/view/hotel")
public class BranchController {

	@Autowired
	private IHotelService hotelService;

	@Autowired
	private IHotelBranchService hotelBranchService;
	@Autowired
	private ICountryService countryService;
	@Autowired
	private IDptoService dptoService;
	@Autowired
	private ICityService cityService;

	@GetMapping("/branch_Hotel")
	public String ListhotelBranch(Model model) {
		List<HotelBranch> listhotelBranchs = hotelBranchService.listAll();
		model.addAttribute("branch", "lista Hoteles");
		model.addAttribute("branchs", listhotelBranchs);
		return "view/hotel/listBranch";

	}

	@GetMapping("/create_branch")
	public String create(Model model) {
		HotelBranch branch = new HotelBranch();

	 List<Hotel> listHotel = hotelService.listHotel();
		List<Country> listCountry = countryService.listCountry();
		List<Department> listDpto = dptoService.listDpto();
		List<City> listCity = cityService.listCity();

		model.addAttribute("titulo", "Nueva Sucursual");
		model.addAttribute("editMode", false);
		model.addAttribute("branch", branch);
		model.addAttribute("hotels", listHotel);
		model.addAttribute("countries", listCountry);

		if (listDpto != null && !listDpto.isEmpty()) {
			model.addAttribute("dpto", listDpto);
		} else {
			System.out.println("La lista de departamentos está vacía o es nula.");
		}

		if (listCity != null && !listCity.isEmpty()) {
			model.addAttribute("city", listCity);
		} else {
			System.out.println("La lista de ciudades está vacía o es nula.");
		}
		if (listHotel != null && !listHotel.isEmpty()) {
			model.addAttribute("hotel", listHotel);
		} else {
			System.out.println("La lista de Hoteles está vacía o es nula.");
		}

		return "view/hotel/creation_branch";
	}

	@GetMapping("/edit_branch/{id}")
	public String edit(@PathVariable("id") Long idBranch, Model model) {
		HotelBranch branch = hotelBranchService.SearchHotelBranch(idBranch);
		List<Country> listCountry = countryService.listCountry();
		List<Department> listDpto = dptoService.listDpto();
		List<City> listCity = cityService.listCity();

		model.addAttribute("titulo", "Editar Sucursal");
		model.addAttribute("editMode", true);

		model.addAttribute("branch", branch);
		model.addAttribute("countries", listCountry);
		model.addAttribute("dpto", listDpto);

		model.addAttribute("city", listCity);

		// model.addAttribute("selectedCountryId", hotel.getCountry().getIdCountry());
		// model.addAttribute("selectedDptoId",
		// hotel.getDepartment().getIdDepartment());
		// model.addAttribute("selectedCityId", hotel.getCity().getIdCity());

		return "view/hotel/creation_branch";
	}

	@GetMapping("/delete_branch/{id}")
	public String delete(@PathVariable("id") Long idBranch) {

		hotelBranchService.deleteHotelBranch(idBranch);
		return "redirect:/view/hotel/hotel_Hotel";
	}

	@PostMapping("/saveBranch")
	public String save(@ModelAttribute HotelBranch branch, RedirectAttributes redirectAttributes) {

		hotelBranchService.save(branch);

		redirectAttributes.addFlashAttribute("successMessage", "Registro guardado correctamente");

		return "redirect:/view/hotel/hotel_Hotel";
	}

}
