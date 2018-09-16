package org.prezydium.caching.controller;


import org.prezydium.caching.dao.DeveloperDao;
import org.prezydium.caching.model.Developer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DataFetcher {

    private static final Logger log = LoggerFactory.getLogger(DataFetcher.class);

    private DeveloperDao developerDao;

    public DataFetcher(DeveloperDao developerDao) {
        this.developerDao = developerDao;
    }
    @GetMapping(path = "/get-developers")
    public String getDevelopers(){
        List<Developer> listOFDevelopers = developerDao.findAll();
        StringBuilder sb = new StringBuilder();
        listOFDevelopers.forEach(sb::append);
        log.info("Fetching data from database");
        return sb.toString();
    }
}
