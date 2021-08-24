package com.example.studentsManagement.exception;

public class StudentNonExistException extends RuntimeException{
    public StudentNonExistException(String message) {
        super(message);
    }
}
