package com.ptk.domain;

import java.io.File;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

public class FileUpload {
	
	private MultipartFile file;
	private String fileName;
	
	@Resource(name = "uploadPath")
	private String uploadPath;
	
	public FileUpload(MultipartFile file) {
		UUID uid = UUID.randomUUID();
		this.fileName = uid.toString()+"_"+file.getOriginalFilename();
		File target = new File(uploadPath, this.fileName);
		try {
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
