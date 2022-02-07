package com.restaurant.survey.adapter.controller.model;

import com.restaurant.survey.domain.ResponseAnswer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@ApiModel
public class AnswerRequest {

    @Min(1)
    @ApiModelProperty(required = true, example = "1")
    Long questionId;

    @ApiModelProperty(example = "1")
    Long answerId;

    @ApiModelProperty(example = "Love it!")
    @Pattern(regexp = "^[A-Za-zÀ-ÖØ-öø-ÿ¡!]+[A-Za-zÀ-ÖØ-öø-ÿ. ,!¡]{1,500}$")
    String text;

    public ResponseAnswer toDomain() {
        return ResponseAnswer.builder()
                .questionId(this.getQuestionId())
                .answerId(this.getAnswerId())
                .text(this.getText())
                .build();

    }
}
