package com.yash.ems.service;

import java.util.List;


import com.yash.ems.model.EvaluationTeam;

public interface EvaluationTeamService {

	public EvaluationTeam addEvatuationTeam(EvaluationTeam eva);
	public List<EvaluationTeam> getAllEvaluationTeams();
	void deleteEvalutionTeam(Integer evaluationId);
	public EvaluationTeam findByEvaluationId(Integer evId );
	public EvaluationTeam updateEvaluation(Integer evaluationId,EvaluationTeam evaluation);
}
