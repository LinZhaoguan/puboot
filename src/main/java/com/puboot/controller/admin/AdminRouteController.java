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
        return "admin/login";
    }

    /**
     * Login form with error.
     */
    @RequestMapping("/login-error")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "admin/login";
    }

    /**
     * 后台外部框架
     */
    @RequestMapping("/admin")
    public String index() {
        return "admin/index";
    }

    /**
     * 后台主页
     */
    @RequestMapping("/admin/dashboard")
    public String dashboard() {
        return "admin/dashboard/dashboard";
    }


    /**
     * 权限管理-用户列表
     */
    @RequestMapping("/admin/user")
    public String user() {
        return "admin/system/user";
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