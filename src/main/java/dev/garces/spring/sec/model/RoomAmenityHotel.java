package dev.garces.spring.sec.model;
import javax.persistence.*;

@Entity
@Table(name = "RoomAmenityHotel")
public class RoomAmenityHotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "room_amenity_id", nullable = false)
    private RoomAmenity roomAmenity;

    @ManyToOne
    @JoinColumn(name = "room_id_amenity", nullable = false)
    private HotelRoom hotelRoom;

    @Column(name = "amenity_images_room", columnDefinition = "TEXT")
    private String amenityImagesRoom;

}
