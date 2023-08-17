package edu.kh.collection.run;

import edu.kh.collection.medel.service.StudentService;

public class StudentRun {

	public static void main(String[] args) {
		
		StudentService service = new StudentService();
		
		service.displayMenu();
//		service.ex();
		

	}

}
