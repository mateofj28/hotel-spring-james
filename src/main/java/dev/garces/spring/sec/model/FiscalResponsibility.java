package dev.garces.spring.sec.model;

import javax.persistence.*;

@Entity
@Table(name = "FiscalResponsibility")
public class FiscalResponsibility {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "abbreviation_FiscalResponsibility", length = 30)
    private String abbreviation;

    @Column(name = "description_FiscalResponsibility", length = 50, unique = true, nullable = false)
    private String description;
}
