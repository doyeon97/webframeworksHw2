package kr.ac.hansung.controller;

import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.ac.hansung.model.CreditsPerSemester;
import kr.ac.hansung.model.Subject;
import kr.ac.hansung.service.SubjectService;

@Controller
public class SubjectController {

	@Autowired
	private SubjectService subjectService;

	@RequestMapping(value = "/checkcredit")
	public String checkCredit(Model model) {

		List<CreditsPerSemester> creditsPerSemesters = subjectService.getCreditsPerSemester();
		model.addAttribute("creditsPerSemesters", creditsPerSemesters);

		return "checkcredit";
	}

	@RequestMapping(value = "/checkcreditsPerSemester")
	public String checkCreditPerYearAndSemester(@RequestParam("year") int year, @RequestParam("semester") int semester,
			Model model) {
		List<Subject> subjects=subjectService.getCurrent();
		
		model.addAttribute("subjects",subjects);
		
		model.addAttribute("year", year);
		model.addAttribute("semester", semester);
		
		return "checkcreditsPerSemester";
	}
	
	@RequestMapping(value="/signupclasses")
	public String signUpClasses(Model model) {
		
		model.addAttribute("subject",new Subject());
		
		return "signupclasses";
	}
	
	@RequestMapping(value="/checkclasses")
	public String checkClasses(Model model) {
		
		List<Subject> subjects=subjectService.getCurrent();
		model.addAttribute("subjects",subjects);
		
		return "checkclasses";
	}
	
	@RequestMapping(value="/saveclass")
	public String saveClass(Model model, Subject subject) {
		
		subjectService.insert(subject);
		
		return "home";
	}
}
