package com.restaurant.survey.config;

public enum ErrorMessage {

    INTERNAL_ERROR("internal_server_error"),
    BAD_REQUEST_EXCEPTION("input_data_error"),
    SURVEY_NOT_FOUND("survey_not_found"),
    NOT_FOUND("values_not_found");

    private final String reasonPhrase;

    ErrorMessage(String reasonPhrase) {
        this.reasonPhrase = reasonPhrase;
    }

    public String getReasonPhrase() {
        return this.reasonPhrase;
    }
}

