package dev.jx.app.controller;

import java.util.Map;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import org.springframework.data.domain.*;
import org.springframework.validation.BindingResult;
import dev.jx.app.entity.Pet;
import dev.jx.app.service.PetService;
import dev.jx.app.service.ImageService;
import dev.jx.app.service.AnimalService;
import dev.jx.app.validation.PetValidator;

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

    @Autowired
    private PetValidator petValidator;

    @RequestMapping(value = "/pets", method = RequestMethod.GET)
    public String getIndex(
            @RequestParam(defaultValue = "id") String sort,
            @RequestParam(defaultValue = "ASC") Sort.Direction direction,
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "5") Integer pageSize,
            Pet petSearchParams,
            Map<String, Object> map
    ) {
        Pageable pageRequest = PageRequest.of(
                page,
                pageSize,
                Sort.by(direction, sort)
        );
        Page<Pet> petPage = this.petService.findAll(
                Example.of(
                        petSearchParams,
                        ExampleMatcher.matchingAll()
                                .withMatcher(
                                        "name",
                                        new ExampleMatcher.GenericPropertyMatcher().contains().ignoreCase()
                                ).withIgnoreNullValues()
                ), pageRequest);
        map.put("pets", petPage.getContent());
        map.put("petPage", petPage);
        map.put("petSearchParams", petSearchParams);
        map.put("sort", sort);
        map.put("direction", direction);
        map.put("beginPage", Math.max(petPage.getNumber() - 4, 0));
        map.put("endPage", Math.max(Math.min(petPage.getNumber() + 5, petPage.getTotalPages() - 1), 0));

        return "/pets/index";
    }

    @RequestMapping(value = "/pets/{id}", method = RequestMethod.GET)
    public String getDetails(@PathVariable Integer id, Model model) {
        model.addAttribute("pet", this.petService.findById(id));
        return "/pets/details";
    }

    @RequestMapping(value = "/pets/register", method = RequestMethod.GET)
    public String getRegister(Model model, Map<String, Object> map) {
        model.addAttribute("pet", new Pet());
        map.put("images", this.imageService.findAllByPetIsNull());
        map.put("animals", this.animalService.findAll());

        return "/pets/register";
    }

    @RequestMapping(value = "/pets/register", method = RequestMethod.POST)
    public String postRegister(@Valid Pet pet, BindingResult bindingResult, Model model, Map<String, Object> map) {
        String page = "redirect:/pets";
        this.petValidator.validate(pet, bindingResult);

        if (bindingResult.hasErrors()) {
            page = "/pets/register";
            model.addAttribute("pet", pet);
            map.put("images", this.imageService.findAllByPetIsNull());
            map.put("animals", this.animalService.findAll());
        } else {
            this.petService.insert(pet);
        }

        return page;
    }

    @RequestMapping(value = "/pets/{id}/edit", method = RequestMethod.GET)
    public String getEdit(@PathVariable Integer id, Model model, Map<String, Object> map) {
        Pet pet = this.petService.findById(id);
        model.addAttribute("pet", pet);
        map.put("images", this.imageService.findAllByPetIsNullOrPet_Id(pet.getId()));
        map.put("animals", this.animalService.findAll());

        return "/pets/edit";
    }

    @RequestMapping(value = "/pets/{id}/edit", method = RequestMethod.POST)
    public String postEdit(
            @Valid Pet pet,
            BindingResult bindingResult,
            Model model,
            Map<String, Object> map
    ) {
        String page = "redirect:/pets";
        this.petValidator.validate(pet, bindingResult);

        if (bindingResult.hasErrors()) {
            page = "/pets/edit";
            model.addAttribute("pet", pet);
            map.put("images", this.imageService.findAllByPetIsNullOrPet_Id(pet.getId()));
            map.put("animals", this.animalService.findAll());
        } else {
            this.petService.update(pet);
        }

        return page;
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