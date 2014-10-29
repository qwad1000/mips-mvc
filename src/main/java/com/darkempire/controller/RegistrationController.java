package com.darkempire.controller;

import com.darkempire.model.User;
import com.darkempire.services.UserService;
import com.darkempire.services.validation.UserExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

/**
 * Created by Сергій on 28.10.2014.
 */

@Controller
public class RegistrationController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "registration.html", method = RequestMethod.GET)
    public String showRegistrationForm(WebRequest request, Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "registration.html";
    }
    @RequestMapping(value = "registration.html", method = RequestMethod.POST)
    public ModelAndView registerUserAccount( @ModelAttribute("user") @Valid User account, BindingResult result, WebRequest request, Errors errors) {
        User registered = new User();
        if (!result.hasErrors()) {
            registered = createUserAccount(account, result);
        }
        if (registered == null) {
            result.rejectValue("email", "An account for that username/email already exists. Please enter a different username.");
        }
        if (result.hasErrors()) {
            return new ModelAndView("registration.html", "user", account);
        } else {
            return new ModelAndView("user/successfullyRegistered.html", "user", account);
        }
    }
    private User createUserAccount(User account, BindingResult result) {
        User registered = null;
        try {
            registered = userService.registerUser(account);
        } catch (UserExistsException e) {
            return null;
        }
        return registered;
    }
}
