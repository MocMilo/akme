package org.prezydium.databasing.controller;

import org.prezydium.databasing.dao.BuildingJdbcDao;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class FindAllController {

    private final BuildingJdbcDao buildingJdbcDao;

    public FindAllController(BuildingJdbcDao buildingJdbcDao) {
        this.buildingJdbcDao = buildingJdbcDao;
    }

    @RequestMapping(value = "get-all")
    public String getAllByJdbcTemplate() throws IOException {
       List list = buildingJdbcDao.getAll();
       return String.join(" ,", list);

    }

}
