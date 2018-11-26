package ru.maxim.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.FileNotFoundException;


@Controller
@RequestMapping("/")
public class MainController {

    @Value("${value:none}")
    private String value;


    @RequestMapping(method = RequestMethod.GET)
    public String printWelcome(ModelMap model) throws FileNotFoundException {

        model.addAttribute("message", "Hello world!");
        model.addAttribute("property_value", value);
        return "index";
    }
}