package com.filemanager.model;

public class FileManager {
	
	public int id;
	public String name;
	public String importance;
	public String size;
	
	public FileManager() {
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImportance() {
		return importance;
	}
	public void setImportance(String importance) {
		this.importance = importance;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	
	@Override
	public String toString() {
		return "Files: [ID=" + id + ", Name=" + name + ", Importance=" + importance + ", Size=" + size + "]";
	}

}
