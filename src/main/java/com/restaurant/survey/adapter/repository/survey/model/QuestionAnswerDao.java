package com.restaurant.survey.adapter.repository.survey.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.restaurant.survey.adapter.repository.survey.model.key.QuestionAnswerKey;
import com.restaurant.survey.domain.Answer;
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
@Table(name = "question_answer")
public class QuestionAnswerDao {

    @EmbeddedId
    private QuestionAnswerKey id;

    @ManyToOne
    @MapsId("questionId")
    @JoinColumn(name = "question_id")
    @JsonBackReference
    private QuestionDao question;

    @ManyToOne
    @MapsId("answerId")
    @JoinColumn(name = "answer_id")
    @JsonBackReference
    private AnswerDao answer;

    @Column(name = "order_position")
    private int orderPosition;

    public Answer toDomain() {
        return this.getAnswer().toDomain().withOrderPosition(this.getOrderPosition());
    }

}
