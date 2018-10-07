package org.prezydium.caching.controller;

import org.prezydium.caching.service.ManualClearCacheService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class ClearCacheRestController {

    private final ManualClearCacheService manualClearCacheService;

    public ClearCacheRestController(ManualClearCacheService manualClearCacheService) {
        this.manualClearCacheService = manualClearCacheService;
    }

    @RequestMapping(path = "clear")
    public RedirectView clearCacheEndpoint(){
        manualClearCacheService.clearCache();
        return new RedirectView("/");
    }
}
