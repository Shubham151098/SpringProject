package com.psa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.psa.entity.Student;
import com.psa.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepository;

	public void saveReg(Student student) {
		studentRepository.save(student);
	}

	public List<Student> getAllStudents() {
		List<Student> students = studentRepository.findAll();
		return students;
	}

	public void deleteById(long id) {
		studentRepository.deleteById(id);
	}

	public Student getStudById(long id) {
		Student studId = studentRepository.findById(id).get();
		return studId;
	}

}
