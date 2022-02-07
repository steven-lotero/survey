package com.restaurant.survey.adapter.controller;

import static java.nio.charset.StandardCharsets.UTF_8;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.restaurant.survey.application.port.in.GetSurveyById;
import com.restaurant.survey.helper.SurveyHelper;
import java.time.LocalDate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(controllers = SurveyController.class)
class SurveyControllerTest {

    @Autowired
    private MockMvc mvc;
    @MockBean
    private GetSurveyById getSurveyById;

    @Test
    @DisplayName("When getSurvey is invoked with survey id must return Status Ok and a Survey")
    void whenGetSurveyIsInvokedWithSurveyId_mustReturnOkStatusOk() throws Exception {
        var surveyMock = SurveyHelper.aSurvey();
        long surveyId = surveyMock.getId();
        when(getSurveyById.execute(surveyId)).thenReturn(surveyMock);
        mvc
                .perform(
                        get("/api/v1.0/surveys/" + surveyId)
                                .accept(APPLICATION_JSON)
                                .contentType(APPLICATION_JSON)
                                .characterEncoding(UTF_8))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(surveyId))
                .andExpect(jsonPath("$.date_created").value(LocalDate.now().toString()))
                .andExpect(jsonPath("$.questions[0].order_position").value(1))
                .andExpect(jsonPath("$.questions[1].answers[0].order_position").value(1));
    }

}
