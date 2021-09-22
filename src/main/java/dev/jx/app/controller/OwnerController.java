package dev.jx.app.controller;

import java.util.Map;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.ui.Model;
import dev.jx.app.entity.Owner;
import dev.jx.app.service.OwnerService;
import dev.jx.app.util.pdf.OwnerPDFExporter;

@Controller
public class OwnerController {

    @Autowired
    @Qualifier("ownerServiceImpl")
    private OwnerService ownerService;

    @RequestMapping(value = "/owners", method = RequestMethod.GET)
    public String getIndex(Map<String, Object> map) {
        map.put("owners", this.ownerService.findAll());
        return "/owners/index";
    }

    @RequestMapping(value = "/owners/register", method = RequestMethod.GET)
    public String getRegister(Model model) {
        model.addAttribute("owner", new Owner());
        return "/owners/register";
    }

    @RequestMapping(value = "/owners/register", method = RequestMethod.POST)
    public String postRegister(Owner owner) {
        this.ownerService.insert(owner);
        return "redirect:/owners";
    }

    @RequestMapping(value = "/owners/{id}/edit", method = RequestMethod.GET)
    public String getEdit(@PathVariable Integer id, Model model) {
        model.addAttribute("owner", this.ownerService.findById(id));
        return "/owners/edit";
    }

    @RequestMapping(value = "/owners/{id}/edit", method = RequestMethod.POST)
    public String postEdit(Owner owner) {
        this.ownerService.update(owner);
        return "redirect:/owners";
    }

    @RequestMapping(value = "/owners/{id}/delete", method = RequestMethod.GET)
    public String getDelete(@PathVariable Integer id, Model model) {
        model.addAttribute("owner", this.ownerService.findById(id));
        return "/owners/delete";
    }

    @RequestMapping(value = "/owners/{id}/delete", method = RequestMethod.POST)
    public String postDelete(Owner owner) {
        this.ownerService.deleteById(owner.getId());
        return "redirect:/owners";
    }

    @RequestMapping(value = "/owners/{id}/export-pdf", method = RequestMethod.GET)
    public void getPDF(@PathVariable Integer id, HttpServletResponse response) throws IOException {
        response.setHeader("Content-Type", "application/pdf");
        OwnerPDFExporter ownerPDFExporter = new OwnerPDFExporter();
        ownerPDFExporter.export(this.ownerService.findById(id), response);
    }
}