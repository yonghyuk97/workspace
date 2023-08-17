package edu.kh.inheritance.practice.medel.service;

import java.util.Scanner;

import edu.kh.inheritance.practice.medel.vo.Employee;
import edu.kh.inheritance.practice.medel.vo.Person;
import edu.kh.inheritance.practice.medel.vo.Student;

public class PracticeService {
	
	public void homework() {
		
		Student[] str = new Student[3];
		
		str[0] = new Student("카리나",20,168.2,70.0,1,"정보시스템공학과");
		str[1] = new Student("정해인",21,187.3,80.0,2,"경영학과");
		str[2] = new Student("박서준",23,179.0,45.0,4,"경영학과");
		
        for(int i = 0; i<str.length; i++) {
        	
        	System.out.println(str[i]);
        }
		
        Employee[] srr = new Employee[10];
		
		Scanner sc = new Scanner(System.in);
		
		int count = 0;
		
		String flag = "add";
		
		
		
		while(true) {
		   if(flag.equals("add")) {
			      System.out.print("이름 : ");
			      String name = sc.next();
			      
			      System.out.print("나이 : ");
			      int age = sc.nextInt();
			      
			      System.out.print("신장 : ");
			      double height = sc.nextDouble();
			      
			      System.out.print("몸무게 : ");
			      double weight = sc.nextDouble();
			      
			      System.out.print("급여 : ");
			      int salary = sc.nextInt();
			      
			      System.out.print("부서 : ");
			      String dept = sc.next();
			      
			
			srr[count] = new Employee(name,age,height,weight,salary,dept);
		   } 
				
				
				
				if(count < 9) {
					System.out.print("계속 입력 하시겠습니까 ? (y/n) :");
					String yn = sc.next();
					if(yn.equals("Y") || yn.equals("y")) {
						count++;
						flag = "add";
						continue;
					}else if(yn.equals("N") || yn.equals("n")) {
						break;
					}else if(!yn.equalsIgnoreCase("Y") || !yn.equalsIgnoreCase("N")){
						System.out.print("잘못 입력하셨습니다. 다시 입력해 주세요 \n");
						flag = "";
						continue;
					}
				} else {
					break;
				}
		}
		
		for(int i = 0; i<=count; i++) {
		System.out.println(srr[i]);
		}
        
        
      
       
      
      
        
        
        
     }
     

 
		
		
		
		
	}


