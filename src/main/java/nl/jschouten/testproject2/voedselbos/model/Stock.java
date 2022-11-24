package nl.jschouten.testproject2.voedselbos.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Auteur Jessica Schouten.
 * <p>
 * Eigenschappen voorraad
 */

@Entity @Getter @Setter
public class Stock {
    @Id
    @GeneratedValue
    private Long stockId;

    @ManyToOne
    private Plant plant;

    Boolean available = true;
}


