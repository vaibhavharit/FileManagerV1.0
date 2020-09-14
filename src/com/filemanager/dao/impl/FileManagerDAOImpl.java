package com.filemanager.dao.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.filemanager.dao.FileManagerDAO;
import com.filemanager.exception.FileManagerException;
import com.filemanager.model.FileManager;

public class FileManagerDAOImpl implements FileManagerDAO {

	private static Map<String, FileManager> fileMap = new HashMap<>();
	private static int count;

	@Override
	public FileManager addNewFile(FileManager fileNew) throws FileManagerException {
		fileNew.setId(++count);
		fileMap.put(fileNew.getName(), fileNew);
		return fileNew;
	}

	@Override
	public void deleteFileByName(String name) throws FileManagerException {
		if (fileMap.containsKey(name)) {
			fileMap.remove(name);
		} else {
			throw new FileManagerException("Entered File Name: " + name + " does not exist.");
		}
	}

	@Override
	public FileManager searchFileByName(String name) throws FileManagerException {
		if (fileMap.containsKey(name)) {
			System.out.println("File found successfully with the given name: " + name);
			return fileMap.get(name);
		} else {
			throw new FileManagerException("File with name: " + name + " does not exist");
		}
	}

	@Override
	public List<String> getFilesAscending() throws FileManagerException {
		if (fileMap.size() > 0) {
			List<String> nameList = new ArrayList<String>(fileMap.keySet());
			Collections.sort(nameList);
			return nameList;
		}
		else {
			throw new FileManagerException("No files in the current directory.");
		}
	}

}
