package com.filemanager.service;

import com.filemanager.exception.FileManagerException;
import com.filemanager.model.FileManager;
import java.util.List;

public interface FileManagerService {

	public FileManager addNewFile(FileManager fileNew) throws FileManagerException;
	public void deleteFileByName(String name) throws FileManagerException;
	public FileManager searchFileByName(String name) throws FileManagerException;
	public List<String> getFilesAscending() throws FileManagerException;
	
}
