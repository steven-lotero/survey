package com.restaurant.survey.adapter.repository.survey;

import com.restaurant.survey.adapter.repository.exception.NotFoundRepositoryException;
import com.restaurant.survey.adapter.repository.survey.jpa.ResponseRepositoryJPA;
import com.restaurant.survey.adapter.repository.survey.jpa.SurveyRepositoryJPA;
import com.restaurant.survey.adapter.repository.survey.model.ResponseDao;
import com.restaurant.survey.application.port.out.SurveyRepository;
import com.restaurant.survey.config.ErrorMessage;
import com.restaurant.survey.domain.Response;
import com.restaurant.survey.domain.Survey;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@AllArgsConstructor
public class SurveyRepositoryDB implements SurveyRepository {

    private final SurveyRepositoryJPA surveyRepositoryJPA;
    private final ResponseRepositoryJPA responseRepositoryJPA;

    @Override
    public Survey findById(Long surveyId) {
        return surveyRepositoryJPA.findById(surveyId)
                .orElseThrow(() -> new NotFoundRepositoryException(ErrorMessage.SURVEY_NOT_FOUND))
                .toDomain();
    }

    @Override
    public void save(Response response) {
        response.getAnswers()
                .forEach(answer -> responseRepositoryJPA.save(ResponseDao.fromDomain(response.getSurveyId(), answer)));

        log.info("Save successfully");
    }
}
