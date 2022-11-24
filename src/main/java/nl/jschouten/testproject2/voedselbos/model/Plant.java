package nl.jschouten.testproject2.voedselbos.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * Auteur Jessica Schouten.
 * <p>
 * Beschrijft de eigenschappen van planten in een voedselbos.
 */

@Entity @Getter @Setter
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

        @OneToMany(mappedBy = "plant")
        private List<Stock> stocknrs;

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

