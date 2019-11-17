package team.dexter.RevieweeService.services;

import java.util.ArrayList;
import java.util.List;

import javax.xml.ws.http.HTTPException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import team.dexter.CodeReviewerCommons.dtos.RevieweeDto;
import team.dexter.CodeReviewerCommons.dtos.RevieweeRequestDto;
import team.dexter.RevieweeService.daos.RevieweeDao;
import team.dexter.RevieweeService.exceptions.ResourceExistException;
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
			throw new HTTPException(HttpStatus.INTERNAL_SERVER_ERROR.value());
		}
	}

	public List<Reviewee> getReviewee(RevieweeRequestDto revieweeRequestDto) {
		List<Reviewee> revieweeByUsername = new ArrayList<>();
		try {
			revieweeByUsername = revieweeDao.findByUsernameAndPassword(revieweeRequestDto.getUsername(),
					revieweeRequestDto.getPassword());
		} catch (Exception e) {

		}
		return revieweeByUsername;
	}
}
