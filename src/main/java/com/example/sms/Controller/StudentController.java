package com.example.sms.Controller;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.sms.Dto.StudentDto;
import com.example.sms.Service.StudentService;

import jakarta.validation.Valid;
import lombok.val;


@Controller
public class StudentController 
{
	
	private StudentService studentServ;

	public StudentController(StudentService studentServ) {
		super();
		this.studentServ = studentServ;
	}



	@GetMapping("/students")
	public String getAllstu(Model model)
	{
		List<StudentDto> students=studentServ.getAllStudents();
		
		model.addAttribute("students", students);
		
		return "students";
				
	}
	
	@GetMapping("/students/new")
	public String newStudent(Model model)
	{
		StudentDto sdto=new StudentDto();
		model.addAttribute("student",sdto);
		return "create-student";
	}
	
	@PostMapping("/students")
	public String saveStudent(@Valid @ModelAttribute("student") StudentDto student,
								BindingResult result,
								Model model)
	{
		if(result.hasErrors())
		{
			model.addAttribute("student",student);
			return "create-student";
		}
		studentServ.createStudent(student);
		return "redirect:/students";
	}
	
	@GetMapping("/students/{studentId}/edit")
	public String getStudentById(@PathVariable("studentId") Long studentId,
									Model model)
	{
		StudentDto studentDto=studentServ.getStudentById(studentId);
		model.addAttribute("student",studentDto);
		return "edit-student";
	}
	@PostMapping("/students/{studentId}")
	public String updateStudent(@PathVariable("studentId") Long studentId,
								@Valid @ModelAttribute("student") StudentDto studentDto,
								BindingResult result, 
								Model model)
	{
		if(result.hasErrors())
		{
			model.addAttribute("student", studentDto);
			return "edit-student";
		}
		studentDto.setId(studentId);
		studentServ.updateStudent(studentDto);
		return "redirect:/students";
		}
		
		@GetMapping("/students/{studentId}/delete")
		public String deleteStudent(@PathVariable("studentId") Long studentId)
		{
			studentServ.deleteStudent(studentId);
			
			return "redirect:/students"; 
		}
		@GetMapping("/students/{studentId}/view")
		public String viewStudent(@PathVariable("studentId") long studentId, Model model)
		{
			StudentDto studentDto=studentServ.getStudentById(studentId);
			model.addAttribute("student",studentDto);
			return "view-student";
		}
		

}
