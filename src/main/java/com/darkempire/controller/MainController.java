package com.darkempire.controller;

import com.darkempire.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

/**
 * Created by Сергій on 21.10.2014.
 */

@Controller
public class MainController {

    @Autowired
    UserService userService;

    @RequestMapping("/")
    public String root(Locale locale) {
        return "redirect:/index";
    }

    /** Home page. */
    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    /** User zone index. */
    @RequestMapping("/user/index")
    public String userIndex() {
        return "user/index";
    }

    /** Administration zone index. */
    @RequestMapping("/admin/index")
    public String adminIndex() {
        return "admin/index";
    }

    /** Shared zone index. */
    @RequestMapping("/shared/index")
    public String sharedIndex() {
        return "shared/index";
    }

    /** Login form. */
    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    /** Login form with error. */
    @RequestMapping("/login-error")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "login";
    }

    /** Simulation of an exception. */
    @RequestMapping("/simulateError")
    public void simulateError() {
        throw new RuntimeException("This is a simulated error message");
    }

    /** Error page. */
    @RequestMapping("/error")
    public String error(HttpServletRequest request, Model model) {
        model.addAttribute("errorCode", "Error " + request.getAttribute("javax.servlet.error.status_code"));
        Throwable throwable = (Throwable) request.getAttribute("javax.servlet.error.exception");
        StringBuilder errorMessage = new StringBuilder();
        errorMessage.append("<ul>");
        while (throwable != null) {
            errorMessage.append("<li>").append(escapeTags(throwable.getMessage())).append("</li>");
            throwable = throwable.getCause();
        }
        errorMessage.append("</ul>");
        model.addAttribute("errorMessage", errorMessage.toString());
        return "error";
    }

    /** Substitute 'less than' and 'greater than' symbols by its HTML entities. */
    private String escapeTags(String text) {
        if (text == null) {
            return null;
        }
        return text.replaceAll("<", "&lt;").replaceAll(">", "&gt;");
    }


}
