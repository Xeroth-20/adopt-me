package dev.jx.app.controller;

import dev.jx.app.entity.Animal;
import dev.jx.app.entity.Area;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
