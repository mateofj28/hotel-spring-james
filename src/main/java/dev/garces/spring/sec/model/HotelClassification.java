package dev.garces.spring.sec.model;


import javax.persistence.*;

@Entity
@Table(name = "HotelClassification")
public class HotelClassification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idClassification;

    @Column(name = "classification_name", nullable = false)
    private String classificationName;

	public HotelClassification() {
	
	}

	public Long getIdClassification() {
		return idClassification;
	}

	public void setIdClassification(Long idClassification) {
		this.idClassification = idClassification;
	}

	public String getClassificationName() {
		return classificationName;
	}

	public void setClassificationName(String classificationName) {
		this.classificationName = classificationName;
	}
    
    
    
    
}

