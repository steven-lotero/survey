package com.restaurant.survey.adapter.repository.survey.model;

import com.restaurant.survey.domain.Answer;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Table(name = "answer_catalogue")
public class AnswerDao {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Builder.Default
    private long id = 0L;

    @Column(name = "text")
    private String text;

    public Answer toDomain() {
        return Answer.builder()
                .id(this.getId())
                .text(this.getText())
                .build();
    }
}
