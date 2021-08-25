package dev.jx.app.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.ui.Model;
import dev.jx.app.entity.Adoption;
import dev.jx.app.service.AdoptionService;
import dev.jx.app.service.OwnerService;
import dev.jx.app.service.PetService;

@Controller
public class AdoptionController {

	@Autowired
	@Qualifier("adoptionServiceImpl")
	private AdoptionService adoptionService;

	@Autowired
	@Qualifier("ownerServiceImpl")
	private OwnerService ownerService;

	@Autowired
	private PetService petService;

	@RequestMapping(value = "/adoptions", method = RequestMethod.GET)
	public String getIndex(Map<String, Object> map) {
		map.put("adoptions", this.adoptionService.findAll());
		return "/adoptions/index";
	}

	@RequestMapping(value = "/adoptions/register", method = RequestMethod.GET)
	public String getRegister(Model model, Map<String, Object> map) {
		model.addAttribute("adoption", new Adoption());
		map.put("owners", this.ownerService.findAll());
		map.put("pets", this.petService.findAll());

		return "/adoptions/register";
	}

	@RequestMapping(value = "/adoptions/register", method = RequestMethod.POST)
	public String postRegister(Adoption adoption) {
		this.adoptionService.insert(adoption);
		return "redirect:/adoptions";
	}

	@RequestMapping(value = "/adoptions/{id}/edit", method = RequestMethod.GET)
	public String getEdit(@PathVariable Integer id, Model model, Map<String, Object> map) {
		model.addAttribute("adoption", this.adoptionService.findById(id));
		map.put("owners", this.ownerService.findAll());
		map.put("pets", this.petService.findAll());

		return "/adoptions/edit";
	}

	@RequestMapping(value = "/adoptions/{id}/edit", method = RequestMethod.POST)
	public String postEdit(Adoption adoption) {
		this.adoptionService.update(adoption);
		return "redirect:/adoptions";
	}

	@RequestMapping(value = "/adoptions/{id}/delete", method = RequestMethod.GET)
	public String getDelete(@PathVariable Integer id, Model model) {
		model.addAttribute("adoption", this.adoptionService.findById(id));
		return "/adoptions/delete";
	}

	@RequestMapping(value = "/adoptions/{id}/delete", method = RequestMethod.POST)
	public String postDelete(Adoption adoption) {
		this.adoptionService.deleteById(adoption.getId());
		return "redirect:/adoptions";
	}
}