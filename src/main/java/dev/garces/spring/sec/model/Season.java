package dev.garces.spring.sec.model;


import javax.persistence.*;

@Entity
@Table(name = "Season")
public class Season {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_season")
    private Long idSeason;

    @Column(name = "season", length = 30)
    private String seasonName;

    public Season() {
    }

    public Season(String seasonName) {
        this.seasonName = seasonName;
    }

    public Long getIdSeason() {
        return idSeason;
    }

    public void setIdSeason(Long idSeason) {
        this.idSeason = idSeason;
    }

    public String getSeasonName() {
        return seasonName;
    }

    public void setSeasonName(String seasonName) {
        this.seasonName = seasonName;
    }


}
