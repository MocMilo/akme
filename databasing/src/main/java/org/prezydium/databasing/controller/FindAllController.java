package org.prezydium.databasing.controller;

import org.prezydium.databasing.dao.BuildingJdbcDao;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class FindAllController {

    private final BuildingJdbcDao buildingJdbcDao;

    public FindAllController(BuildingJdbcDao buildingJdbcDao) {
        this.buildingJdbcDao = buildingJdbcDao;
    }

    @RequestMapping(value = "get-all")
    public String getAllByJdbcTemplate() throws IOException {
       List list = buildingJdbcDao.getAll();
       return (String) list.stream().map(x -> x.toString()).collect(Collectors.joining("\n"));

    }

}
