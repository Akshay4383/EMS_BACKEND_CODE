package com.yash.ems.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.ems.model.Evaluation;
import com.yash.ems.repo.EvaluationRepo;
import com.yash.ems.service.EvaluationService;

@Service
public class EvaluationServiceImpl implements EvaluationService {

	@Autowired
	private EvaluationRepo evaluationRepo;
	
	@Override
	public Evaluation addEvatuationDetails(Evaluation eva) {
		
		return evaluationRepo.save(eva);
	}

	@Override
	public List<Evaluation> getAllEvaluation() {
				return evaluationRepo.findAll();
	}

	@Override
	public void deleteEmployee(Integer evaluationId) {
		evaluationRepo.deleteById(evaluationId);
	}

	@Override
	public Evaluation findByEvaluationId(Integer evaluationId) {

		return evaluationRepo.findById(evaluationId).get();
	}

	@Override
	public Evaluation updateEvaluation(Integer evaluationId, Evaluation evaluation) {
		Optional<Evaluation> evalu = evaluationRepo.findById(evaluationId);
		
		if (evalu.isPresent()) 
		{
			Evaluation eo =evalu.get();
			eo.setEvaluationId(evaluation.getEvaluationId());
			eo.setEvaluationDate(evaluation.getEvaluationDate());
			eo.setCoreJava(evaluation.getCoreJava());
			eo.setAngular(evaluation.getAngular());
			eo.setAws(evaluation.getAws());
			eo.setMySQL(evaluation.getMySQL());
			eo.setSpringBoot(evaluation.getSpringBoot());
			eo.setReact(evaluation.getReact());
			eo.setOverallRating(evaluation.getOverallRating());
			eo.setOverallComment(evaluation.getOverallComment());
			

			evaluationRepo.save(evaluation);
		} else {
			System.out.println("Employee not available");
		}
		System.out.println("Employee Updating Successfully ");
		
		return evaluation;
	}

	

}
