package com.favmovie.exceptions;

public class ForbiddenException extends RuntimeException{
    private final static String DESCRIPTION = "FORBIDDEN (403)";
    public ForbiddenException(String detail){
        super(DESCRIPTION + ':'+ detail);
    }
}
