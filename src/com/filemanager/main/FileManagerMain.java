package com.filemanager.main;

import java.util.List;
import java.util.Scanner;

import com.filemanager.exception.FileManagerException;
import com.filemanager.model.FileManager;
import com.filemanager.service.FileManagerService;
import com.filemanager.service.impl.FileManagerServiceImpl;

public class FileManagerMain {

	public static void main(String[] args) {
		System.out.println();
		System.out.println("Hello user! Welcome to FileManager v1.0 !!");
		System.out.println("[Developed by Vaibhav Harit]");
		System.out.println("******************************************");
		System.out.println("******************************************");
		System.out.println();
		int ch = 0;
		int ch1 = 0;
		Scanner scanner = new Scanner(System.in);
		FileManagerService service = new FileManagerServiceImpl();
		do {
			System.out.println();
			System.out.println("FileManager Main Menu..........");
			System.out.println("\nPlease select one of the options below (1,2,7)");
			System.out.println("----------------------------------------------");
			System.out.println("A. Press 1 to SHOW current Files' names in Ascending Order");
			System.out.println("B. Press 2 to Manage (Add, Delete, Search) Files: ");
			System.out.println("C. Press 7 to EXIT");
			System.out.println();
			try {
				ch = Integer.parseInt(scanner.nextLine());
			} catch (NumberFormatException e) {

			}
			switch (ch) {
			case 1:
				System.out.println("Showing the current available files' names in ascending order.....");
				try {
					List<String> fileNames = service.getFilesAscending();
					if (fileNames != null && fileNames.size() > 0) {
						System.out.println("The total available Files are: ");
						for (String f : fileNames) {
							System.out.println(f);
						}
					}
				} catch (FileManagerException e) {
					System.out.println(e);
				}
				break;

			case 2:
				System.out.println("B. Managing Files ..........");
				System.out.println("\nPlease select one of the options below (3-6)");
				System.out.println("- Press 3 to ADD a new file");
				System.out.println("- Press 4 to DELETE a file by its Name");
				System.out.println("- Press 5 to SEARCH a file by its Name");
				System.out.println("- Press 6 to GO BACK to Main Menu");
				try {
					ch1 = Integer.parseInt(scanner.nextLine());
				} catch (NumberFormatException e) {

				}
				boolean flag = true;
				while (flag) {
					switch (ch1) {
					case 3:
						System.out.println("Enter the details below to add a new File...");
						FileManager fm = new FileManager();
						System.out.println("Enter the Name of the File");
						fm.setName(scanner.nextLine());
						System.out.println("Enter the Importance of the File (Low/Medium/High)");
						fm.setImportance(scanner.nextLine());
						System.out.println("Enter the size of the File (Small/Medium/Large)");
						fm.setSize(scanner.nextLine());
						try {
							fm = service.addNewFile(fm);
							System.out.println("File added with details: " + fm);
						} catch (FileManagerException e) {
							System.out.println(e.getMessage());
						}
						flag = false;
						break;
						
					case 4:
						System.out.println("Enter the Name of the File to be deleted...");
						String name = scanner.nextLine();
						try {
							service.deleteFileByName(name);
							System.out.println("File with Name = " + name + " deleted successfully");
						} catch (FileManagerException e1) {
							System.out.println(e1.getMessage());
						}
						flag = false;
						break;

					case 5:
						System.out.println("Enter the Name of the File to be searched...");
						name = scanner.nextLine();
						try {
							System.out.println(service.searchFileByName(name));
						} catch (FileManagerException e) {
							System.out.println(e.getMessage());
						}
						flag = false;
						break;

					case 6:
						System.out.println("Going back to main menu");
						flag = false;
						break;
					default:
						System.out.println("Invalid Number entered. Please try again.");
						flag = false;
						break;
					}
				}
				break; 
				
			case 7: 
				System.out.println("Thank you for using FileManager v1.0 !!");
				System.out.println();
				break;

			default:
				System.out.println("Invalid Number entered. Please try again with a valid number (1,2,7) only");
				break;
			}
		} while (ch != 7);
	}

}
