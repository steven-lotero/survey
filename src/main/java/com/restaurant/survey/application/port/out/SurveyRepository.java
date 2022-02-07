package com.restaurant.survey.application.port.out;

import com.restaurant.survey.domain.Response;
import com.restaurant.survey.domain.Survey;

public interface SurveyRepository {

    Survey findById(Long surveyId);

    void save(Response response);
}
