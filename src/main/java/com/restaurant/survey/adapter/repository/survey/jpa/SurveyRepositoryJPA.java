package com.restaurant.survey.adapter.repository.survey.jpa;

import com.restaurant.survey.adapter.repository.survey.model.SurveyDao;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SurveyRepositoryJPA extends JpaRepository<SurveyDao, Long> {

    @Override
    Optional<SurveyDao> findById(Long id);
}
