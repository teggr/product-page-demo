package com.robintegg.web;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "product.selection.error.nocookie")
public class NoCustomerIDCookieException extends RuntimeException {

}
