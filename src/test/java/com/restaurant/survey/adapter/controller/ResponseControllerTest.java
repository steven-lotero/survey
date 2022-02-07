package com.restaurant.survey.adapter.controller;

import static java.nio.charset.StandardCharsets.UTF_8;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.restaurant.survey.adapter.controller.model.AnswerRequest;
import com.restaurant.survey.adapter.controller.model.ResponseRequest;
import com.restaurant.survey.application.port.in.SaveResponse;
import com.restaurant.survey.domain.Response;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(controllers = ResponseController.class)
class ResponseControllerTest {

    private final ObjectMapper objectMapper = new ObjectMapper();
    @Autowired
    private MockMvc mvc;
    @MockBean
    private SaveResponse saveResponse;

    @Test
    @DisplayName("When saveResponse is invoked with validBody must return Status created ")
    void whenSaveResponseIsInvokedWithValidBody_mustReturnStatusCreated() throws Exception {
        var responseMock = ResponseRequest.builder()
                .surveyId(1L)
                .answers(List.of(
                        AnswerRequest.builder()
                                .questionId(1L)
                                .text("Hi")
                                .build(),
                        AnswerRequest.builder()
                                .questionId(2L)
                                .answerId(1L)
                                .build()
                ))
                .build();
        doNothing().when(saveResponse).execute(isA(Response.class));
        mvc
                .perform(
                        post("/api/v1.0/responses")
                                .accept(APPLICATION_JSON)
                                .contentType(APPLICATION_JSON)
                                .characterEncoding(UTF_8)
                                .content(objectMapper
                                        .writeValueAsString(responseMock)))
                .andDo(print())
                .andExpect(status().isCreated());
    }

    @Test
    @DisplayName("When saveResponse is invoked with invalid text must return Status bad request ")
    void whenSaveResponseIsInvokedWithInvalidText_mustReturnBadRequest() throws Exception {
        var responseMock = ResponseRequest.builder()
                .surveyId(1L)
                .answers(List.of(
                        AnswerRequest.builder()
                                .questionId(1L)
                                .text("Hi<<")
                                .build(),
                        AnswerRequest.builder()
                                .questionId(2L)
                                .answerId(1L)
                                .build()
                ))
                .build();

        mvc
                .perform(
                        post("/api/v1.0/responses")
                                .accept(APPLICATION_JSON)
                                .contentType(APPLICATION_JSON)
                                .characterEncoding(UTF_8)
                                .content(objectMapper
                                        .writeValueAsString(responseMock)))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("When saveResponse is invoked with empty answer list must return Status bad request ")
    void whenSaveResponseIsInvokedWithEmptyList_mustReturnBadRequest() throws Exception {
        var responseMock = ResponseRequest.builder()
                .surveyId(1L)
                .answers(Collections.emptyList())
                .build();

        mvc
                .perform(
                        post("/api/v1.0/responses")
                                .accept(APPLICATION_JSON)
                                .contentType(APPLICATION_JSON)
                                .characterEncoding(UTF_8)
                                .content(objectMapper
                                        .writeValueAsString(responseMock)))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }
}
