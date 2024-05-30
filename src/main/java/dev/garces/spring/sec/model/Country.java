package dev.garces.spring.sec.model;

import java.util.List;

import javax.persistence.*;


@Entity
@Table(name = "Country")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCountry;

    @Column(name = "country_code")
    private Integer countryCode;

    @Column(name = "country_name")
    private String countryName;
    
    @OneToMany(mappedBy = "country")
    private List<Department> departments;
    
   @OneToMany(mappedBy="country")
   private List<Hotel>hotels;
    

   @OneToMany(mappedBy="country")
  private List<HotelBranch>hotelBranchs;
    
    
	public Country() {
	}


	public Country(String countryName) {
		super();
		this.countryName = countryName;
	}


	public Country(Long idCountry, Integer countryCode, String countryName, List<Department> departments,
			List<Hotel> hotels, List<HotelBranch> hotelBranchs) {
		super();
		this.idCountry = idCountry;
		this.countryCode = countryCode;
		this.countryName = countryName;
		this.departments = departments;
		this.hotels = hotels;
		this.hotelBranchs = hotelBranchs;
	}


	public Long getIdCountry() {
		return idCountry;
	}

	public void setIdCountry(Long idCountry) {
		this.idCountry = idCountry;
	}

	public Integer getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(Integer countryCode) {
		this.countryCode = countryCode;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
    


}
