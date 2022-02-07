package com.restaurant.survey.adapter.repository.survey;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.restaurant.survey.adapter.repository.exception.NotFoundRepositoryException;
import com.restaurant.survey.adapter.repository.survey.jpa.ResponseRepositoryJPA;
import com.restaurant.survey.adapter.repository.survey.jpa.SurveyRepositoryJPA;
import com.restaurant.survey.adapter.repository.survey.model.ResponseDao;
import com.restaurant.survey.domain.Response;
import com.restaurant.survey.domain.ResponseAnswer;
import com.restaurant.survey.helper.SurveyDaoHelper;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.dao.DataIntegrityViolationException;

@ExtendWith(MockitoExtension.class)
class SurveyRepositoryDBTest {

    @Mock
    private SurveyRepositoryJPA surveyRepositoryJPA;

    @Mock
    private ResponseRepositoryJPA responseRepositoryJPA;

    @InjectMocks
    private SurveyRepositoryDB surveyRepositoryDB;

    @Test
    @DisplayName("When findSurveyById must return survey")
    void whenFindById_mustSurvey() {
        var surveyMock = SurveyDaoHelper.aSurveyDao();
        when(surveyRepositoryJPA.findById(surveyMock.getId())).thenReturn(Optional.of(surveyMock));
        var response = surveyRepositoryDB.findById(surveyMock.getId());
        assertEquals(surveyMock.getId(), response.getId());
        assertEquals(2, response.getQuestions().size());
    }

    @Test
    @DisplayName("When findSurveyById not found a survey must throw a Not Found Exception")
    void whenFindByIdNotFound_mustThrowNotFound() {
        when(surveyRepositoryJPA.findById(anyLong())).thenReturn(Optional.empty());
        assertThrows(NotFoundRepositoryException.class, () ->
                surveyRepositoryDB.findById(1L));
    }

    @Test
    @DisplayName("When save ok")
    void whenSaveOK() {
        var responseMock = Response.builder()
                .surveyId(1L)
                .answers(List.of(
                        ResponseAnswer.builder()
                                .questionId(1L)
                                .text("Hi")
                                .build(),
                        ResponseAnswer.builder()
                                .questionId(2L)
                                .answerId(1L)
                                .build()
                ))
                .build();
        when(responseRepositoryJPA.save(any(ResponseDao.class))).thenReturn(ResponseDao.builder().build());
        surveyRepositoryDB.save(responseMock);
        verify(responseRepositoryJPA, atLeastOnce()).save(any(ResponseDao.class));
    }

    @Test
    @DisplayName("When save throw DataIntegrityViolationException")
    void whenSaveThrowsException() {
        var responseMock = Response.builder()
                .surveyId(1L)
                .answers(List.of(
                        ResponseAnswer.builder()
                                .questionId(1L)
                                .text("Hi")
                                .build(),
                        ResponseAnswer.builder()
                                .questionId(2L)
                                .answerId(1L)
                                .build()
                ))
                .build();
        when(responseRepositoryJPA.save(any(ResponseDao.class))).thenThrow(
                new DataIntegrityViolationException("error"));
        assertThrows(DataIntegrityViolationException.class, () ->
                surveyRepositoryDB.save(responseMock));
    }

}
