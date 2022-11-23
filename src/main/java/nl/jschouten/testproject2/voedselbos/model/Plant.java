package nl.jschouten.testproject2.voedselbos.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Auteur Jessica Schouten.
 * <p>
 * Beschrijft de eigenschappen van planten in een voedselbos.
 */

@Entity
public class Plant {

    @Id
    @GeneratedValue
    private Long plantId;

    private String name;
    private String zaaiTijd;
    private String standPlaats;
    private String verzorging;
    private String goedeBuren;
    private String slechteBuren;
    private String locatie;

    public Long getPlantId() {
        return plantId;
    }

    public void setPlantId(Long plantId) {
        this.plantId = plantId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getZaaiTijd() {
        return zaaiTijd;
    }

    public void setZaaiTijd(String zaaiTijd) {
        this.zaaiTijd = zaaiTijd;
    }

    public String getStandPlaats() {
        return standPlaats;
    }

    public void setStandPlaats(String standPlaats) {
        this.standPlaats = standPlaats;
    }

    public String getVerzorging() {
        return verzorging;
    }

    public void setVerzorging(String verzorging) {
        this.verzorging = verzorging;
    }

    public String getGoedeBuren() {
        return goedeBuren;
    }

    public void setGoedeBuren(String goedeBuren) {
        this.goedeBuren = goedeBuren;
    }

    public String getSlechteBuren() {
        return slechteBuren;
    }

    public void setSlechteBuren(String slechteBuren) {
        this.slechteBuren = slechteBuren;
    }

    public String getLocatie() {
        return locatie;
    }

    public void setLocatie(String locatie) {
        this.locatie = locatie;
    }
}
