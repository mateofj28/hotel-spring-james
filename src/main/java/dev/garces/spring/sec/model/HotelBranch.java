package dev.garces.spring.sec.model;
import javax.persistence.*;

@Entity
@Table(name = "HotelBranch")
public class HotelBranch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBranch;

    @ManyToOne
    @JoinColumn(name = "main_hotel", referencedColumnName = "idHotel")
    private Hotel mainHotel;

    @Column(name = "branch_address", nullable = false, length = 255)
    private String branchAddress;

    @ManyToOne
    @JoinColumn(name = "country_id_branch", referencedColumnName = "idCountry")
    private Country country;

    @ManyToOne
    @JoinColumn(name = "department_id_branch", referencedColumnName = "idDepartment")
    private Department department;

    @ManyToOne
    @JoinColumn(name = "city_id_branch", referencedColumnName = "idCity")
    private City city;

    @ManyToOne
    @JoinColumn(name = "hotel_classification_id_branch", referencedColumnName = "idClassification")
    private HotelClassification hotelClassification;

    @Column(name = "branch_images", columnDefinition = "TEXT")
    private String branchImages;

    
 
    
	public HotelBranch() {
	}

	public Long getIdBranch() {
		return idBranch;
	}

	public void setIdBranch(Long idBranch) {
		this.idBranch = idBranch;
	}

	public Hotel getMainHotel() {
		return mainHotel;
	}

	public void setMainHotel(Hotel mainHotel) {
		this.mainHotel = mainHotel;
	}

	public String getBranchAddress() {
		return branchAddress;
	}

	public void setBranchAddress(String branchAddress) {
		this.branchAddress = branchAddress;
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

	public HotelClassification getHotelClassification() {
		return hotelClassification;
	}

	public void setHotelClassification(HotelClassification hotelClassification) {
		this.hotelClassification = hotelClassification;
	}

	public String getBranchImages() {
		return branchImages;
	}

	public void setBranchImages(String branchImages) {
		this.branchImages = branchImages;
	}
    
    
    

}

