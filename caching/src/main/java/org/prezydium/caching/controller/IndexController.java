package org.prezydium.caching.controller;

import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

    private final CacheManager cacheManager;

    public IndexController(CacheManager cacheManager) {
        this.cacheManager = cacheManager;
    }

    @GetMapping(path = "/")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("cacheName", cacheManager.getClass().getSimpleName());
        return modelAndView;
    }
}
