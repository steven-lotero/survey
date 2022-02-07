package com.restaurant.survey.adapter.controller;


import com.restaurant.survey.adapter.controller.model.ErrorResponse;
import com.restaurant.survey.adapter.controller.model.ResponseRequest;
import com.restaurant.survey.adapter.controller.model.SurveyResponse;
import com.restaurant.survey.application.port.in.SaveResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import javax.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1.0")
@Validated
@AllArgsConstructor
@Api
@Slf4j
public class ResponseController {

    private final SaveResponse saveResponse;

    @PostMapping("/responses")
    @ApiOperation(value = "Save Response", response = SurveyResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Success", response = SurveyResponse.class),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found", response = ErrorResponse.class),
            @ApiResponse(code = 500, message = "Internal server error", response = ErrorResponse.class)
    })
    @ResponseStatus(HttpStatus.CREATED)
    public void saveAnswer(
            final @Valid @RequestBody ResponseRequest responseRequest
    ) {
        log.info("Response request {}", responseRequest);
        saveResponse.execute(responseRequest.toDomain());
    }

}
