package com.example.sms.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sms.Dto.StudentDto;
import com.example.sms.Entity.Student;

public interface StudentRepository extends JpaRepository<Student,Long>
{	

}
