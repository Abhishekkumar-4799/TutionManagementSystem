package springmvc.miniproject.DAO;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import springmvc.miniproject.entity.InstructorDigitalInfo;
import springmvc.miniproject.entity.InstructorPersonalInfo;
//import springmvc.miniproject.entity.instructorDigitalInfo;
import springmvc.miniproject.DAO.Instructor;
import springmvc.miniproject.controller.InstructorDetails;

@Repository
public class InstructorImpl implements Instructor {
	
	//inject Sessionfactory
	@Autowired
	private SessionFactory factory;
	
	@Override
	public List<Object[]> getAllInstructorPersonaAndDigitalInfo() {
		// get current session
		Session session = factory.getCurrentSession();
		//create a query 
		Query<Object[]> query = session.createQuery(" select d.email " +
													" , d.linkedIn " +
													" , d.instaProfile " +
													" , d.instructorPersonalInfo " +
													" , d.id " 
													+ " from InstructorDigitalInfo d " , Object[].class); 
		// get list of instructor
		List<Object[]> instructors = query.getResultList();
		
		return instructors;
	}
	
	@Override
	public InstructorDetails getInstructorPersonaAndDigitalInfoById(int id){
		Session session = factory.getCurrentSession();
		InstructorDigitalInfo instructorDigitalInfo = session.get(InstructorDigitalInfo.class,id);
		InstructorDetails instructorDetails = new InstructorDetails();
		instructorDetails.setInstructorDigitalInfo(instructorDigitalInfo);
		instructorDetails.setInstructorPersonalInfo(instructorDigitalInfo.getInstructorPersonalInfo());
		return instructorDetails;
	}

	@Override
	public boolean addInstructor(InstructorDetails instructorDetails) {
		Session session = factory.getCurrentSession();
		try {
			System.out.println("Saving data..." + instructorDetails);
			
			InstructorPersonalInfo instructorPersonalInfo = new InstructorPersonalInfo();
			InstructorDigitalInfo instructorDigitalInfo = new InstructorDigitalInfo();
			
			instructorDigitalInfo = instructorDetails.getInstructorDigitalInfo();
			instructorPersonalInfo = instructorDetails.getInstructorPersonalInfo();
			System.out.println("InstructordigitalId:" + instructorDigitalInfo.getId());
			System.out.println("InstructorPersonalId:" + instructorPersonalInfo.getId());
			instructorDigitalInfo.setInstructorPersonalInfo(instructorPersonalInfo);
			//session.saveOrUpdate(instructorPersonalInfo);
			session.saveOrUpdate(instructorDigitalInfo);
			System.out.println("3333333333333");
			return true;
		} catch (Exception e) {
			System.out.println("Error" + e);
			return false;
		}	
	}

	@Override
	public boolean deleteInstructor(int id) {
		Session session = factory.getCurrentSession();
		try {
			InstructorDigitalInfo digitalInfo = session.get(InstructorDigitalInfo.class, id);
			session.delete(digitalInfo);
		} catch (Exception e) {
			System.out.println("Error" + e);
		}
		return false;
	}
}
