package com.example.sms.Dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto 
{
	private long id;
	
	@NotEmpty(message="FirstName should not be empty")
	private String firstName;
	
	@NotEmpty(message="LastName should not be empty")
	private String lastName;
	
	@NotEmpty(message="Email should not be empty")
	@Email
	private String email;
}
