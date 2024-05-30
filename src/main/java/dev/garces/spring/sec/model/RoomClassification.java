package dev.garces.spring.sec.model;

import javax.persistence.*;

@Entity
@Table(name = "RoomClassification")
public class RoomClassification {

	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id_room_classification;

	    @Column(name = "room_classification_name", length = 50)
	    private String room_classification_name;

    public RoomClassification(String room_classification_name) {
        this.room_classification_name = room_classification_name;
    }

    public Long getId_room_classification() {
        return id_room_classification;
    }

    public void setId_room_classification(Long id_room_classification) {
        this.id_room_classification = id_room_classification;
    }

    public String getRoom_classification_name() {
        return room_classification_name;
    }

    public void setRoom_classification_name(String room_classification_name) {
        this.room_classification_name = room_classification_name;
    }

   
}