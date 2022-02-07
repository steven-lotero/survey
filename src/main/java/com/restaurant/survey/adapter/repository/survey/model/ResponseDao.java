package com.restaurant.survey.adapter.repository.survey.model;

import com.restaurant.survey.domain.ResponseAnswer;
import java.time.LocalDateTime;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "response")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDao {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Builder.Default
    private long id = 0L;

    @ManyToOne
    @JoinColumn(name = "survey_id")
    private SurveyDao survey;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private QuestionDao question;

    @ManyToOne
    @JoinColumn(name = "answer_id")
    private AnswerDao answer;

    String text;

    @Builder.Default
    LocalDateTime date = LocalDateTime.now();

    public static ResponseDao fromDomain(Long surveyId, ResponseAnswer answer) {
        return ResponseDao.builder()
                .survey(SurveyDao.builder()
                        .id(surveyId)
                        .build())
                .question(QuestionDao.builder()
                        .id(answer.getQuestionId())
                        .build())
                .answer(Objects.nonNull(answer.getAnswerId()) ?
                        AnswerDao.builder().id(answer.getAnswerId()).build() : null)
                .text(Objects.nonNull(answer.getText()) ? answer.getText() : null)
                .build();
    }

}
