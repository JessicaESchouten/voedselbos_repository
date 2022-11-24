package nl.jschouten.testproject2.voedselbos.controller;

import nl.jschouten.testproject2.voedselbos.model.Verzorging;
import nl.jschouten.testproject2.voedselbos.repository.VerzorgingRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Auteur Jessica Schouten.
 * <p>
 * Dit is wat het programma doet.
 */

@Controller
@RequestMapping("/verzorgingKenmerken")
public class VerzorgingController {
    private final VerzorgingRepository verzorgingRepository;

    public VerzorgingController(VerzorgingRepository verzorgingRepository) {
        this.verzorgingRepository = verzorgingRepository;
    }

    @GetMapping("/all")
    protected String showVerzorgingOverview(Model model) {
        model.addAttribute("allVerzorgingKenmerken", verzorgingRepository.findAll());
        model.addAttribute("newVerzorging", new Verzorging() {
        });
        return "verzorgingOverview";
    }

    @PostMapping("/new")
    protected String saveOrUpdateVerzorging(@ModelAttribute("newVerzorging") Verzorging verzorging, BindingResult result) {
        if (!result.hasErrors()) {
            verzorgingRepository.save(verzorging);
        }

        return "redirect:/verzorgingKenmerken/all";
    }
}
