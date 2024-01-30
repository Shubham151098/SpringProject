package com.psa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.psa.dto.StudentDto;
import com.psa.entity.Student;
import com.psa.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@RequestMapping("/home")
	public String mainPage() {
		return "home";
	}
	
//	@RequestMapping("/saveReg")
//	public String saveReg(Student student, Model model) {
//		studentService.saveReg(student);
//		model.addAttribute("msg", "Data saved successfully");
//		return "home";
//	}
	
//	@RequestMapping("/saveReg")
//	public String saveReg(
//			@RequestParam("name") String name,
//			@RequestParam("city") String city,
//			@RequestParam("email") String email,
//			@RequestParam("mobile") String mobile,
//			Model model) {
//		Student student = new Student();
//		student.setName(name);
//		student.setCity(city);
//		student.setEmail(email);
//		student.setMobile(mobile);
//		studentService.saveReg(student);
//		model.addAttribute("msg", "Data saved successfully");
//		return "home";
//	}
	
	@RequestMapping("/saveReg")
	public String saveReg(
			StudentDto dto,
			Model model) {
		Student student = new Student();
		student.setName(dto.getName());
		student.setCity(dto.getCity());
		student.setEmail(dto.getEmail());
		student.setMobile(dto.getMobile());
		studentService.saveReg(student);
		model.addAttribute("msg", "Data saved successfully");
		return "home";
	}
	
	@RequestMapping("/getStudents")
	public String getAllStudents(Model model){
		List<Student> students = studentService.getAllStudents();
		model.addAttribute("studs", students);
		return "list_registration";
	}
	
	@RequestMapping("/delete")
	public String deleteByID(@RequestParam("id") long id, Model model) {
		studentService.deleteById(id);
		List<Student> studentsById = studentService.getAllStudents();
		model.addAttribute("studs", studentsById);
		return "list_registration";
	}
	
	@RequestMapping("/getStudById")
	public String getStudById(@RequestParam("id") long id, Model model) {
		Student student = studentService.getStudById(id);
		model.addAttribute("stud", student);
		return "update_reg";
	}
	
	@RequestMapping("/update")
	public String updateStudent(StudentDto dto, Model model) {
		Student student = new Student();
		student.setId(dto.getId());
		student.setName(dto.getName());
		student.setCity(dto.getCity());
		student.setEmail(dto.getEmail());
		student.setMobile(dto.getMobile());
		studentService.saveReg(student);	
		List<Student> students = studentService.getAllStudents();
		model.addAttribute("studs", students);
		System.out.println(student.getName());
		return "list_registration";
	}
}
