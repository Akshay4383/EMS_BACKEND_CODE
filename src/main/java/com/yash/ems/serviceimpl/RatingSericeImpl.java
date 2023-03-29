package com.yash.ems.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.ems.model.Rating;
import com.yash.ems.repo.RatingRepo;
import com.yash.ems.service.RatingService;

@Service
public class RatingSericeImpl  implements RatingService{

	@Autowired
	private RatingRepo ratingRepo;
	@Override
	public Rating addRating(Rating rating) {
		// TODO Auto-generated method stub
		return ratingRepo.save(rating);
	}

	@Override
	public List<Rating> getAllRating() {
		// TODO Auto-generated method stub
		return ratingRepo.findAll();
	}

	@Override
	public void deleteRating(Integer ratingId) {
		Rating rating = ratingRepo.findById(ratingId).get();
		ratingRepo.delete(rating);
		
		
	}

	@Override
	public Rating updateRating(Integer ratingId, Rating rating) {
		Optional<Rating> find = ratingRepo.findById(ratingId);
		if(find.isPresent()) {
			Rating r=find.get();
			r.setRatingDesc(rating.getRatingDesc());
			r.setRatingBriefDesc(rating.getRatingBriefDesc());

			ratingRepo.save(rating);
		} else {
			System.out.println("rating not available");
		}
		System.out.println("rating Updating Successfully ");
		return rating;
	}

	@Override
	public Optional<Rating> getRatingById(Integer ratingId) {
		// TODO Auto-generated method stub
		Optional<Rating> findById = ratingRepo.findById(ratingId);
		return findById;
	}

}
