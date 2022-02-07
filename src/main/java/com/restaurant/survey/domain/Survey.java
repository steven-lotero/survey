package com.restaurant.survey.domain;

import java.time.LocalDate;
import java.util.Set;
import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class Survey {

    long id;

    LocalDate dateCreated;

    Set<Question> questions;

}
