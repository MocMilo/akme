package org.prezydium.caching.controller;

import org.prezydium.caching.dao.DeveloperDao;
import org.prezydium.caching.model.DevEntity;
import org.prezydium.caching.model.Gender;
import org.prezydium.caching.model.ProgrammingLanguages;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import java.util.EnumSet;


@RestController
public class PopulateDBController {

    private DeveloperDao developerDao;

    public PopulateDBController(DeveloperDao developerDao) {
        this.developerDao = developerDao;
    }

    @GetMapping(path = "/create-test-data")
    public RedirectView populateDBWithExampleData() {
        DevEntity dev3k
                = new DevEntity("Kristoff", "Jawowski",
                3000, Gender.MALE, EnumSet.of(ProgrammingLanguages.JAVA, ProgrammingLanguages.JAVA_SCRIPT));
        developerDao.save(dev3k);
        DevEntity dev15k
                = new DevEntity("Maria", "von Magdala",
                15000, Gender.FEMALE, EnumSet.of(ProgrammingLanguages.C_PLUS_PLUS, ProgrammingLanguages.PYTHON));
        developerDao.save(dev15k);
        DevEntity dev25k
                = new DevEntity("TINKY", "WINKI",
                15000, Gender.OTHER, EnumSet.of(ProgrammingLanguages.JAVA));
        developerDao.save(dev25k);
        return new RedirectView("/");
    }

}
