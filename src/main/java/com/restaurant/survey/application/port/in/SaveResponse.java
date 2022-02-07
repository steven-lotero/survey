package com.restaurant.survey.application.port.in;

import com.restaurant.survey.domain.Response;

public interface SaveResponse {

    void execute(Response response);

}
