package springmvc.miniproject.DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import springmvc.miniproject.entity.Course;
import springmvc.miniproject.entity.InstructorPersonalInfo;
import springmvc.miniproject.entity.Review;
import springmvc.miniproject.DAO.Instructor;
import springmvc.miniproject.controller.InstructorDetails;

@Repository
public class CourseDAOImpl implements CourseDAO,ReviewDAO {
	
	@Autowired
	private SessionFactory factory;
	
	@Override
	public List<Course> getAllCourses() {
		System.out.println("getAllCourses");
		//get current session
		Session session = factory.getCurrentSession();
		//create query
		Query<Course> query = session.createQuery("from Course", Course.class);
		//execute query
		List<Course> course = query.getResultList();
		if (course == null) {
			System.out.println("null returned from query");
		} else {System.out.println(course);}
		return course;
	}

	@Override
	public List<Review> getReviewForACourse(int courseId) {
		// TODO Auto-generated method stub
		return null;
	}

}
