package com.psa.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.psa.dto.StudentDto;
import com.psa.entity.Student;
import com.psa.exception.ResourceNotFoundException;
import com.psa.repository.StudentRepository;

@RestController
@RequestMapping("/api/registration")
public class RestRegistrationController {

	@Autowired
	private StudentRepository studentRepository;
	
	@GetMapping
	public ResponseEntity<List<Student>> getAllReg(){
		List<Student> students = studentRepository.findAll();
		return new ResponseEntity<>(students, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteRegistration(@PathVariable long id) {
		Optional<Student> byId = studentRepository.findById(id);
		if(byId.isPresent()) {
			studentRepository.deleteById(id);
		}else {
			throw new ResourceNotFoundException("Record not found with id: "+ id);
		}
		
		return new ResponseEntity<>("Record is deleted", HttpStatus.OK);
	}
	
	// Save Registration
	@PostMapping
	public ResponseEntity<Student> saveRegistration(@RequestBody Student student) {
		Student sevedStudent = studentRepository.save(student);
		return new ResponseEntity<>(sevedStudent, HttpStatus.CREATED);
	}   
	
	//Update Registration
	@PutMapping("/{id}")
	public ResponseEntity<Student> updateRegistration(@PathVariable long id, @RequestBody StudentDto dto) {
		Student student = studentRepository.findById(id).get();
		student.setName(dto.getName());
		student.setCity(dto.getCity());
		student.setEmail(dto.getEmail());
		student.setMobile(dto.getMobile());
		Student updatedStudent = studentRepository.save(student);
		return new ResponseEntity<>(updatedStudent, HttpStatus.OK);
	}
}
