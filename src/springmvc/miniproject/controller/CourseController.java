package springmvc.miniproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import springmvc.miniproject.DAO.CourseDAO;
import springmvc.miniproject.DAO.CourseDAOImpl;
import springmvc.miniproject.entity.Course;
import springmvc.miniproject.service.TutionService;

@Controller
@RequestMapping("/course")
public class CourseController {
	
	@Autowired
	private TutionService tutionService;
	
	@GetMapping("/list")
	public String listCourse(Model model) {
		System.out.println("listCourse");
		//get all course
		//CourseDAO courseDAO = new CourseDAOImpl();
		List<Course>  courses  = tutionService.getAllCourses();
		courses.get(0).getId();
		courses.get(0).getCourseName();
		// add to model
		model.addAttribute("courses",courses);
		return "list-course";
	}

}
