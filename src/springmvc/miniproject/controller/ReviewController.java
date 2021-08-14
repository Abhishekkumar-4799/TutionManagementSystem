package springmvc.miniproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class ReviewController {
	public String getReviewsForACourse(int courseId) {
		return "list-review";
	}
}
