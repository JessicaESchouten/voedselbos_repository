package nl.jschouten.testproject2.voedselbos.controller;

import nl.jschouten.testproject2.voedselbos.model.Plant;
import nl.jschouten.testproject2.voedselbos.repository.PlantRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

/**
 * Auteur Jessica Schouten.
 * <p>
 * Runt het voedselbos-programma.
 */

@Controller
public class FoodForestController {

    private final PlantRepository plantRepository;

    public FoodForestController(PlantRepository plantRepository) {
        this.plantRepository = plantRepository;
    }

    @GetMapping ({"/plants/all", "/"})

    protected String showPlantOverview(Model model) {
        model.addAttribute("allPlants", plantRepository.findAll());

        return "plantOverview";
    }

    @GetMapping("/plants/edit/{plantId}")
    protected String showEditBookForm(@PathVariable("plantId") Long plantId, Model model) {
        Optional<Plant> plant = plantRepository.findById(plantId);

        if (plant.isPresent()) {
            model.addAttribute("plant", plant.get());
            return "plantForm";
        }

        return "redirect:/plants/all";
    }

    @GetMapping("/plants/new")
    protected String showNewPlantForm(Model model) {
        model.addAttribute("plant", new Plant());
        return "plantForm";
    }

    @PostMapping("/plants/new")
    protected String savePlant(@ModelAttribute("plant") Plant plantToBeSaved, BindingResult result) {
        if (!result.hasErrors()) {
            plantRepository.save(plantToBeSaved);
        }
        return "redirect:/plants/all";
    }

    @GetMapping("/plants/delete/{plantId}")
    protected String deletePlant(@PathVariable("plantId") Long plantId) {
        Optional<Plant> plant = plantRepository.findById(plantId);

        if (plant.isPresent()) {
            plantRepository.delete(plant.get());
        }

        return "redirect:/plants/all";
    }

}
