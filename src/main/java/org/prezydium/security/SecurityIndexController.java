package org.prezydium.security;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.spring5.context.SpringContextUtils;

import javax.servlet.http.HttpSession;

@Controller("secure")
public class SecurityIndexController {

    @GetMapping
    public ModelAndView indexGet() {
        return new ModelAndView("security-index");
    }

    @PostMapping
    public ModelAndView indexPost(HttpSession httpSesion) {
        ModelAndView modelAndView = new ModelAndView("security-index");
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = "NoName";
        if (principal instanceof UserDetails) {
           username = ((UserDetails)principal).getUsername();
        } else {
           username = principal.toString();
        }
        modelAndView.addObject("userName", username);
        return modelAndView;
    }
}
