package org.prezydium.caching.controller;

import org.prezydium.caching.model.DevFormModel;
import org.prezydium.caching.model.Gender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Controller
public class DevViewController {

    @GetMapping(path = "/add-dev")
    public ModelAndView addDevView() {
        ModelAndView modelAndView = new ModelAndView("add");
        modelAndView.addObject("devFormModel", new DevFormModel());
        modelAndView.addObject("genders", new HashSet<>(Arrays.asList(Gender.values())));
        return modelAndView;
    }

    @PostMapping(path = "/add-dev")
    public ModelAndView addDevService() {
        ModelAndView modelAndView = new ModelAndView("add");
        return modelAndView;
    }
}
