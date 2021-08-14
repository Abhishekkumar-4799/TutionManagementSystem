package springmvc.miniproject.DAO;

import java.util.List;

import org.springframework.stereotype.Service;

import springmvc.miniproject.controller.InstructorDetails;
import springmvc.miniproject.entity.InstructorDigitalInfo;
import springmvc.miniproject.entity.InstructorPersonalInfo;

public interface Instructor {

	public List<Object[]> getAllInstructorPersonaAndDigitalInfo();
	public boolean addInstructor(InstructorDetails instructorDetails);
	public boolean deleteInstructor(int id);
//	public InstructorPersonalInfo getInstructorById();
//	public boolean addInstructor();
//	public boolean removeInstructorById();
//	public boolean updateInstructorById();
//	public boolean updateAllInstructor();
//	public List<InstructorPersonalInfo> searchInstructorByName();
//	public instructorDigitalInfo getInstructorDigitalInfoById();
//	public instructorDigitalInfo searchInstructorByEmail();
	public InstructorDetails getInstructorPersonaAndDigitalInfoById(int id);
}
