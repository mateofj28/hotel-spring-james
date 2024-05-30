package dev.garces.spring.sec.model;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "Department")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDepartment;

    @ManyToOne
    @JoinColumn(name = "country_id", referencedColumnName = "idCountry")
    private Country country;

    @Column(name = "department_code")
    private String departmentCode;

    @Column(name = "department_name")
    private String departmentName;
    
    @OneToMany(mappedBy="department")
    private List<City> cities;
    
    @OneToMany(mappedBy="department")
    private List<Hotel>hotels;
    
    @OneToMany(mappedBy="department")
    private List<HotelBranch>hotelBranchs;

	public Department() {
	}

	public Department(Country country, String departmentName) {
		super();
		this.country = country;
		this.departmentName = departmentName;
	}

	public Department(Long idDepartment, Country country, String departmentCode, String departmentName,
			List<City> cities, List<Hotel> hotels, List<HotelBranch> hotelBranchs) {
		super();
		this.idDepartment = idDepartment;
		this.country = country;
		this.departmentCode = departmentCode;
		this.departmentName = departmentName;
		this.cities = cities;
		this.hotels = hotels;
		this.hotelBranchs = hotelBranchs;
	}

	public Long getIdDepartment() {
		return idDepartment;
	}

	public void setIdDepartment(Long idDepartment) {
		this.idDepartment = idDepartment;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public String getDepartmentCode() {
		return departmentCode;
	}

	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public List<City> getCities() {
		return cities;
	}

	public void setCities(List<City> cities) {
		this.cities = cities;
	}

	public List<Hotel> getHotels() {
		return hotels;
	}

	public void setHotels(List<Hotel> hotels) {
		this.hotels = hotels;
	}

	public List<HotelBranch> getHotelBranchs() {
		return hotelBranchs;
	}

	public void setHotelBranchs(List<HotelBranch> hotelBranchs) {
		this.hotelBranchs = hotelBranchs;
	}

	
    

}
