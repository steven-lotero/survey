package com.restaurant.survey.application.usecase;

import com.restaurant.survey.application.port.in.GetSurveyById;
import com.restaurant.survey.application.port.out.SurveyRepository;
import com.restaurant.survey.domain.Survey;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class GetSurveyByIdUseCase implements GetSurveyById {

    private final SurveyRepository surveyRepository;

    @Override
    public Survey execute(long surveyId) {
        return surveyRepository.findById(surveyId);
    }
}
