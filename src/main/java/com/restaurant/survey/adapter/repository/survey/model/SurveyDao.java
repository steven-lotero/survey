package com.restaurant.survey.adapter.repository.survey.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.restaurant.survey.domain.Survey;
import java.time.LocalDate;
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


@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "survey")
public class SurveyDao {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Builder.Default
    private long id = 0L;

    @Column(name = "date_created")
    private LocalDate dateCreated;

    @OneToMany(mappedBy = "survey")
    @JsonManagedReference
    private Set<SurveyQuestionDao> questions;

    public Survey toDomain() {
        return Survey.builder()
                .id(this.getId())
                .dateCreated(this.getDateCreated())
                .questions(this.getQuestions().stream()
                        .map(SurveyQuestionDao::toDomain)
                        .collect(Collectors.toSet()))
                .build();
    }
}
