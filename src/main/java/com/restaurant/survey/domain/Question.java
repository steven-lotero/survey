package com.restaurant.survey.domain;

import java.util.Set;
import lombok.Builder;
import lombok.Value;
import lombok.With;

@Value
@Builder
public class Question {

    long id;

    String text;

    @With
    int orderPosition;

    Set<Answer> answers;

}
