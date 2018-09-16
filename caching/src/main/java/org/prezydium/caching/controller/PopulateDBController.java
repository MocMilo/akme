package org.prezydium.caching.controller;

import org.prezydium.caching.dao.DeveloperDao;
import org.prezydium.caching.model.Developer;
import org.prezydium.caching.model.Gender;
import org.prezydium.caching.model.ProgrammingLanguages;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.EnumSet;


@RestController
public class PopulateDBController {

    private DeveloperDao developerDao;

    public PopulateDBController(DeveloperDao developerDao) {
        this.developerDao = developerDao;
    }

    @GetMapping(path = "/test")
    public String populateDBWithExampleData() {
        Developer dev3k
                = new Developer("Kristoff", "Jawowski",
                3000, Gender.MALE, EnumSet.of(ProgrammingLanguages.JAVA, ProgrammingLanguages.JAVA_SCRIPT));
        developerDao.save(dev3k);
        Developer dev15k
                = new Developer("Maria", "von Magdala",
                15000, Gender.FEMALE, EnumSet.of(ProgrammingLanguages.C_PLUS_PLUS, ProgrammingLanguages.PYTHON));
        developerDao.save(dev15k);
        Developer dev25k
                = new Developer("TINKY", "WINKI",
                15000, Gender.OTHER, EnumSet.of(ProgrammingLanguages.JAVA));
        developerDao.save(dev25k);
        return "OK";
    }

}
