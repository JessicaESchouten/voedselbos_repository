package nl.jschouten.testproject2.voedselbos.repository;

import nl.jschouten.testproject2.voedselbos.model.Plant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Auteur Jessica Schouten.
 * <p>
 * Interface voor de opslag van de plantengegevens?
 */
public interface PlantRepository extends JpaRepository<Plant, Long> {
    Optional<Plant> findByName(String name);
}
