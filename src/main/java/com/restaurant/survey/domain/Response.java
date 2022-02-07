package com.restaurant.survey.domain;

import java.util.List;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Response {

    long surveyId;

    List<ResponseAnswer> answers;
}
