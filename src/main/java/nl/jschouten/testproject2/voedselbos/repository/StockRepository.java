package nl.jschouten.testproject2.voedselbos.repository;

import nl.jschouten.testproject2.voedselbos.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Auteur Jessica Schouten.
 * <p>
 * Dit is wat het programma doet.
 */
public interface StockRepository extends JpaRepository <Stock, Long> {
}
