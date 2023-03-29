package com.yash.ems.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yash.ems.model.Rating;
import com.yash.ems.service.RatingService;

@CrossOrigin("*")
@RestController
@RequestMapping("/ems/rating")
public class RatingController {
	
	@Autowired
	private RatingService ratingService;
	
	
	@PostMapping("/save-rating")
	public ResponseEntity<Rating> saveEmpoyee( @Valid @RequestBody Rating rating) {
		Rating addRating = this.ratingService.addRating(rating);
		return new ResponseEntity<Rating>(addRating,HttpStatus.CREATED);
	}

	@GetMapping("/get-all-rating")
	public ResponseEntity<List<Rating>> getAll() {
		List<Rating> ratings = this.ratingService.getAllRating();
		return  ResponseEntity.ok(ratings);
	}

}
