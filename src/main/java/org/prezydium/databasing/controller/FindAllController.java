package org.prezydium.databasing.controller;

import org.prezydium.databasing.dao.BuildingJdbcDao;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class FindAllController {

    private final BuildingJdbcDao buildingJdbcDao;

    public FindAllController(BuildingJdbcDao buildingJdbcDao) {
        this.buildingJdbcDao = buildingJdbcDao;
    }

    @GetMapping(value = "/db/list-buildings")
        public ModelAndView getAllBuildings() throws IOException {
            ModelAndView modelAndView = new ModelAndView("buildings-list");
            modelAndView.addObject("buildingsList", buildingJdbcDao.getAll());
            return modelAndView;
    }
}
