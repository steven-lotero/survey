package com.restaurant.survey.adapter.controller.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.restaurant.survey.domain.Question;
import io.swagger.annotations.ApiModel;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@ApiModel
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class QuestionResponse {

    long id;

    String text;

    @JsonProperty("order_position")
    int orderPosition;

    Set<AnswerResponse> answers;

    public static QuestionResponse fromDomain(Question question) {
        return QuestionResponse.builder()
                .id(question.getId())
                .text(question.getText())
                .orderPosition(question.getOrderPosition())
                .answers(question.getAnswers().stream()
                        .map(AnswerResponse::fromDomain)
                        .sorted(Comparator.comparingLong(AnswerResponse::getOrderPosition))
                        .collect(Collectors.toCollection(LinkedHashSet::new)))
                .build();
    }
}
