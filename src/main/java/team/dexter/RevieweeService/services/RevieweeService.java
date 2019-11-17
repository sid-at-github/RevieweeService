package team.dexter.RevieweeService.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import team.dexter.CodeReviewerCommons.dtos.RevieweeDto;
import team.dexter.CodeReviewerCommons.dtos.RevieweeRequestDto;
import team.dexter.RevieweeService.daos.RevieweeDao;
import team.dexter.RevieweeService.exceptions.InternalServerError;
import team.dexter.RevieweeService.exceptions.ResourceExistException;
import team.dexter.RevieweeService.exceptions.ResourceNotFoundException;
import team.dexter.RevieweeService.models.Reviewee;

@Service
public class RevieweeService {

	@Autowired
	private RevieweeDao revieweeDao;

	@Autowired
	private ObjectMapper objectMapper;

	public void createReviewee(RevieweeDto revieweeDto) {
		Reviewee reviewee = objectMapper.convertValue(revieweeDto, Reviewee.class);
		try {
			revieweeDao.save(reviewee);
		} catch (DataIntegrityViolationException e) {
			throw new ResourceExistException();
		} catch (Exception e) {
			throw new InternalServerError();
		}
	}

	public List<Reviewee> getRevieweeList(RevieweeRequestDto revieweeRequestDto) {
		List<Reviewee> revieweeByUsernameAndPassword = new ArrayList<>();
		try {
			revieweeByUsernameAndPassword = revieweeDao.findByUsernameAndPassword(revieweeRequestDto.getUsername(),
					revieweeRequestDto.getPassword());
			if (revieweeByUsernameAndPassword.isEmpty()) {
				throw new ResourceNotFoundException();
			}
		} catch (Exception e) {
			throw new InternalServerError();
		}
		return revieweeByUsernameAndPassword;
	}
}
