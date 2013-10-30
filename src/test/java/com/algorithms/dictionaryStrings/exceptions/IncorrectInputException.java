package com.algorithms.dictionaryStrings.exceptions;

public class IncorrectInputException extends RuntimeException {
    public IncorrectInputException(String descritpion, Exception exp) {
        super(descritpion, exp);
    }
}
