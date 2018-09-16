package org.prezydium.caching.controller;


import org.prezydium.caching.dao.DeveloperDao;
import org.prezydium.caching.model.DevEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class DevController {

    private final DeveloperDao developerDao;

    public DevController(DeveloperDao developerDao) {
        this.developerDao = developerDao;
    }

    @RequestMapping(path = "/add", method = RequestMethod.POST)
    public RedirectView addDev(@RequestBody DevEntity dev){
        if (dev == null) throw new IllegalArgumentException("Empty dev");
        developerDao.save(dev);
        return new RedirectView("/");
    }

    @RequestMapping(path = "/delete", method = RequestMethod.POST)
    public RedirectView removeDev(@RequestBody Long devId){
        if (devId == null) throw new IllegalArgumentException("Empty dev Id");
        developerDao.deleteById(devId);
        return new RedirectView("/");

    }

}
