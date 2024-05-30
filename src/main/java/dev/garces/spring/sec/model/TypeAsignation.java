package dev.garces.spring.sec.model;

import javax.persistence.*;
@Entity
@Table(name = "type_asignation")
public class TypeAsignation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "descripcion_type_asignation", length = 50, unique = true, nullable = false)
    private String description;

}
