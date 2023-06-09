package com.example.sms.Service.Impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.catalina.mapper.Mapper;
import org.springframework.stereotype.Service;

import com.example.sms.Dto.StudentDto;
import com.example.sms.Entity.Student;
import com.example.sms.Mapper.StudentMapper;
import com.example.sms.Repository.StudentRepository;
import com.example.sms.Service.StudentService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService 
{
	
	private StudentRepository studentRepo;

	@Override
	public List<StudentDto> getAllStudents()
	{
		List<Student> students=studentRepo.findAll();
		List<StudentDto> getll=students.stream()
				.map((student)->StudentMapper.mapToStudentDto(student))
				.collect(Collectors.toList());
		return getll;
	}

	@Override
	public void createStudent(StudentDto studentDto)
	{
		Student student=StudentMapper.mapToStudent(studentDto);
		studentRepo.save(student);
		
	}

	@Override
	public StudentDto getStudentById(Long studentId) 
	{
		Student st=studentRepo.findById(studentId).get();
		StudentDto dto=StudentMapper.mapToStudentDto(st);	
		return dto;
	}

	@Override
	public void updateStudent(@Valid StudentDto studentDto) 
	{
		studentRepo.save(StudentMapper.mapToStudent(studentDto));
		
	}

	@Override
	public void deleteStudent(Long studentId)
	{
		studentRepo.deleteById(studentId);
		
	}
	


	
}
