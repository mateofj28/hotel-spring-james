package dev.garces.spring.sec.model;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "Hotel")
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idHotel;

    @Column(name = "hotel_name", nullable = false)
    private String hotelName;

    @Column(name = "nit_hotel", nullable = false, length = 20)
    private String nitHotel;

    @Column(name = "main_address_hotel", nullable = false, length = 255)
    private String mainAddressHotel;

    @Column(name = "main_hotel_phone", length = 20)
    private String mainHotelPhone;

    @Column(name = "main_hotel_email", length = 100)
    private String mainHotelEmail;

    @Column(name = "main_hotel_images", columnDefinition = "TEXT")
    private String mainHotelImages;

    @ManyToOne
    @JoinColumn(name = "country_id_main_hotel", referencedColumnName = "idCountry")
    private Country country;

    @ManyToOne
    @JoinColumn(name = "department_id_main_hotel", referencedColumnName = "idDepartment")
    private Department department;

    @ManyToOne
    @JoinColumn(name = "city_id_main_hotel", referencedColumnName = "idCity")
    private City city;
    
    @OneToMany(mappedBy="mainHotel")
    private List<HotelBranch>hotelBranchs;

	public Hotel() {
	}

	public Long getIdHotel() {
		return idHotel;
	}

	public void setIdHotel(Long idHotel) {
		this.idHotel = idHotel;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getNitHotel() {
		return nitHotel;
	}

	public void setNitHotel(String nitHotel) {
		this.nitHotel = nitHotel;
	}

	public String getMainAddressHotel() {
		return mainAddressHotel;
	}

	public void setMainAddressHotel(String mainAddressHotel) {
		this.mainAddressHotel = mainAddressHotel;
	}

	public String getMainHotelPhone() {
		return mainHotelPhone;
	}

	public void setMainHotelPhone(String mainHotelPhone) {
		this.mainHotelPhone = mainHotelPhone;
	}

	public String getMainHotelEmail() {
		return mainHotelEmail;
	}

	public void setMainHotelEmail(String mainHotelEmail) {
		this.mainHotelEmail = mainHotelEmail;
	}

	public String getMainHotelImages() {
		return mainHotelImages;
	}

	public void setMainHotelImages(String mainHotelImages) {
		this.mainHotelImages = mainHotelImages;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}
    
    

}

