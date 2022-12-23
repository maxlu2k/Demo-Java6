package com.application.services;

import java.nio.file.Path;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public interface FileManagerService {
	Path getPath(String folder,String name);
	List<String> save(String folder, MultipartFile[] multipartFiles);
	byte[] read(String folder,String name);
	void delete(String folder,String name);
	List<String> list(String folder);
}
