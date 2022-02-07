package com.restaurant.survey.application.usecase;

import com.restaurant.survey.application.port.in.SaveResponse;
import com.restaurant.survey.application.port.out.SurveyRepository;
import com.restaurant.survey.domain.Response;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class SaveResponseUseCase implements SaveResponse {

    private final SurveyRepository surveyRepository;

    @Override
    public void execute(Response response) {
        surveyRepository.save(response);
    }

}
