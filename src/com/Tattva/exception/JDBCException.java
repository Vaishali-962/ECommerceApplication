package com.Tattva.exception;

public class JDBCException extends RuntimeException{
    public JDBCException(String message){
        super(message);
    }
}
