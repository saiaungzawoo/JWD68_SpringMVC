package com.spring.model;

import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentBean {
	
	
	@NotNull
	private Integer id;
	
	@NotEmpty
	private String name;
	
	@Range(max = 70, min = 18	)
	@NotNull
	private Integer age;
	
	
	  private String password;
	  private String address;
	  private boolean newsletter;
	  private List<String> frameworks;
	  private String gender;
	  private Integer favNumber;
	  
	  private String country;
	  private List<String>  skills;

}
