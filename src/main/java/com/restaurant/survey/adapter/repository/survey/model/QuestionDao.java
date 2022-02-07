package com.restaurant.survey.adapter.repository.survey.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.restaurant.survey.domain.Question;
import java.util.Set;
import java.util.stream.Collectors;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
@Table(name = "question_catalogue")
public class QuestionDao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Builder.Default
    private long id = 0L;

    @Column(name = "text")
    private String text;

    @OneToMany(mappedBy = "question")
    @JsonManagedReference
    private Set<QuestionAnswerDao> answers;

    public Question toDomain() {
        return Question.builder()
                .id(this.getId())
                .text(this.getText())
                .answers(this.getAnswers().stream()
                        .map(QuestionAnswerDao::toDomain)
                        .collect(Collectors.toSet()))
                .build();
    }
}
