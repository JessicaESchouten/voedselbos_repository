package nl.jschouten.testproject2.voedselbos.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Auteur Jessica Schouten.
 * <p>
 * Geeft de eigenschappen van verzorging weer.
 */

@Entity @Getter @Setter
public class Verzorging {

    @Id
    @GeneratedValue
    private Long verzorgingId;
    private String opkweken;
    private String verspenen;
    private String bemesting;
    private String oogst;
    private String vermeerderen;

    public String getDisplayVerzorging() {
        String displayVerzorging = opkweken;
        if (!verspenen.equals("")) {
            displayVerzorging += " " + verspenen;
        }
         return displayVerzorging + " " + bemesting + oogst + vermeerderen;
    }//TODO gekke weergave aanpassen

    @Override
    public String toString() {
        return getDisplayVerzorging();
    }
}
