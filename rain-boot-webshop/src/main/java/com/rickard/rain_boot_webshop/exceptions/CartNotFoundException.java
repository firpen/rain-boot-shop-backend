package com.rickard.rain_boot_webshop.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/* https://spring.io/blog/2013/11/01/exception-handling-in-spring-mvc */
@ResponseStatus(value = HttpStatus.NOT_FOUND) 
public class CartNotFoundException extends RuntimeException {
    
}
