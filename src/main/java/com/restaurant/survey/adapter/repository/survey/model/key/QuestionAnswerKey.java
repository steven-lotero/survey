package com.restaurant.survey.adapter.repository.survey.model.key;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class QuestionAnswerKey implements Serializable {

    @Column(name = "question_id")
    Long questionId;

    @Column(name = "answer_id")
    Long answerId;

}
