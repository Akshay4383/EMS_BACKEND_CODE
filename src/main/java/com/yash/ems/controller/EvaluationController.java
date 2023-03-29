package com.yash.ems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yash.ems.model.Employee;
import com.yash.ems.model.Evaluation;
import com.yash.ems.service.EvaluationService;
import com.yash.ems.serviceimpl.EvaluationServiceImpl;

@CrossOrigin("*")
@RestController
@RequestMapping("/ems/evaluation")
public class EvaluationController {

	@Autowired
	private EvaluationServiceImpl eService;
	
	@PostMapping("/onboard-new-evaluation")
	public Evaluation add(@RequestBody Evaluation evl)
	{
		return eService.addEvatuationDetails(evl);
	}
	
	@GetMapping("/get-all-onboard-employees-evaluation-details")
	public List<Evaluation> getAllEvaluationDetals()
	{
		Employee e=new Employee();
		e.getEmployeeId();
		System.out.println("employeeId"+e.getEmployeeId());
		return eService.getAllEvaluation();
	}
	
	@PutMapping("/{evaluationId}/evaluation")
	public Evaluation updateEvalutionById(@PathVariable Integer evaluationId,@RequestBody Evaluation evaluation) {
		
		return eService.updateEvaluation(evaluationId, evaluation);
		
	}
	
	@GetMapping("/get-by-evaluation-id/{evaluationId}")
	public Evaluation getByEvaluationId(@PathVariable(value = "evaluationId") Integer evaluationId) {
		return eService.findByEvaluationId(evaluationId);
		
	}
}
