package dev.garces.spring.sec.model;

import javax.persistence.*;

@Entity
@Table(name = "document_type")
public class DocumentType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "abbreviation_document_type", length = 30)
    private String abbreviation;

    @Column(name = "description_document_type", length = 50, unique = true, nullable = false)
    private String description;

}
