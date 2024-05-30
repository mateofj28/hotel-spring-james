package dev.garces.spring.sec.model;
import javax.persistence.*;

@Entity
@Table(name = "HotelAmenitiesDetail")
public class HotelAmenitiesDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAmenity;

    @ManyToOne
    @JoinColumn(name = "hotel_id_amenity", referencedColumnName = "idBranch")
    private HotelBranch hotelBranch;

    @ManyToOne
    @JoinColumn(name = "hotel_amenities_id_amenity",referencedColumnName = "idAmenity")
    private HotelAmenity hotelAmenity;

    
    
    
    @Column(name = "amenity_images", columnDefinition = "TEXT")
    private String amenityImages;
  
	public HotelAmenitiesDetail() {
	}

	public Long getIdAmenity() {
		return idAmenity;
	}

	public void setIdAmenity(Long idAmenity) {
		this.idAmenity = idAmenity;
	}

	public HotelBranch getHotelBranch() {
		return hotelBranch;
	}

	public void setHotelBranch(HotelBranch hotelBranch) {
		this.hotelBranch = hotelBranch;
	}

	public HotelAmenity getHotelAmenity() {
		return hotelAmenity;
	}

	public void setHotelAmenity(HotelAmenity hotelAmenity) {
		this.hotelAmenity = hotelAmenity;
	}

	public String getAmenityImages() {
		return amenityImages;
	}

	public void setAmenityImages(String amenityImages) {
		this.amenityImages = amenityImages;
	}
    
    
    
    
}
