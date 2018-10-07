package org.prezydium;

import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {


    @GetMapping(path = "/")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("main-index");
        return modelAndView;
    }
}
