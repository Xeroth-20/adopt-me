package dev.jx.app.controller;

import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import dev.jx.app.entity.Area;
import dev.jx.app.entity.Animal;
import dev.jx.app.service.AreaService;
import dev.jx.app.service.AnimalService;

@Controller
public class AreaAnimalController {

    @Autowired
    @Qualifier("areaServiceImpl")
    private AreaService areaService;

    @Autowired
    @Qualifier("animalServiceImpl")
    private AnimalService animalService;

    private static final Set<Animal> animalsCart = new TreeSet<>();

    @RequestMapping(value = "/areas-animals", method = RequestMethod.GET)
    public String getIndex(Map<String, Object> map) {
        map.put("areasAnimals", this.areaService.findAllAreasAnimals());
        animalsCart.clear();

        return "/areas-animals/index";
    }

    @RequestMapping(value = "/areas-animals/{id}", method = RequestMethod.GET)
    public String getDetails(@PathVariable Integer id, Model model, Map<String, Object> map) {
        Area area = this.areaService.findById(id);
        model.addAttribute("area", area);
        map.put("animals", new TreeSet<>(area.getAnimals()));

        return "/areas-animals/details";
    }

    @RequestMapping(value = "/areas-animals/{id}/register", method = RequestMethod.GET)
    public String getRegister(@PathVariable Integer id, Model model, Map<String, Object> map) {
        Area area = this.areaService.findById(id);
        model.addAttribute("area", area);
        map.put(
                "animals",
                animalsCart.size() == 0
                        ? this.animalService.findAllByAreasNotContaining(area)
                        : this.animalService.findAllByAreasNotContainingAndIdNotIn(
                        area,
                        animalsCart.stream().map(Animal::getId).collect(Collectors.toList())
                )
        );
        map.put("areaAnimals", new TreeSet<>(area.getAnimals()));
        map.put("animalsCart", animalsCart);

        return "/areas-animals/register";
    }

    @RequestMapping(value = "/areas-animals/{id}/register", method = RequestMethod.POST)
    public String postRegister(@PathVariable Integer id) {
        Area area = this.areaService.findById(id);
        area.getAnimals().addAll(animalsCart);
        this.areaService.update(area);
        animalsCart.clear();

        return "redirect:/areas-animals/" + id;
    }

    @RequestMapping(value = "/areas-animals/add-animal", method = RequestMethod.POST)
    public String postAddAnimal(@RequestParam Integer areaId, @RequestParam Integer animalId) {
        animalsCart.add(this.animalService.findById(animalId));
        return "redirect:/areas-animals/" + areaId + "/register";
    }

    @RequestMapping(value = "/area-animals/register", method = RequestMethod.POST)
    public String postRegister(
            @RequestParam Integer areaId,
            @RequestParam Integer animalId
    ) {
        Area area = this.areaService.findById(areaId);
        Animal animal = this.animalService.findById(animalId);
        area.getAnimals().add(animal);
        this.areaService.update(area);

        return "redirect:/areas/" + area.getId() + "/allowed-animals";
    }

    @RequestMapping(value = "/area-animals/delete", method = RequestMethod.POST)
    public String postDelete(
            @RequestParam Integer areaId,
            @RequestParam Integer animalId
    ) {
        Area area = this.areaService.findById(areaId);
        Animal animal = this.animalService.findById(animalId);
        area.getAnimals().remove(animal);
        this.areaService.update(area);

        return "redirect:/areas/" + area.getId() + "/allowed-animals";
    }
}
