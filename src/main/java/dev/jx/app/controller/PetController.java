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
import dev.jx.app.service.ImageService;
import dev.jx.app.service.AnimalService;

@Controller
public class PetController {

    @Autowired
    private PetService petService;

    @Autowired
    @Qualifier("imageServiceImpl")
    private ImageService imageService;

    @Autowired
    @Qualifier("animalServiceImpl")
    private AnimalService animalService;

    @RequestMapping(value = "/pets", method = RequestMethod.GET)
    public String getIndex(Map<String, Object> map) {
        map.put("pets", this.petService.findAll());
        return "/pets/index";
    }

    @RequestMapping(value = "/pets/{name}", method = RequestMethod.GET)
    public String getDetails(@PathVariable String name, Model model) {
        model.addAttribute("pet", this.petService.findByName(name));
        return "/pets/details";
    }

    @RequestMapping(value = "/pets/register", method = RequestMethod.GET)
    public String getRegister(Model model, Map<String, Object> map) {
        model.addAttribute("pet", new Pet());
        map.put("images", this.imageService.findAll());
        map.put("animals", this.animalService.findAll());

        return "/pets/register";
    }

    @RequestMapping(value = "/pets/register", method = RequestMethod.POST)
    public String postRegister(Pet pet) {
        this.petService.insert(pet);
        return "redirect:/pets";
    }

    @RequestMapping(value = "/pets/{id}/edit", method = RequestMethod.GET)
    public String getEdit(@PathVariable Integer id, Model model, Map<String, Object> map) {
        model.addAttribute("pet", this.petService.findById(id));
        map.put("images", this.imageService.findAll());
        map.put("animals", this.animalService.findAll());
        
        return "/pets/edit";
    }

    @RequestMapping(value = "/pets/{id}/edit", method = RequestMethod.POST)
    public String postEdit(Pet pet) {
        this.petService.update(pet);
        return "redirect:/pets";
    }

    @RequestMapping(value = "/pets/{id}/delete", method = RequestMethod.GET)
    public String getDelete(@PathVariable Integer id, Model model) {
        model.addAttribute("pet", this.petService.findById(id));
        return "/pets/delete";
    }

    @RequestMapping(value = "/pets/{id}/delete", method = RequestMethod.POST)
    public String postDelete(Pet pet) {
        this.petService.deleteById(pet.getId());
        return "redirect:/pets";
    }
}