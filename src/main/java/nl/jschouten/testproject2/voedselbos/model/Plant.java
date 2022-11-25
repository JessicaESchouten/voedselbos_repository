package nl.jschouten.testproject2.voedselbos.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

/**
 * Auteur Jessica Schouten.
 * <p>
 * Beschrijft de eigenschappen van planten in een voedselbos.
 */

@Entity
@Getter @Setter
public class Plant {

    @Id
    @GeneratedValue
    private Long plantId;

    private String name;
//    private String zaaiTijd;
//    private String standPlaats;
//    private String verzorging;
//    private String goedeBuren;
//    private String slechteBuren;
//    private String locatie;
    @ManyToMany
    private Set<Verzorging> verzorgingKenmerken;
    @OneToMany(mappedBy = "plant")
    private List<Stock> stocknrs;

    public String getVerzorgingKenmerkenDisplayString() {
        StringBuilder builder = new StringBuilder();

        for (Verzorging verzorging : verzorgingKenmerken) {
            builder.append(verzorging).append(", ");
        }

        return builder.toString();
    }

    public int getNumberOfAvailableStocknrs() {
        int count = 0;

        for (Stock stock : stocknrs) {
            if (stock.getAvailable()) {
                count++;
            }
        }
        return count;
    }
}

