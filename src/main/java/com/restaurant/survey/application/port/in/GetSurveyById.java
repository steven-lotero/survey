package com.restaurant.survey.application.port.in;

import com.restaurant.survey.domain.Survey;

public interface GetSurveyById {

    Survey execute(long surveyId);
}
