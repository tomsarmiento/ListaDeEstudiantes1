package springdata2.studentslist.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import springdata2.studentslist.models.Contact;
import springdata2.studentslist.models.Student;
import springdata2.studentslist.services.StudentsListService;

@Controller
public class StudentsListController {
	private final StudentsListService stListServ;
	
	public StudentsListController(StudentsListService stListServ) {
		this.stListServ = stListServ;
	}
	
	@RequestMapping("/students")
	public String index(Model model) {
		model.addAttribute("students", stListServ.allStudents());
		return "studentslist/index.jsp";
	}
	
	@RequestMapping("/students/new") // I'm afraid this might not work
	public String createStudent(@ModelAttribute Student s) {
		return "studentslist/newstudent.jsp";
	}
	
	@RequestMapping("/students/create") // I'm saving a student through a ModelAttribute in a GET method. Never done this before. Kinda scares me
	public String saveStudent(@Valid @ModelAttribute Student s, BindingResult result) {
		if(result.hasErrors()) {
			return "studentslist/newstudent.jsp";
		}
		else {
			stListServ.createStudent(s);
			return "redirect:/students";
		}	
	}
	
	@RequestMapping("/contact/new")
	public String createContact(@ModelAttribute Contact c, Model model) {
		model.addAttribute("students", stListServ.allStudents());
		return "studentslist/newcontact.jsp";
	}
	
	@RequestMapping("/contact/create")
	public String saveContact(@Valid @ModelAttribute Contact c, BindingResult result) {
		if(result.hasErrors()) {
			return "studentslist/newcontact.jsp";
		}
		else {
			stListServ.createContact(c);
			return "redirect:/students";
		}
	}
}
