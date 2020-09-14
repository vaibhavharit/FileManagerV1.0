package com.filemanager.dao;
import java.util.*;

import com.filemanager.exception.FileManagerException;
import com.filemanager.model.FileManager;

public interface FileManagerDAO {
	
	public FileManager addNewFile(FileManager fileNew) throws FileManagerException;
	public void deleteFileByName(String name) throws FileManagerException;
	public FileManager searchFileByName(String name) throws FileManagerException;	
	public List<String> getFilesAscending() throws FileManagerException;
	
}
