package org.prezydium.caching.controller;

import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CachingIndexController {

    private final CacheManager cacheManager;

    public CachingIndexController(CacheManager cacheManager) {
        this.cacheManager = cacheManager;
    }

    @GetMapping(path = "/ca/caching")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("caching-index");
        modelAndView.addObject("cacheName", cacheManager.getClass().getSimpleName());
        return modelAndView;
    }
}
