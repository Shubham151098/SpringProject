package com.psa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.psa.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{

}
