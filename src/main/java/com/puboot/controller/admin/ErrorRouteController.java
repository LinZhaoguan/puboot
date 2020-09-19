package com.puboot.controller.admin;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Nobita
 * @date 2020/9/19 9:31 下午
 */
@Controller
@RequestMapping("/error")
public class ErrorRouteController {

    @RequestMapping("/{statusCode}")
    public String error(@PathVariable("statusCode") Integer statusCode) {
        if (statusCode == null) {
            return "/common/error/" + HttpStatus.INTERNAL_SERVER_ERROR.value();
        }
        return "/common/error/" + statusCode;
    }

}
