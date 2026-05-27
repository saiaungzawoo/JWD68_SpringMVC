package com.spring.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.spring.model.FileModel;
import com.spring.repo.FileRepo;

@Controller
public class FileUploadController {

	@Autowired
	ServletContext context;

	@GetMapping("/fileUploadPage")
	public ModelAndView fileUploadPage() {

		FileModel file = new FileModel();

		// jsp, obj, file bean
		ModelAndView modelAndView = new ModelAndView("file-upload", "command", file);

		return modelAndView;
	}

	@PostMapping("/fileUploadPage")
	public String fileUpload(@Validated FileModel file, BindingResult result, ModelMap model) throws IOException {

		if (result.hasErrors()) {

			System.out.println("validation errors");
			return "fileUploadPage";

		} 
		
//		else {
//
//			System.out.println("Fetching file");
//			MultipartFile multipartFile = file.getFile();
//			String uploadPath = "D:/uploads/";
//			
//			File uploadDir = new File(uploadPath);
//
//			//  create folder if not exists
//			if (!uploadDir.exists()) {
//			    uploadDir.mkdirs();
//			}
//
//			// Now do something with file...
//			FileCopyUtils.copy(file.getFile().getBytes(), new File(uploadPath + file.getFile().getOriginalFilename()));
//			String fileName = multipartFile.getOriginalFilename();
//			model.addAttribute("fileName", fileName);
//			return "success";
//		}
		
		
		MultipartFile multipartFile = file.getFile();

		if (!multipartFile.isEmpty()) {
			
			String fileName = multipartFile.getOriginalFilename();
			
			String uploadPath = "D:/uploads/";
			File uploadDir = new File(uploadPath);
			
			//create a dir if not exist
			  if (!uploadDir.exists()) {
		            uploadDir.mkdirs();
		        }
			  
			  //save file to disk
			  File dest = new File(uploadDir, fileName);
		        multipartFile.transferTo(dest);
		        
		        //store relative path (important)
		        String dbPath = "uploads/" + fileName;
		        
		        model.addAttribute("filePath", dbPath);
		        
		        //save to DB
		        FileRepo fileRepo = new FileRepo();
		        fileRepo.saveFilePathToDatabase(dbPath);
		        
		        model.addAttribute("fileName", fileName);

		}
		
		return "success";

	}

}
