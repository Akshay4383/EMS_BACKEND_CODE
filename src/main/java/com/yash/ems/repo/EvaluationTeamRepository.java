package com.yash.ems.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yash.ems.model.EvaluationTeam;

@Repository
public interface EvaluationTeamRepository extends JpaRepository<EvaluationTeam, Integer> {

}
