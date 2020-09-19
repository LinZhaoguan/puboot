package com.puboot.common.exception.advice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@Slf4j
@ControllerAdvice
public class ExceptionAdvice {


    /**
     * Spring MVC 默认会吞噬 Spring Security 方法级权限验证产生的异常(例如@PreAuthorize)
     * 讨论帖子：https://stackoverflow.com/questions/21171882/spring-security-ignoring-access-denied-handler-with-method-level-security
     *
     * @return
     */
    @ExceptionHandler(AccessDeniedException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public String exception(final AccessDeniedException exception, Model model) {
        String errorMessage = exception != null ? exception.getMessage() : "内部异常";
        model.addAttribute("errorMessage", errorMessage);
        return "/common/error/" + HttpStatus.FORBIDDEN.value();
    }


    @ExceptionHandler(Throwable.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String exception(final Throwable throwable, final Model model) {
        log.error("Exception during execution of SpringSecurity application", throwable);
        String errorMessage = throwable != null ? throwable.getMessage() : "Unknown error";
        model.addAttribute("errorMessage", errorMessage);
        return "error";
    }

}