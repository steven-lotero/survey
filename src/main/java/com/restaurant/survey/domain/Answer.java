package com.restaurant.survey.domain;

import lombok.Builder;
import lombok.Value;
import lombok.With;


@Value
@Builder
public class Answer {

    long id;

    String text;

    @With
    int orderPosition;

}
