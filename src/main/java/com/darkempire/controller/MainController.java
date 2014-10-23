package com.darkempire.controller;

import com.darkempire.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Сергій on 21.10.2014.
 */

@Controller
public class MainController {


    @Autowired
    UserService userService;

    @RequestMapping(value = { "/", "/welcome**" }, method = RequestMethod.GET)
    public ModelAndView defaultPage() {

        org.springframework.web.servlet.ModelAndView model = new org.springframework.web.servlet.ModelAndView();
        model.addObject("title", "Spring Security + Hibernate Example");
        model.addObject("message", userService.getUser(1).getEmail());
        model.setViewName("index");
        
        return model;
    }
}
