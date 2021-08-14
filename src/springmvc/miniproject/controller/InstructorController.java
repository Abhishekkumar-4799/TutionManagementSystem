package springmvc.miniproject.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import springmvc.miniproject.DAO.Instructor;
import springmvc.miniproject.DAO.InstructorImpl;
import springmvc.miniproject.entity.InstructorDigitalInfo;
import springmvc.miniproject.entity.InstructorPersonalInfo;
import springmvc.miniproject.service.TutionService;

@Controller
@RequestMapping("/instructor")
public class InstructorController {
	
	@Autowired
	private TutionService tutionService;
	
	@GetMapping("/list")
	public String listInstructor(Model model) {
		List<Object[]> instructors = tutionService.getAllInstructorPersonaAndDigitalInfo();
		List<InstructorDetails> instructorDetails = new ArrayList<InstructorDetails>();
		
		for (Object[] row: instructors) {
			InstructorPersonalInfo instructorPersonalInfo = new InstructorPersonalInfo();
			InstructorDigitalInfo instructorDigitalInfo = new InstructorDigitalInfo();
			InstructorDetails instructorDetail = new InstructorDetails();
			//instructorPersonalInfo.setId((int)(row[0]));
			//instructorPersonalInfo.setName((String)(row[1]));
			//instructorPersonalInfo.setDateOfBirth((LocalDate)(row[2]));
			instructorDigitalInfo.setEmail((String) row[0]);
			instructorDigitalInfo.setLinkedIn((String) row[1]);
			instructorDigitalInfo.setInstaProfile((String) row[2]);
			instructorDigitalInfo.setId((int) row[4]);
			instructorDigitalInfo.setInstructorPersonalInfo((InstructorPersonalInfo) row[3]);
			instructorPersonalInfo.setId(instructorDigitalInfo.getInstructorPersonalInfo().getId());
			instructorPersonalInfo.setName(instructorDigitalInfo.getInstructorPersonalInfo().getName());
			instructorDetail.setInstructorPersonalInfo(instructorPersonalInfo);
			instructorDetail.setInstructorDigitalInfo(instructorDigitalInfo);
			instructorDetails.add(instructorDetail);
		}
		
		System.out.println("Instructor:" + instructorDetails.get(0).getInstructorPersonalInfo().getId());
		
		model.addAttribute("instructorsInfo", instructorDetails);
		return "list-instructor";
	}
	
	@GetMapping("/showformforadd")
	public String addInstructor(Model theModel) {
		InstructorDetails instructorDetails =  new InstructorDetails();
		theModel.addAttribute(instructorDetails);
		return "instructor-addform";
	}
	
	@PostMapping("/addInstructor")
	public String saveInstructor(@ModelAttribute("instructorDetails")  InstructorDetails instructorDetails) {
		System.out.println("1111111111111");
		System.out.println("instructorDetails" + instructorDetails.getInstructorPersonalInfo().getId());
		tutionService.addInstructorDetail(instructorDetails);
		
		return "redirect:/instructor/list";
	}
	@GetMapping("/delete")
	public String deleteInstructor(@RequestParam("instructorDigitalId")  int id) {		
		System.out.println("111111111");
		tutionService.deleteInstructorDetail(id);
		return "redirect:/instructor/list";
	}
	@GetMapping("/updateInstructorForm")
	public String showUpdateInstructorForm(@RequestParam("instructorDigitalId") int id, 
											Model theModel){ 
		System.out.println("id" + id);
		InstructorDetails instructorDetails = tutionService.getInstructorPersonaAndDigitalInfoById(id);
		System.out.println("personal" + instructorDetails.getInstructorPersonalInfo().getName() );
		System.out.println("digital" + instructorDetails.getInstructorDigitalInfo().getEmail() );
		theModel.addAttribute("instructorDetails", instructorDetails);
		return "instructor-updateform";
	}
}