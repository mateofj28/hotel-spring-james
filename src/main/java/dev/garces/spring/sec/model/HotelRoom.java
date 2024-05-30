package dev.garces.spring.sec.model;

import javax.persistence.*;
@Entity
@Table(name = "HotelRoom")
public class HotelRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_room")
    private Long idRoom;

    @Column(name = "hotel_branch")
    private Long hotelBranch;

    @Column(name = "room_number", nullable = false)
    private String roomNumber;

    @Column(name = "room_name", length = 30)
    private String roomName;

    @Column(name = "floor")
    private Integer floor;

    @ManyToOne
    @JoinColumn(name = "room_classification")
    private RoomClassification roomClassification;

    @Column(name = "beds", nullable = false)
    private Integer beds;

    @Column(name = "room_images", columnDefinition = "TEXT")
    private String roomImages;


}
