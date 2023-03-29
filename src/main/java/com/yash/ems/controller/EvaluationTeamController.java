package com.yash.ems.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yash.ems.model.Employee;
import com.yash.ems.model.EvaluationTeam;
import com.yash.ems.repo.EvaluationTeamRepository;
import com.yash.ems.service.EvaluationTeamService;

@CrossOrigin("*")
@RestController
@RequestMapping("/ems/ev")
public class EvaluationTeamController {
	
	@Autowired
	private EvaluationTeamService evService;
	
	@PostMapping("/save")
	public ResponseEntity<EvaluationTeam> saveEvaluationTeam(@Valid @RequestBody EvaluationTeam evaluationTeam) {
		EvaluationTeam addEvatuationTeam = this.evService.addEvatuationTeam(evaluationTeam);
		return new ResponseEntity<>(addEvatuationTeam,HttpStatus.CREATED);
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<EvaluationTeam>> getAll() {
		 List<EvaluationTeam> teams = this.evService.getAllEvaluationTeams();
		return  ResponseEntity.ok(teams);
	}


	
	 
	@DeleteMapping("/delete/{evId}")
	public ResponseEntity<EvaluationTeam> deleteCategory(@PathVariable Integer evId) {
		evService.deleteEvalutionTeam(evId);

		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("/get-team/{evId}")
	public ResponseEntity<EvaluationTeam> getEvalutionTeamDetailsById(@PathVariable(value = "evId") Integer evId){
       EvaluationTeam findByEvaluationId = evService.findByEvaluationId(evId);
        System.out.println("employee"+findByEvaluationId);
        System.out.println(findByEvaluationId);
        return ResponseEntity.ok().body(findByEvaluationId);
        

	}
	
}
