package com.favmovie.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ExcenptionHandler {

    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorMessage badRequest(HttpServletRequest req, Exception exception){
        return new ErrorMessage(exception,req.getRequestURI());
    }
    @ExceptionHandler(ConflictException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorMessage conflict(HttpServletRequest req, Exception exception){
        return new ErrorMessage(exception,req.getRequestURI());
    }
    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorMessage notFound(HttpServletRequest req, Exception exception){
        return new ErrorMessage(exception,req.getRequestURI());
    }
    @ExceptionHandler(ForbiddenException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorMessage forbidden(HttpServletRequest req, Exception exception){
        return new ErrorMessage(exception,req.getRequestURI());
    }
    @ExceptionHandler(UnauthorizedException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorMessage unAuthorized(HttpServletRequest req, Exception exception){
        return new ErrorMessage(exception,req.getRequestURI());
    }
}
