package com.favmovie.exceptions;

public class UnauthorizedException extends RuntimeException{
    private final static String DESCRIPTION = "UNAUTHORIZED(401)";
    public UnauthorizedException(String detail){
        super(DESCRIPTION + ':'+ detail);
    }
}
