package com.ptk.domain;

import java.io.File;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

public class FileUpload {
	
	private MultipartFile file;
	private String fileName;
	
	public FileUpload(MultipartFile file, String uploadPath) {
		try {
		UUID uid = UUID.randomUUID();
		this.fileName = uid.toString()+"_"+file.getOriginalFilename();
		File target = new File(uploadPath, this.fileName);		
		FileCopyUtils.copy(file.getBytes(), target);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	

}
