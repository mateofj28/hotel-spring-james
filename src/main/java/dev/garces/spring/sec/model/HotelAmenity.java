package dev.garces.spring.sec.model;

import javax.persistence.*;



@Entity
@Table(name = "HotelAmenities")
public class HotelAmenity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAmenity;

    @Column(name = "amenity_name", nullable = false)
    private String amenityName;
    
    
    
    

	public HotelAmenity() {
	}

	public Long getIdAmenity() {
		return idAmenity;
	}

	public void setIdAmenity(Long idAmenity) {
		this.idAmenity = idAmenity;
	}

	public String getAmenityName() {
		return amenityName;
	}

	public void setAmenityName(String amenityName) {
		this.amenityName = amenityName;
	}
    
    
    
}
