package edu.kh.io.model.service;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Food {
	
	public static void main(String[] args) {
		
	ObjectOutputStream oos = null;
	
	try {
		
	oos = new ObjectOutputStream(new FileOutputStream("test2"));
														//경로
	// Food f = new Food("사과",20); 
	// 매개변수 생성자를 이용한 클래스를 안만들어줘서 오류나는 거임 
	
	
	//oos.writeObject(f);
	
	}catch(Exception e){
		
		e.printStackTrace();
		
	}finally {
		
		try {
			
			if(oos != null) oos.close();
			
		}catch(Exception e){
			
			e.printStackTrace();
		}
	}
		
	}
	
}
