package dev.jx.app.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String getIndex(@RequestParam(defaultValue = "false") Boolean error, Map<String, Object> map) {
        map.put("error", error);
        return "/login";
    }
}
