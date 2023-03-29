package com.yash.ems.repo;


import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.yash.ems.model.Evaluation;
@Repository
public interface EvaluationRepo extends JpaRepository<Evaluation, Integer> {

}
