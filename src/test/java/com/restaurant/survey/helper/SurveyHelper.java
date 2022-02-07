package com.restaurant.survey.helper;

import com.restaurant.survey.domain.Answer;
import com.restaurant.survey.domain.Question;
import com.restaurant.survey.domain.Survey;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Set;

public class SurveyHelper {

    public static Survey aSurvey() {
        return Survey.builder()
                .id(1L)
                .dateCreated(LocalDate.now())
                .questions(Set.of(
                        Question.builder()
                                .id(1L)
                                .orderPosition(1)
                                .text("¿Cómo estás?")
                                .answers(Collections.emptySet())
                                .build(),
                        Question.builder()
                                .id(3L)
                                .orderPosition(2)
                                .text("¿Qué tanto nos quieres?")
                                .answers(Set.of(
                                        Answer.builder()
                                                .id(1L)
                                                .orderPosition(1)
                                                .text("1")
                                                .build(),
                                        Answer.builder()
                                                .id(6L)
                                                .orderPosition(2)
                                                .text("Poco")
                                                .build(),
                                        Answer.builder()
                                                .id(2L)
                                                .orderPosition(3)
                                                .text("3")
                                                .build(),
                                        Answer.builder()
                                                .id(14L)
                                                .orderPosition(4)
                                                .text("Mucho")
                                                .build()
                                ))
                                .build()

                ))
                .build();
    }
}
