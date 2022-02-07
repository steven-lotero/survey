package com.restaurant.survey.adapter.controller.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.restaurant.survey.domain.Answer;
import io.swagger.annotations.ApiModel;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@ApiModel
public class AnswerResponse {

    long id;

    String text;

    @JsonProperty("order_position")
    int orderPosition;

    public static AnswerResponse fromDomain(Answer answer) {
        return AnswerResponse.builder()
                .id(answer.getId())
                .text(answer.getText())
                .orderPosition(answer.getOrderPosition())
                .build();
    }

}
