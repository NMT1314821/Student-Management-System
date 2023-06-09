package com.example.sms.Mapper;

import com.example.sms.Dto.StudentDto;
import com.example.sms.Entity.Student;

public class StudentMapper
{
	//map jpa to dto
	public static StudentDto mapToStudentDto(Student student)
	{
		
		StudentDto studentDto=new StudentDto(	
		student.getId(),
		student.getFirstName(),
		student.getLastName(),
		student.getEmail()
		);
		return studentDto;
	}
	
	public static Student mapToStudent(StudentDto studentDto)
	{
		Student student=new Student(
				studentDto.getId(),
				studentDto.getFirstName(),
				studentDto.getLastName(),
				studentDto.getEmail()
				
				);
		
		return student;
	}
	

}
