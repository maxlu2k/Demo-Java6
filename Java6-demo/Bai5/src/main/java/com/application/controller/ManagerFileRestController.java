package com.application.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.application.services.FileManagerService;
import com.application.services.impl.FileManagerServiceImpl;

@RestController
public class ManagerFileRestController {
	@Autowired
	FileManagerServiceImpl fileManagerServiceImpl;

	@GetMapping("/rest/files/{folder}/{file}")
	public byte[] download(@PathVariable("folder") String folder,@PathVariable("file") String file,HttpServletResponse response) {
		response.addHeader("Content-disposition", "attachment;filename="+file);
		return fileManagerServiceImpl.read(folder, file);
	}
	@PostMapping("/rest/files/{folder}")
	public List<String> upload(@PathVariable("folder") String folder,@RequestParam("file") MultipartFile[] files) {
		return fileManagerServiceImpl.save(folder,files );
	}
	@DeleteMapping("/rest/delete/{folder}/{file}")
	public void delete(@PathVariable("folder") String folder,@PathVariable("file") String file) {
		fileManagerServiceImpl.delete(folder, file);
	}
	@GetMapping("/rest/files/{folder}")
	public List<String> list(@PathVariable("folder") String folder) {
		return fileManagerServiceImpl.list(folder);
	}
	
}
