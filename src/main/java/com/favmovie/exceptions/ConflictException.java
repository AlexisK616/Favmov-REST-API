package com.favmovie.exceptions;

public class ConflictException extends RuntimeException{
    private final static String DESCRIPTION = "CONFLICT (409)";
    public ConflictException(String detail){
        super(DESCRIPTION + ':'+ detail);
    }
}
