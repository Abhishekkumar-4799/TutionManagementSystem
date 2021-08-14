package springmvc.miniproject.service;

import java.util.List;

import springmvc.miniproject.controller.InstructorDetails;
import springmvc.miniproject.entity.Course;

public interface TutionService {
	public List<Object[]> getAllInstructorPersonaAndDigitalInfo();
	public List<Course> getAllCourses();
	public boolean addInstructorDetail(InstructorDetails instructorDetails);
	public boolean deleteInstructorDetail(int id);
	public InstructorDetails getInstructorPersonaAndDigitalInfoById(int id);
}
