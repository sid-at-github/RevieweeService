package team.dexter.RevieweeService.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import team.dexter.CodeReviewerCommons.dtos.RevieweeDto;
import team.dexter.CodeReviewerCommons.dtos.RevieweeRequestDto;
import team.dexter.RevieweeService.daos.RevieweeDao;
import team.dexter.RevieweeService.models.Reviewee;

@Service
public class RevieweeService {

	@Autowired
	private RevieweeDao revieweeDao;

	@Autowired
	private ObjectMapper objectMapper;

	public Boolean createReviewee(RevieweeDto revieweeDto) {
		Reviewee reviewee = objectMapper.convertValue(revieweeDto, Reviewee.class);
		try {
			revieweeDao.save(reviewee);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public List<Reviewee> getReviewee(RevieweeRequestDto revieweeRequestDto) {
		List<Reviewee> revieweeByUsername = new ArrayList<>();
		try {
			revieweeByUsername = revieweeDao.findByUsername(revieweeRequestDto.getUsername());
		} catch (Exception e) {

		}
		return revieweeByUsername;
	}
}
