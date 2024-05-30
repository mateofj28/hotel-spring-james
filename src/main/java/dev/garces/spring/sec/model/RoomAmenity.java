package dev.garces.spring.sec.model;

import javax.persistence.*;

@Entity
@Table(name = "RoomAmenities")
public class RoomAmenity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_room_amenity;

    @Column(name = "room_amenity_name", length = 100)
    private String room_amenity_name;

    public RoomAmenity() {
    }

    public RoomAmenity(String room_amenity_name) {
        this.room_amenity_name = room_amenity_name;
    }

    public Long getId_room_amenity() {
        return id_room_amenity;
    }

    public void setId_room_amenity(Long id_room_amenity) {
        this.id_room_amenity = id_room_amenity;
    }

    public String getRoom_amenity_name() {
        return room_amenity_name;
    }

    public void setRoom_amenity_name(String room_amenity_name) {
        this.room_amenity_name = room_amenity_name;
    }

}