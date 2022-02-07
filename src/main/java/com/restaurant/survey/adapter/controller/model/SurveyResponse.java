package com.restaurant.survey.adapter.controller.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.restaurant.survey.domain.Survey;
import io.swagger.annotations.ApiModel;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.Builder;
import lombok.Value;

@Builder
@ApiModel
@Value
public class SurveyResponse {

    long id;

    @JsonProperty("date_created")
    LocalDate dateCreated;

    Set<QuestionResponse> questions;

    public static SurveyResponse fromDomain(Survey survey) {
        return SurveyResponse.builder()
                .id(survey.getId())
                .dateCreated(survey.getDateCreated())
                .questions(survey.getQuestions().stream()
                        .map(QuestionResponse::fromDomain)
                        .sorted(Comparator.comparingInt(QuestionResponse::getOrderPosition))
                        .collect(Collectors.toCollection(LinkedHashSet::new)))
                .build();
    }

}
