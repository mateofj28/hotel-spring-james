package dev.garces.spring.sec.model;

import javax.persistence.*;

@Entity
@Table(name = "category_responsibility")
public class CategoryResponsibility {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "description", length = 50, unique = true, nullable = false)
    private String description;
}
