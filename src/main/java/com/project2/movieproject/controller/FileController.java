package com.project2.movieproject.controller;

import java.io.File;
import java.nio.file.Files;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project2.movieproject.admin.AdminService;

@RestController
public class FileController {

		@Autowired
		AdminService adminService;
		
		@Value("${project.upload.path}")
		private String uploadpath;
	
		@GetMapping("/display") 
		public ResponseEntity<byte[]> display(@RequestParam("filename") String filename,
							  @RequestParam("uuid")String uuid,
							  @RequestParam("filepath")String filepath) {
		
			File file = new File(uploadpath + "\\" + uuid+"_"+ filename);
			ResponseEntity<byte[]> result = null;
			try {
				HttpHeaders header = new HttpHeaders();
				header.add("content-type", Files.probeContentType(file.toPath()));
				
				result = new ResponseEntity<>(FileCopyUtils.copyToByteArray(file),header,HttpStatus.OK);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
			return result;
		}
		
		@GetMapping("/download")
		public ResponseEntity<byte[]> download(@RequestParam("filepath")String filepath,
											   @RequestParam("uuid") String uuid,
											   @RequestParam("filename")String name){
		return null;
		}
}
