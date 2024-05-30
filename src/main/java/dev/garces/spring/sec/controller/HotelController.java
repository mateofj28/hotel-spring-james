package dev.garces.spring.sec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cloudinary.utils.ObjectUtils;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import dev.garces.spring.sec.config.CloudinaryConfig;
import dev.garces.spring.sec.model.City;
import dev.garces.spring.sec.model.Country;
import dev.garces.spring.sec.model.Department;
import dev.garces.spring.sec.model.Hotel;
import dev.garces.spring.sec.service.ICityService;
import dev.garces.spring.sec.service.ICountryService;
import dev.garces.spring.sec.service.IDptoService;
import dev.garces.spring.sec.service.IHotelService;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Map;
import java.util.List;

@Controller
@RequestMapping("/view/hotel")
public class HotelController {

	@Autowired
	private IHotelService hotelService;
	@Autowired
	private ICountryService countryService;
	@Autowired
	private IDptoService dptoService;
	@Autowired
	private ICityService cityService;

	@Autowired
	private CloudinaryConfig cloudc;

	@GetMapping("/hotel_Hotel")
	public String Listhotel(Model model) {
		List<Hotel> listhotels = hotelService.listAll();
		model.addAttribute("hotel", "lista Hoteles");
		model.addAttribute("hotels", listhotels);
		return "view/hotel/listHotel";

	}
	

	@GetMapping("/create_hotel")
	public String create(Model model) {
		Hotel hotel = new Hotel();

		List<Country> listCountry = countryService.listCountry();
		List<Department> listDpto = dptoService.listDpto();
		List<City> listCity = cityService.listCity();

		model.addAttribute("titulo", "Nuevo hotel");
		model.addAttribute("editMode", false);
		model.addAttribute("hotel", hotel);
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

		return "view/hotel/creation_hotel";
	}

	@GetMapping("/edit_hotel/{id}")
	public String edit(@PathVariable("id") Long idHotel, Model model) {
		Hotel hotel = hotelService.SearchHotel(idHotel);
		List<Country> listCountry = countryService.listCountry();
		List<Department> listDpto = dptoService.listDpto();
		List<City> listCity = cityService.listCity();

		model.addAttribute("titulo", "Editar hotel");
		model.addAttribute("editMode", true);

		model.addAttribute("hotel", hotel);
		model.addAttribute("countries", listCountry);
		model.addAttribute("dpto", listDpto);

		model.addAttribute("city", listCity);

		// model.addAttribute("selectedCountryId", hotel.getCountry().getIdCountry());
		// model.addAttribute("selectedDptoId",
		// hotel.getDepartment().getIdDepartment());
		// model.addAttribute("selectedCityId", hotel.getCity().getIdCity());

		return "view/hotel/creation_hotel";
	}

	@GetMapping("/delete_hotel/{id}")
	public String delete(@PathVariable("id") Long idHotel) {

		hotelService.deleteHotel(idHotel);
		return "redirect:/view/hotel/hotel_Hotel";
	}

	@PostMapping("/save")
	public String save(@ModelAttribute Hotel hotel, RedirectAttributes redirectAttributes,@RequestParam("file") MultipartFile file ) {
		
		try {
			Map uploadResult = cloudc.upload(file.getBytes(), ObjectUtils.asMap("resourcetype", "auto"));
			System.out.println(uploadResult.get("url").toString());
			hotel.setMainHotelImages(uploadResult.get("url").toString());

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}


		hotelService.save(hotel);

		redirectAttributes.addFlashAttribute("successMessage", "Registro guardado correctamente");

		return "redirect:/view/hotel/hotel_Hotel";
	}

	@PostMapping("/upload-image")
	public String addProducto(Model model, @RequestParam("file") MultipartFile file) {

		try {
			Map uploadResult = cloudc.upload(file.getBytes(), ObjectUtils.asMap("resourcetype", "auto"));
			System.out.println(uploadResult.get("url").toString());

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return "redirect:/";
	}

	@GetMapping("")
	public String addProductoGet(Model model) {
		return "uploadimage";
	}

	@GetMapping("/open-pdf")
	public String openPDF(Model model) {
		return "pdf";
	}

	@GetMapping("/generate-pdf")
	public ResponseEntity<InputStreamResource> generatePdf() {
		try {
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			Document document = new Document();
			PdfWriter.getInstance(document, out);
			document.open();

			// Agregar un párrafo
			document.add(new Paragraph("Hello World!"));

			// Agregar una lista
			com.itextpdf.text.List list = new com.itextpdf.text.List(true, false, 10);
			list.add(new ListItem("Primer elemento de la lista"));
			list.add(new ListItem("Segundo elemento de la lista"));
			document.add(list);

			// Agregar una tabla
			PdfPTable table = new PdfPTable(3); // 3 columnas
			table.addCell("Celda 1");
			table.addCell("Celda 2");
			table.addCell("Celda 3");
			table.addCell("Celda 3");
			document.add(table);

			// Agregar una imagen
			Image image = Image.getInstance(
					"https://w7.pngwing.com/pngs/81/570/png-transparent-profile-logo-computer-icons-user-user-blue-heroes-logo-thumbnail.png");
			document.add(image);

			// Agregar un chunk (un fragmento de texto)
			Chunk chunk = new Chunk("Este es un chunk");
			document.add(chunk);

			// Agregar una frase
			Phrase phrase = new Phrase("Esta es una frase");
			document.add(phrase);

			document.close();

			ByteArrayInputStream bis = new ByteArrayInputStream(out.toByteArray());
			return ResponseEntity.ok()
					.contentType(MediaType.APPLICATION_PDF)
					.header("Content-Disposition", "attachment; filename=hello_world.pdf")
					.body(new InputStreamResource(bis));
		} catch (Exception e) {
			return ResponseEntity.status(500).build();
		}
	}

}
