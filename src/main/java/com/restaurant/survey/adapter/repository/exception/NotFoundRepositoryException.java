package com.restaurant.survey.adapter.repository.exception;


import com.restaurant.survey.config.ErrorMessage;
import com.restaurant.survey.config.exception.GenericException;

public final class NotFoundRepositoryException extends GenericException {

    public NotFoundRepositoryException(ErrorMessage errorMsg) {
        super(errorMsg);
    }
}
