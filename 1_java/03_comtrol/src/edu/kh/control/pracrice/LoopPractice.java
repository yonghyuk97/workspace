package edu.kh.control.pracrice;

import java.util.Scanner;

public class LoopPractice {
	
	    public void practice1() {
	
	    // 사용자로부터 한 개 의 값을 입력 받아 1부터 그 숫자까지의 숫자들을 모두 출력하세요.	
	    // 단, 입력한 수는 1보다 크거나 같아야 합니다. 	
	    // 만일 1 미만의 숫자가 입력됐다면 "1 이상의 숫자를 입력해주세요" 를 출력하세요.
		
        Scanner sc = new Scanner(System.in);
		
		System.out.print(" 1이상의 숫자를 입력하세요 : ");
		
		int num = sc.nextInt();
		
		if(num >= 1) {
			for(int i =1; i <= num ; i++) {
				System.out.print(i + " ");
				
			}
			
		}else {
			System.out.println("1 이상의 숫자를 입력해주세요. ");
			
		}

				
			
		
	}
	
	    public void practice2() {
		
	    // 사용자로부터 한 개의 값을 입력받아 1부터 그 숫자까지의 모든 숫자를 거꾸로 출력하세요.
        // 단, 입력한 수는 1보다 크고나 같아야 합니다.
				
		Scanner sc = new Scanner(System.in);
		
		System.out.print("1 이상의 숫자를 입력하세요 : ");
		int num = sc.nextInt();
		
		if(num >= 1 ) {
			
			for( int i = num ; i >= 1 ; i-- ) {
				System.out.print(i + " ");
			}
				
		}else {
			System.out.println("1 이상의 숫자를 입력해주세요. ");
		}
	
		
		
		
	}
	
	    public void practice3() {
		
	    // 1부터 사용자에게 입력 받은 수까지의 정수들의 합을 for문을 아용하여 출력하세요.
		
/*		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수를 하나 입력하세요 : ");
		int num = sc.nextInt();
		
		int sum = 0;
		
		for ( int i = 1 ; i <= num; i++) {
			System.out.print(i + " + ");
			
			sum += i;
		}
			
		System.out.print(" = " + sum);
*/		
	    	
			Scanner sc = new Scanner(System.in);
			
			System.out.print("정수를 하나 입력하세요 : ");
			int num = sc.nextInt();
			
			int sum = 0;
			
			for ( int i = 1 ; i <= num; i++) {
				sum += i;
			if(i == num) {
				System.out.print(i + " = " + sum);
			} else {System.out.print(i + " + ");
				
	        }
		    } 
	    
	    }

	
	    public void practice4() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("첫 번째 숫자 :");
		int input = sc.nextInt();
		System.out.print("두 번째 숫자 :");
		int input1 = sc.nextInt();
		
		int num1;
		int num2;
		
