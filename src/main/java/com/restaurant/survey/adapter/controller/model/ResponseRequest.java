package com.restaurant.survey.adapter.controller.model;

import com.restaurant.survey.domain.Response;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Value;


@Value
@Builder
@ApiModel
public class ResponseRequest {

    @Min(1)
    @ApiModelProperty(required = true, example = "1")
    long surveyId;

    @NotEmpty
    @Valid
    List<AnswerRequest> answers;

    public Response toDomain() {
        return Response.builder()
                .surveyId(this.getSurveyId())
                .answers(this.getAnswers().stream().map(AnswerRequest::toDomain).collect(Collectors.toList()))
                .build();
    }
}
