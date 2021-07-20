package dev.jx.app.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.ui.Model;
import dev.jx.app.entity.Pet;
import dev.jx.app.service.PetService;

@Controller
public class PetController {

    @Autowired
    @Qualifier("petServiceImpl")
    private PetService petService;

    @RequestMapping(value = "/pets", method = RequestMethod.GET)
    public String getPets(Map<String, Object> map) {
        map.put("pets", this.petService.findAll());
        return "/pets/index";
    }

    @RequestMapping(value = "/pets/{id}", method = RequestMethod.GET)
    public String getDetailsPet(@PathVariable Integer id, Model model) {
        model.addAttribute("pet", petService.findById(id));
        return "/pets/details";
    }

    @RequestMapping(value = "/pets/register", method = RequestMethod.GET)
    public String getRegisterPet(Model model) {
        model.addAttribute("pet", new Pet());
        return "/pets/register";
    }

    @RequestMapping(value = "/pets/register", method = RequestMethod.POST)
    public String postRegisterPet(Pet pet) {
        this.petService.insert(pet);
        return "redirect:/pets";
    }

    @RequestMapping(value = "/pets/{id}/edit", method = RequestMethod.GET)
    public String getEditPet(@PathVariable Integer id, Model model) {
        model.addAttribute("pet", this.petService.findById(id));
        return "/pets/edit";
    }

    @RequestMapping(value = "/pets/{id}/edit", method = RequestMethod.POST)
    public String postEditPet(Pet pet) {
        this.petService.update(pet);
        return "redirect:/pets";
    }

    @RequestMapping(value = "/pets/{id}/delete", method = RequestMethod.GET)
    public String getDeletePet(@PathVariable Integer id, Model model) {
        model.addAttribute("pet", this.petService.findById(id));
        return "/pets/delete";
    }

    @RequestMapping(value = "/pets/{id}/delete", method = RequestMethod.POST)
    public String postDeletePet(Pet pet) {
        this.petService.deleteById(pet.getId());
        return "redirect:/pets";
    }
}
