package com.restaurant.survey.domain;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ResponseAnswer {

    Long questionId;
    Long answerId;
    String text;

}
