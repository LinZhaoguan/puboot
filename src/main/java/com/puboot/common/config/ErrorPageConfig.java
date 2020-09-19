package com.puboot.common.config;

import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.ErrorPageRegistrar;
import org.springframework.boot.web.server.ErrorPageRegistry;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

import java.util.stream.Stream;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Nobita
 * @date 2020/9/19 12:43 下午
 */
@Configuration
public class ErrorPageConfig implements ErrorPageRegistrar {

    @Override
    public void registerErrorPages(ErrorPageRegistry registry) {
        Stream
                .of(HttpStatus.FORBIDDEN, HttpStatus.NOT_FOUND, HttpStatus.INTERNAL_SERVER_ERROR)
                .map(httpStatus -> new ErrorPage(httpStatus, "/error/" + httpStatus.value()))
                .forEach(errorPage -> registry.addErrorPages(errorPage));
    }
}
