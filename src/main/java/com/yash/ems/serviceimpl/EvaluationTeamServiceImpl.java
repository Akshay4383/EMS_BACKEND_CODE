package com.yash.ems.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.ems.model.EvaluationTeam;
import com.yash.ems.repo.EvaluationTeamRepository;
import com.yash.ems.service.EvaluationTeamService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class EvaluationTeamServiceImpl  implements EvaluationTeamService{
      @Autowired
      private EvaluationTeamRepository evaluationTeamRepository;
      
      private static final Logger LOGGER = LoggerFactory.getLogger(EvaluationTeamServiceImpl.class);
	
	
	@Override
	public EvaluationTeam addEvatuationTeam(EvaluationTeam eva) {
	
		return evaluationTeamRepository.save(eva);
	}

	@Override
	public List<EvaluationTeam> getAllEvaluationTeams() {
		
		return evaluationTeamRepository.findAll();
	}

	@Override
	public void deleteEvalutionTeam(Integer evaluationId) {
	   evaluationTeamRepository.deleteById(evaluationId);
		
	}

	@Override
	public EvaluationTeam findByEvaluationId(Integer evId) {
	
		return evaluationTeamRepository.findById(evId).get();
	}

	@Override
	public EvaluationTeam updateEvaluation(Integer evaluationId, EvaluationTeam evaluation) {
		Optional<EvaluationTeam> byId = evaluationTeamRepository.findById(evaluationId);
		
		if(byId.isPresent()) {
			EvaluationTeam eo=byId.get();
			eo.setName(evaluation.getName());
			eo.setDesignation(evaluation.getDesignation());
			evaluationTeamRepository.save(evaluation);
		} else {
			System.out.println("EvaluationTeam not available");
		}
		System.out.println("EvaluationTeam Updating Successfully ");
		return evaluation;
	}

}
