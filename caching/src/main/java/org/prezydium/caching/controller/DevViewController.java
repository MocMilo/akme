package org.prezydium.caching.controller;

import org.prezydium.caching.dao.DeveloperDao;
import org.prezydium.caching.model.DevFormModel;
import org.prezydium.caching.model.Gender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.HashSet;

@Controller
public class DevViewController {

    private final DeveloperDao developerDao;

    @Autowired
    public DevViewController(DeveloperDao developerDao) {
        this.developerDao = developerDao;
    }

    @GetMapping(path = "/add-dev")
    public ModelAndView addDevView() {
        ModelAndView modelAndView = new ModelAndView("save");
        modelAndView.addObject("devFormModel", new DevFormModel());
        modelAndView.addObject("genders", new HashSet<>(Arrays.asList(Gender.values())));
        return modelAndView;
    }

    @GetMapping(path = "/list-dev")
    public ModelAndView addDevService() {
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("devList", developerDao.findAll());
        return modelAndView;
    }
}
