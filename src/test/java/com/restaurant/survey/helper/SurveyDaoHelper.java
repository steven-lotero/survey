package com.restaurant.survey.helper;

import com.restaurant.survey.adapter.repository.survey.model.AnswerDao;
import com.restaurant.survey.adapter.repository.survey.model.QuestionAnswerDao;
import com.restaurant.survey.adapter.repository.survey.model.QuestionDao;
import com.restaurant.survey.adapter.repository.survey.model.SurveyDao;
import com.restaurant.survey.adapter.repository.survey.model.SurveyQuestionDao;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Set;

public class SurveyDaoHelper {

    public static SurveyDao aSurveyDao() {
        return SurveyDao.builder()
                .id(1L)
                .dateCreated(LocalDate.now())
                .questions(Set.of(
                        SurveyQuestionDao.builder()
                                .orderPosition(2)
                                .question(
                                        QuestionDao.builder()
                                                .id(1L)
                                                .text("¿Cómo estás?")
                                                .answers(Collections.emptySet())
                                                .build())
                                .build(),
                        SurveyQuestionDao.builder()
                                .orderPosition(1)
                                .question(
                                        QuestionDao.builder()
                                                .id(3L)
                                                .text("¿Qué tanto nos quieres?")
                                                .answers(aSetQuestionAnswerDao())
                                                .build())
                                .build()
                ))
                .build();
    }

    public static Set<QuestionAnswerDao> aSetQuestionAnswerDao() {
        return Set.of(
                QuestionAnswerDao.builder()
                        .orderPosition(3)
                        .answer(AnswerDao.builder()
                                .id(1L)
                                .text("1")
                                .build())
                        .build(),
                QuestionAnswerDao.builder()
                        .orderPosition(2)
                        .answer(AnswerDao.builder()
                                .id(6L)
                                .text("Poco")
                                .build())
                        .build(),
                QuestionAnswerDao.builder()
                        .orderPosition(1)
                        .answer(AnswerDao.builder()
                                .id(2L)
                                .text("3")
                                .build())
                        .build(),
                QuestionAnswerDao.builder()
                        .orderPosition(4)
                        .answer(AnswerDao.builder()
                                .id(14L)
                                .text("Mucho")
                                .build())
                        .build()
        );
    }

}
