package com.restaurant.survey.adapter.repository.survey.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.restaurant.survey.adapter.repository.survey.model.key.SurveyQuestionKey;
import com.restaurant.survey.domain.Question;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "survey_question")
public class SurveyQuestionDao {

    @EmbeddedId
    private SurveyQuestionKey id;

    @ManyToOne
    @MapsId("surveyId")
    @JoinColumn(name = "survey_id")
    @JsonBackReference
    private SurveyDao survey;

    @ManyToOne
    @MapsId("questionId")
    @JoinColumn(name = "question_id")
    @JsonBackReference
    private QuestionDao question;

    @Column(name = "order_position")
    private int orderPosition;

    public Question toDomain() {
        return this.getQuestion().toDomain().withOrderPosition(this.getOrderPosition());
    }

}
