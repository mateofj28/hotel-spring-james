package dev.garces.spring.sec.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;


@Entity
@Table(name = "City")
public class City implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCity;

    @ManyToOne
    @JoinColumn(name = "department_id", referencedColumnName ="idDepartment")
    private Department department;

    @Column(name = "city_code")
    private String cityCode;

    @Column(name = "city_name")
    private String cityName;

   @OneToMany(mappedBy="city")
    private List<Hotel>hotels;
    
    @OneToMany(mappedBy="city")
   private List<HotelBranch>hotelBranchs;
    
	public City() {
		
	}

	public Long getIdCity() {
		return idCity;
	}

	public void setIdCity(Long idCity) {
		this.idCity = idCity;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

    


}
