package dev.jx.app.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.ui.Model;
import dev.jx.app.entity.Animal;
import dev.jx.app.service.AnimalService;

@Controller
public class AnimalController {

	@Autowired
	@Qualifier("animalServiceImpl")
	private AnimalService animalService;

	@RequestMapping(value = "/animals", method = RequestMethod.GET)
	public String getIndex(Map<String, Object> map) {
		map.put("animals", this.animalService.findAll());
		return "/animals/index";
	}

	@RequestMapping(value = "/animals/register", method = RequestMethod.GET)
	public String getRegister(Model model) {
		model.addAttribute("animal", new Animal());
		return "/animals/register";
	}

	@RequestMapping(value = "/animals/register", method = RequestMethod.POST)
	public String postRegister(Animal animal) {
		this.animalService.insert(animal);
		return "redirect:/animals";
	}

	@RequestMapping(value = "/animals/{id}/edit", method = RequestMethod.GET)
	public String getEdit(@PathVariable Integer id, Model model) {
		model.addAttribute("animal", this.animalService.findById(id));
		return "/animals/edit";
	}

	@RequestMapping(value = "/animals/{id}/edit", method = RequestMethod.POST)
	public String postEdit(Animal animal) {
		this.animalService.update(animal);
		return "redirect:/animals";
	}

	@RequestMapping(value = "/animals/{id}/delete", method = RequestMethod.GET)
	public String getDelete(@PathVariable Integer id, Model model) {
		model.addAttribute("animal", this.animalService.findById(id));
		return "/animals/delete";
	}

	@RequestMapping(value = "/animals/{id}/delete", method = RequestMethod.POST)
	public String postDelete(Animal animal) {
		this.animalService.deleteById(animal.getId());
		return "redirect:/animals";
	}
}