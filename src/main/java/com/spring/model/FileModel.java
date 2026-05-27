package com.spring.model;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class FileModel {
	

	private MultipartFile file;
	 private String filePath;
	
	

}
