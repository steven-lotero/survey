package com.restaurant.survey.adapter.repository.survey.jpa;

import com.restaurant.survey.adapter.repository.survey.model.ResponseDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResponseRepositoryJPA extends JpaRepository<ResponseDao, Long> {

}
