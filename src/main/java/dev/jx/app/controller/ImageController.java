package dev.jx.app.controller;

import java.util.Map;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import dev.jx.app.entity.Image;
import dev.jx.app.service.ImageService;

@Controller
public class ImageController {

    @Autowired
    @Qualifier("imageServiceImpl")
    private ImageService imageService;

    @RequestMapping(value = "/images", method = RequestMethod.GET)
    public String getIndex(Map<String, Object> map) {
        map.put("images", this.imageService.findAll());
        return "/images/index";
    }

    @RequestMapping(value = "/images/register", method = RequestMethod.GET)
    public String getRegister(Model model) {
        model.addAttribute("image", new Image());
        return "/images/register";
    }

    @RequestMapping(value = "/images/register", method = RequestMethod.POST)
    public String postRegister(Image image, @RequestPart("file") MultipartFile file) throws IOException {
        image.setName(file.getOriginalFilename());
        image.setData(file.getBytes());
        this.imageService.insert(image);

        return "redirect:/images";
    }

    @RequestMapping(value = "/images/{id}/edit", method = RequestMethod.GET)
    public String getEdit(@PathVariable Integer id, Model model) {
        model.addAttribute("image", this.imageService.findById(id));
        return "/images/edit";
    }

    @RequestMapping(value = "/images/{id}/edit", method = RequestMethod.POST)
    public String postEdit(Image image, @RequestPart("file") MultipartFile file) throws IOException {
        image.setName(file.getOriginalFilename());
        image.setData(file.getBytes());
        this.imageService.update(image);

        return "redirect:/images";
    }

    @RequestMapping(value = "/images/{id}/delete", method = RequestMethod.GET)
    public String getDelete(@PathVariable Integer id, Model model) {
        model.addAttribute("image", this.imageService.findById(id));
        return "/images/delete";
    }

    @RequestMapping(value = "/images/{id}/delete", method = RequestMethod.POST)
    public String postDelete(Image image) {
        this.imageService.deleteById(image.getId());
        return "redirect:/images";
    }
}