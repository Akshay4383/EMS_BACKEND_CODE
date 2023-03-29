package com.yash.ems.service;

import java.util.List;

import com.yash.ems.model.Evaluation;

public interface EvaluationService {
	public Evaluation addEvatuationDetails(Evaluation eva);
	public List<Evaluation> getAllEvaluation();
	void deleteEmployee(Integer evaluationId);
	public Evaluation findByEvaluationId(Integer evaluationId );
	public Evaluation updateEvaluation(Integer evaluationId,Evaluation evaluation);

}
