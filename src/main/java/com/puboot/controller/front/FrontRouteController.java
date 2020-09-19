package com.puboot.controller.front;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Locale;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Nobita
 * @date 2020/9/19 9:11 下午
 */
@Slf4j
@Controller
@RequestMapping
public class FrontRouteController {

    @RequestMapping("/")
    public String root(Locale locale) {
        return "index";
    }
}
