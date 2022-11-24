package nl.jschouten.testproject2.voedselbos.controller;

import nl.jschouten.testproject2.voedselbos.model.Plant;
import nl.jschouten.testproject2.voedselbos.model.Stock;
import nl.jschouten.testproject2.voedselbos.repository.PlantRepository;
import nl.jschouten.testproject2.voedselbos.repository.StockRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

/**
 * Auteur Jessica Schouten.
 * <p>
 * Beheert de voorraad.
 */

@Controller
@RequestMapping("/stock")
public class StockController {
    private final PlantRepository plantRepository;
    private final StockRepository stockRepository;

    public StockController(PlantRepository plantRepository, StockRepository stockRepository) {
        this.plantRepository = plantRepository;
        this.stockRepository = stockRepository;
    }

    @GetMapping("/new/{plantId}")
    protected String createNewStock(@PathVariable("plantId") Long plantId) {

        Optional<Plant> plant = plantRepository.findById(plantId);

        if (plant.isPresent()) {
            Stock stock = new Stock();
            stock.setPlant(plant.get());
            stockRepository.save(stock);
        }

        return "redirect:/plants/all";
    }
}
