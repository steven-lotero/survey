package com.restaurant.survey.adapter.controller.model;

import io.swagger.annotations.ApiModel;
import java.util.List;
import lombok.Builder;
import lombok.Getter;

@Builder
@ApiModel
@Getter
public class ErrorResponse {

    private final ResponseRestStatus status;
    private final List<String> errors;
}
