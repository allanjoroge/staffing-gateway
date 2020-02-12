package com.perficient.staffing.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpClientErrorException;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NotFoundException extends HttpClientErrorException {


    public NotFoundException(HttpStatus statusCode) {
        super(HttpStatus.NOT_FOUND);
    }
}

