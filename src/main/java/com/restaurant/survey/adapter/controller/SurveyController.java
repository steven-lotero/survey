package com.restaurant.survey.adapter.controller;


import com.restaurant.survey.adapter.controller.model.ErrorResponse;
import com.restaurant.survey.adapter.controller.model.SurveyResponse;
import com.restaurant.survey.application.port.in.GetSurveyById;
import com.restaurant.survey.domain.Survey;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1.0")
@Validated
@AllArgsConstructor
@Api
@Slf4j
public class SurveyController {

    private final GetSurveyById getSurveyById;

    @GetMapping("/surveys/{surveyId}")
    @ApiOperation(value = "Get Survey", response = SurveyResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = SurveyResponse.class),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found", response = ErrorResponse.class),
            @ApiResponse(code = 500, message = "Internal server error", response = ErrorResponse.class)
    })
    public SurveyResponse getSurvey(
            @ApiParam(required = true, example = "1") final @PathVariable Long surveyId

    ) {
        log.info("Survey request id {}", surveyId);

        Survey survey = getSurveyById.execute(surveyId);
        SurveyResponse response = SurveyResponse.fromDomain(survey);

        log.info("Survey response {}", response);
        return response;
    }

}
