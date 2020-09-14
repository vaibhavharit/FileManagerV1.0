package com.filemanager.service.impl;

import com.filemanager.dao.FileManagerDAO;
import com.filemanager.dao.impl.FileManagerDAOImpl;
import com.filemanager.model.FileManager;
import com.filemanager.service.FileManagerService;
import com.filemanager.exception.FileManagerException;

import java.util.List;

public class FileManagerServiceImpl implements FileManagerService {

	private FileManagerDAO dao = new FileManagerDAOImpl();

	@Override
	public FileManager addNewFile(FileManager fileNew) throws FileManagerException {
		if (!isValidName(fileNew.getName())) {
			throw new FileManagerException("Entered Name of the File " + fileNew.getName() + " is invalid. Please use alphabets & numbers only.");
		}
		else if (!isValidImportance(fileNew.getImportance())) {
			throw new FileManagerException("Entered Importance of the File " + fileNew.getImportance() + " is invalid");
		}
		else if (!isValidSize(fileNew.getSize())) {
			throw new FileManagerException("Entered Size of the File " + fileNew.getSize() + " is invalid");
		}
		return dao.addNewFile(fileNew);
	}
	
	private boolean isValidName(String name) {
		boolean flag = false;
		if (name.trim().matches("[a-zA-Z0-9 ]{1,20}")) {
			flag = true;
		}
		return flag;
	}

	private boolean isValidImportance(String imp) {
		boolean flag = false;
		imp = imp.toLowerCase();
		if (imp.equals("low") || imp.equals("medium") || imp.equals("high")) {
			flag = true;
		}
		return flag;
	}
	
	private boolean isValidSize(String size) {
		boolean flag = false;
		size = size.toLowerCase();
		if (size.equals("small") || size.equals("medium") || size.equals("large")) {
			flag = true;
		}
		return flag;
	}
	
	@Override
	public void deleteFileByName(String name) throws FileManagerException {
		if (!isValidName(name)) {
			throw new FileManagerException("File with name: " + name + " does not exist");
		}
		else {
			dao.deleteFileByName(name);
		}
	}

	@Override
	public FileManager searchFileByName(String name) throws FileManagerException {
		if (!isValidName(name)) {
			throw new FileManagerException("File with name: " + name + " does not exist");
		}
		else {
			return dao.searchFileByName(name);
		}
	}

	@Override
	public List<String> getFilesAscending() throws FileManagerException {
		return dao.getFilesAscending();
	}
	
}
