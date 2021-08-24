package com.example.studentsManagement.exception;

public class StudentEmptyNameException extends RuntimeException{
    public StudentEmptyNameException(String message) {
        super(message);
    }
}
