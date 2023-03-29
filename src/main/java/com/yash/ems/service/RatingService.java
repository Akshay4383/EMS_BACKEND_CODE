package com.yash.ems.service;

import java.util.List;
import java.util.Optional;

import com.yash.ems.model.Rating;

public interface RatingService {

      public Rating addRating(Rating rating);
	
 	public List<Rating> getAllRating();
	
	void deleteRating(Integer ratingId);
	
	public Rating updateRating(Integer ratingId,Rating rating);

	
	public Optional<Rating> getRatingById(Integer ratingId);
}
