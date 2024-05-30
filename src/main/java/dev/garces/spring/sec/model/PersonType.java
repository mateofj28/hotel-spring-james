package dev.garces.spring.sec.model;
import javax.persistence.*;

@Entity
@Table(name = "person_type")
public class PersonType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "description_person", length = 50, unique = true, nullable = false)
    private String description;


}
