package com.favmovie.exceptions;

public class NotFoundException extends RuntimeException{
    private final static String DESCRIPTION = "NOT FOUND(404)";
    public NotFoundException(String detail){
        super(DESCRIPTION + ':'+ detail);
    }
}
