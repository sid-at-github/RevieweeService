package team.dexter.RevieweeService.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RevieweeResource {

	@GetMapping("/reviewee")
	public String createReviewee() {
		return "hello";
	}

}