		if(input < 1 || input1 < 1) {
			System.out.println("1 이상의 숫자를 입력해주세요");
		
		} else { 
			   
			if (input < input1) {
				num1 = input;
				num2 = input1;
			} else {
				num1 = input1;
				num2 = input;
			}
			for (int i =num1; i <= num2; i++) {
				System.out.print(i + " ");
			}
			
		}
		
		
		
	}
		
	     public void practice5() {
	    	
	     // 사용자로부터 입력 받은 숫자의 단을 출력하세요.
	    	
	     Scanner sc = new Scanner(System.in);
	     System.out.print("숫자 :");
	      
	     int input = sc.nextInt();
	      
	     System.out.println("====" + input + "단 ====");
	      
	     for (int j = 1; j <=9; j++) {
	    	 
	    	 System.out.println(input + "*" + j + "=" + input * j );
	     }
	    
    	
    	
    	
    	
    }
	     
	    public void practice6() {
	    	 
	    //사용자로부터 입력 받은 숫자의 단부터 9까지 출력하세요.
	    //단, 2~9를 사이가 아닌 수를 입력하면 "2~9 사이 숫자만 입력해주세요" 를 출력하세요
	    	 
	    Scanner sc = new Scanner(System.in);
	    System.out.print("숫자 :");
	    int input = sc.nextInt();
	    
	    if(input <= 1 || input >= 10) {
	    	System.out.print("2~9 사이 숫자만 입력해주세요.");
	    }else {
	    	for(int i = input; i <=9; i++) {
	    		System.out.println("====" + input + "단 ====");
	    		input++;
	    		for(int dan = 1; dan <=9; dan++) {
	    			System.out.println(i + "*" + dan + "=" + i * dan );
	    		}
	    		
	    	}
	    }
	    
	    
	    
	    	 
	    	 
	     }
	     
	   public void practice7() {
		 
		//다음과 같은 실행 예제를 구현하세요
		
	   Scanner sc = new Scanner(System.in);
	   System.out.print("정수 입력 :");
	   int input = sc.nextInt();
	   
	   for(int a = 1; a <= input; a++ ) {
		   for(int b = 1; b <= a; b++) {
			   System.out.print("*");
		   }System.out.println();
	   }
		   
	   }
	   
	   public void practice8() {
	   
	   Scanner sc = new Scanner(System.in);
	   System.out.print("정수 입력 :");
	   int input = sc.nextInt();
	   
	   for(int a = input; a >=1; a-- ) {
		   for(int b = a; b >=1; b--) {
			   System.out.print("*");
		   }System.out.println();
	   }	   
		   
	   }
	   public void practice9() {
	   
	   Scanner sc = new Scanner(System.in);
	   System.out.print("정수 입력 :");
	   int input = sc.nextInt();
	   
	   for(int a = 1; a <= input; a++ ) {
		   for(int b = input; b >= 1; b--) {
			       if(a<b) {
			    	    System.out.print(" ");
			       }else {
			    	   System.out.print("*");
			    	     
			       }
			   
		   }System.out.println();
	   }
	   
	   
	   
	  /*  for(int x = 1; x <= input; x++){
	    	// 1) for문 하나 더 작성
	 	   // * 1개 출력 전에 띄어쓰기 3번
	 	   // * 2개 출력 전에 띄어쓰기 2번
	 	   // * 3개 출력 전에 띄어쓰기 1번
	 	   // * 4개 출력 전에 띄어쓰기 3번
	    	
	       // y == 3 2 1 0
	      for(int y = input -1; y >=1; y--) {
	    	  System.out.println(" ");
	      }
	    	
	    
	      for(int i  =1; x <= input; i++) {
	       System.out.print("*");
	      }
	     
	      System.out.println();
	    }
	    
	    */
	   
	   
	    
		   
	   }
	   public void practice10() {
		   
		   
		   Scanner sc = new Scanner(System.in);
		   System.out.print("정수 입력 :");
		   int input = sc.nextInt();
		   
		   //윗쪽 삼각형
		   for(int x = 1; x <= input; x++) {
			   
			   for(int i = 1; i <=x; i++) {
				   System.out.print("*");
			   }System.out.println();
		   }
		   
		   // 아랫쪽 삼각형
		   for(int y = input -1; y >=1; y--) {
			   
			  for(int i = 1; i <=y; i++) {
				  System.out.print("*");
			  }
			  System.out.println(); 
			   
		   }
		   
		   
		   
		   
	   }
	   public void practice11() {
		
       Scanner sc = new Scanner(System.in);
		   
	   System.out.print("정수를 입력하세요 :");
	   int input = sc.nextInt();
	   
	   for(int x = 1; x <= input; x++) { // 입력 받은 input 만큼 줄 출력
		   
		   // 공백 출력 for문
		   for(int i = input - x; i >=1; i--) {
			   System.out.print(" ");
		   }
		   
		   
		   // * 출력 for문
		   // 1, 3, 5, 7, 9 
		   for(int i = 1; i <=2 * x -1; i++) {
			   System.out.print("*");
		   }
		   System.out.println(); // 줄바꿈
		   
	   }
	   
		   
		   
		   
		   
	   }
	   public void practice12() {
		
	   Scanner sc = new Scanner(System.in);
	   
	   System.out.print("정수를 입력하세요 :");
	   int input = sc.nextInt();
	   
	   /*for(int i = 2; i <= num; i++) {
		   if(i == 2) {
			   System.out.print("*****");
			   System.out.println();
		   }if(i == num) {
			   System.out.print("*****");
		   }else {System.out.println("*   *");
		   
	   }
		 */  
		   
		   
		   
		   
		   
	   
	   
	   // row : 행(줄)
	   // col(column) : 열(칸)
	   
	   for(int row = 1; row <= input; row++) {
	       
		   for(int col=1; col <= input; col++) {
			  // row 또는 col이 1 또는 input인 경우 * 출력
			  // == 테두리 
			  if(row == 1 || col ==1 || row == input || col == input) {
				  System.out.print("*");
				  
			  }else { // 내부
				  System.out.print(" ");
			   
		      
		   
	   }System.out.println();
	   
	   }
    
	   }
	   
	   }
	   
	   public void practice13() {
	
	   // 1부터 사용자에게 입력 받은 수까지 중에서
	   //      1)2와 3의 배수를 모두 출력하고
	   //      2)2와 3의 공배수의 개수를 출력하세요.
		   
	   Scanner sc = new Scanner(System.in);
	   System.out.print("자연수 하나를 입력하세요 : ");
	   int num = sc.nextInt();
	   
	   int count = 0;
	   
	   for(int i = 1; i <= num; i++) {
		   
		   if(i % 2 == 0 || i % 3 == 0) {
			   System.out.print(i+ " " );
		   }
		   if(i % 2== 0 && i % 3 == 0) {
			   count++;
		   }
		   
		   
	   }System.out.println();
	   System.out.println("count :" + count);
	   
		   
		   
		   
		   
	   }
	   
	 

}
