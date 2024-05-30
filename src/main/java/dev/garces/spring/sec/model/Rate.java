package dev.garces.spring.sec.model;

import javax.persistence.*;

@Entity
@Table(name = "Rate")
public class Rate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "room_id", nullable = false)
    private HotelRoom hotelRoom;

    @ManyToOne
    @JoinColumn(name = "season_id", nullable = false)
    private Season season;

    @Column(name = "rate_value")
    private double rateValue;

}
