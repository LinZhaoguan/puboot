package com.puboot.controller.admin;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Application home page and login.
 */
@Controller
@RequestMapping("/")
public class AdminRouteController {


    /**
     * Login form.
     */
    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    /**
     * Login form with error.
     */
    @RequestMapping("/login-error")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "login";
    }

    /**
     * Error page.
     */
    @RequestMapping("/admin")
    public String index() {
        return "admin/index";
    }

    /**
     * Error page.
     */
    @PreAuthorize("hasAuthority('abc')")
    @RequestMapping("/admin/1")
    public String index1() {
        return "admin/index";
    }


}