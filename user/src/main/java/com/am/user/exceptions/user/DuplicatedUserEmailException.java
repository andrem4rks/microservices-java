package com.am.user.exceptions.user;

import org.springframework.dao.DuplicateKeyException;

public class DuplicatedUserEmailException extends RuntimeException {

    public DuplicatedUserEmailException(String msg) {
        super(msg);
    }
}
