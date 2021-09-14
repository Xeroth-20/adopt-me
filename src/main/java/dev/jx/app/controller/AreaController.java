package dev.jx.app.controller;

import java.util.HashSet;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.ui.Model;
import dev.jx.app.entity.Area;
import dev.jx.app.service.AreaService;
import dev.jx.app.service.AnimalService;

@Controller
public class AreaController {

    @Autowired
    @Qualifier("areaServiceImpl")
    private AreaService areaService;

    @Autowired
    @Qualifier("animalServiceImpl")
    private AnimalService animalService;

    @RequestMapping(value = "/areas", method = RequestMethod.GET)
    public String getIndex(Map<String, Object> map) {
        map.put("areas", this.areaService.findAll());
        return "/areas/index";
    }

    @RequestMapping(value = "/areas/register", method = RequestMethod.GET)
    public String getRegister(Model model) {
        model.addAttribute("area", new Area());
        return "/areas/register";
    }

    @RequestMapping(value = "/areas/register", method = RequestMethod.POST)
    public String postRegister(Area area) {
        this.areaService.insert(area);
        return "redirect:/areas";
    }

    @RequestMapping(value = "/areas/{id}/edit", method = RequestMethod.GET)
    public String getEdit(@PathVariable Integer id, Model model) {
        model.addAttribute("area", this.areaService.findById(id));
        return "/areas/edit";
    }

    @RequestMapping(value = "/areas/{id}/edit", method = RequestMethod.POST)
    public String postEdit(Area area) {
        area.setAnimals(new HashSet<>(this.animalService.findAllByAreasContaining(area)));
        this.areaService.update(area);
        return "redirect:/areas";
    }

    @RequestMapping(value = "/areas/{id}/delete", method = RequestMethod.GET)
    public String getDelete(@PathVariable Integer id, Model model) {
        model.addAttribute("area", this.areaService.findById(id));
        return "/areas/delete";
    }

    @RequestMapping(value = "/areas/{id}/delete", method = RequestMethod.POST)
    public String postDelete(Area area) {
        this.areaService.deleteById(area.getId());
        return "redirect:/areas";
    }

    @RequestMapping(value = "/areas/{id}/allowed-animals", method = RequestMethod.GET)
    public String getAllowedAnimals(@PathVariable Integer id, Model model, Map<String, Object> map) {
        Area area = this.areaService.findById(id);
        model.addAttribute("area", area);
        map.put("animals", this.animalService.findAllByAreasNotContaining(area));

        return "/areas/allowed-animals";
    }
}