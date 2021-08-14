package springmvc.miniproject.DAO;

import java.util.List;

import springmvc.miniproject.entity.Review;

public interface ReviewDAO {
	public List<Review> getReviewForACourse(int courseId);
}
