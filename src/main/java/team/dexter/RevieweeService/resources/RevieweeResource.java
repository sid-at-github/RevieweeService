package team.dexter.RevieweeService.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import team.dexter.CodeReviewerCommons.dtos.RevieweeDto;
import team.dexter.CodeReviewerCommons.dtos.RevieweeRequestDto;
import team.dexter.RevieweeService.models.Reviewee;
import team.dexter.RevieweeService.services.RevieweeService;

@RestController
public class RevieweeResource {

	@Autowired
	private RevieweeService revieweeService;

	@PostMapping("/reviewee")
	@ResponseStatus(value = HttpStatus.CREATED)
	public void createReviewee(@RequestBody RevieweeDto revieweeDto) {
		revieweeService.createReviewee(revieweeDto);
	}

	@GetMapping("/reviewee")
	public List<Reviewee> getRevieweeList(RevieweeRequestDto revieweeRequestDto) {
		return revieweeService.getRevieweeList(revieweeRequestDto);
	}
}
