package com.application.services.impl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.application.services.FileManagerService;

@Service
public class FileManagerServiceImpl implements FileManagerService {
	private final String delim = File.pathSeparator;

	@Override
	public byte[] read(String folder, String name) {
		Path path = this.getPath(folder, name);

		try {
			return Files.readAllBytes(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}

	@Override
	public Path getPath(String folder, String name) {
		File path = Paths.get(System.getProperty("user.dir") + "/src/main/resources/static/upload/", folder).toFile();
		if (!path.exists()) {
			path.mkdirs();
		}
		return Paths.get(path.getAbsolutePath(), name);
	}

	@Override
	public void delete(String folder, String name) {
		Path path = this.getPath(folder, name);
		path.toFile().delete();

	}

	@Override
	public List<String> save(String folder, MultipartFile[] multipartFiles) {
		List<String> fileNames = new ArrayList<>();
		for (MultipartFile item : multipartFiles) {
			String name = System.currentTimeMillis() + item.getOriginalFilename();
			String fileName = Integer.toHexString(name.hashCode()) + name.substring(name.lastIndexOf("."));
			Path path = this.getPath(folder, fileName);
			try {
				item.transferTo(path);
				fileNames.add(fileName);
			} catch (IllegalStateException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return fileNames;

	}

	@Override
	public List<String> list(String folder) {
		List<String> fileNames = new ArrayList<>();
		File file = this.getPath(folder, "").toFile();
		if(file.exists()) {
			File[] files = file.listFiles();
			for (File file2 : files) {
				fileNames.add(file2.getName());
			}
		}
		return fileNames;
	}

}
