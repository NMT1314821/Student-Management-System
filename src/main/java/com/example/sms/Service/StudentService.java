package com.example.sms.Service;

import java.util.List;

import com.example.sms.Dto.StudentDto;

import jakarta.validation.Valid;


public interface StudentService 
{
	
	List<StudentDto> getAllStudents();

	void createStudent(StudentDto student);

	StudentDto getStudentById(Long studentId);

	void updateStudent(@Valid StudentDto studentDto);

	void deleteStudent(Long studentId);

}
