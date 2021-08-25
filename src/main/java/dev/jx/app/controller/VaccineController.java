package dev.jx.app.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.ui.Model;
import dev.jx.app.entity.Vaccine;
import dev.jx.app.service.VaccineService;

@Controller
public class VaccineController {

	@Autowired
	@Qualifier("vaccineServiceImpl")
	private VaccineService vaccineService;

	@RequestMapping(value = "/vaccines", method = RequestMethod.GET)
	public String getIndex(Map<String, Object> map) {
		map.put("vaccines", this.vaccineService.findAll());
		return "/vaccines/index";
	}

	@RequestMapping(value = "/vaccines/register", method = RequestMethod.GET)
	public String getRegister(Model model) {
		model.addAttribute("vaccine", new Vaccine());
		return "/vaccines/register";
	}

	@RequestMapping(value = "/vaccines/register", method = RequestMethod.POST)
	public String postRegister(Vaccine vaccine) {
		this.vaccineService.insert(vaccine);
		return "redirect:/vaccines";
	}

	@RequestMapping(value = "/vaccines/{id}/edit", method = RequestMethod.GET)
	public String getEdit(@PathVariable Integer id, Model model) {
		model.addAttribute("vaccine", this.vaccineService.findById(id));
		return "/vaccines/edit";
	}

	@RequestMapping(value = "/vaccines/{id}/edit", method = RequestMethod.POST)
	public String postEdit(Vaccine vaccine) {
		this.vaccineService.update(vaccine);
		return "redirect:/vaccines";
	}

	@RequestMapping(value = "/vaccines/{id}/delete", method = RequestMethod.GET)
	public String getDelete(@PathVariable Integer id, Model model) {
		model.addAttribute("vaccine", this.vaccineService.findById(id));
		return "/vaccines/delete";
	}

	@RequestMapping(value = "/vaccines/{id}/delete", method = RequestMethod.POST)
	public String postDelete(Vaccine vaccine) {
		this.vaccineService.deleteById(vaccine.getId());
		return "redirect:/vaccines";
	}
}