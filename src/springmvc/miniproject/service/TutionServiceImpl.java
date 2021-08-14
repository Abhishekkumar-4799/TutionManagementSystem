package springmvc.miniproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import springmvc.miniproject.DAO.CourseDAOImpl;
import springmvc.miniproject.DAO.InstructorImpl;
import springmvc.miniproject.controller.InstructorDetails;
import springmvc.miniproject.entity.Course;

@Service
public class TutionServiceImpl implements TutionService {
	
	@Autowired
	private InstructorImpl instructorImpl;
	
	@Autowired
	private CourseDAOImpl courseDAOImpl;

	@Override
	@Transactional
	public List<Object[]> getAllInstructorPersonaAndDigitalInfo() {
		return instructorImpl.getAllInstructorPersonaAndDigitalInfo();
		//return null;
	}
	
	@Override
	@Transactional
	public List<Course> getAllCourses() {
		// TODO Auto-generated method stub,ol-
		return courseDAOImpl.getAllCourses();
	}
	
	@Override
	@Transactional
	public boolean addInstructorDetail(InstructorDetails instructorDetails ) {
		System.out.println("22222222222");
		return instructorImpl.addInstructor(instructorDetails);
	}
	
	@Override
	@Transactional
	public boolean deleteInstructorDetail(int id ) {
		System.out.println("22222222222");
		return instructorImpl.deleteInstructor(id);
	}

	@Override
	@Transactional
	public InstructorDetails getInstructorPersonaAndDigitalInfoById(int id) {
		return instructorImpl.getInstructorPersonaAndDigitalInfoById(id);
	}

}
