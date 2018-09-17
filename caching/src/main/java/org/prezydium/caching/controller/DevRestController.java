package org.prezydium.caching.controller;


import org.prezydium.caching.dao.DeveloperDao;
import org.prezydium.caching.dto.DevConverter;
import org.prezydium.caching.model.DevEntity;
import org.prezydium.caching.model.DevFormModel;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class DevRestController {

    private final DeveloperDao developerDao;
    private final DevConverter devConverter;

    public DevRestController(DeveloperDao developerDao, DevConverter devConverter) {
        this.developerDao = developerDao;
        this.devConverter = devConverter;
    }

    @RequestMapping(path = "/save", method = RequestMethod.POST)
    public RedirectView addDev(@ModelAttribute DevFormModel dev) {
        if (dev == null) {
            throw new IllegalArgumentException("Empty dev");
        }
        DevEntity devEntity = devConverter.convertFormToEntity(dev);
        developerDao.save(devEntity);
        return new RedirectView("/");
    }

    @RequestMapping(path = "/delete", method = RequestMethod.POST)
    public RedirectView removeDev(@RequestBody Long devId) {
        if (devId == null) throw new IllegalArgumentException("Empty dev Id");
        developerDao.deleteById(devId);
        return new RedirectView("/");

    }

}
