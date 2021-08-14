package springmvc.miniproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")

public class StudentController {
	
	@RequestMapping("/list")
	public String listSTudent(Model model) {
		
		return "list-student";
	}

}
