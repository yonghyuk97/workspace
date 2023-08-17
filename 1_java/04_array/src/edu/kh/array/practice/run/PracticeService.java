package edu.kh.array.practice.run;

import java.util.Arrays;
import java.util.Scanner;

public class PracticeService {
	
	public void practice1(){
			
    int[] num = new int[9];	
	
    int sum = 0;
    
    for(int i = 0; i < num.length; i++) {
    	
    	num[i] = i+1;
    	
    	System.out.print(num[i] + " ");
    	
    	if(i % 2 == 0 || i ==0 ) {
    		sum+=num[i];
    		}
    }
    System.out.println();
	System.out.println("짝수 번째 인덱스 합 : " + sum);	
	System.out.println(Arrays.toString(num));	

		
		
		
		
	}
	
	public void practice2(){
		
	int[] num = new int[9];
	
	int sum = 0;
	
	for(int i = 8; i >=0; i--) {
		num[i] = i+1;
		System.out.print(num[i]+ " ");
		
		if(i % 2 !=0) {
			sum+=num[i];
			
		}
	
		
	}
	System.out.println();
	System.out.println("홀수 번째 인덱스 합 : " + sum);	
	System.out.println(Arrays.toString(num));
			
			
	
		
		
		
	
	}
	
	public void practice3(){
		
	Scanner sc = new Scanner(System.in);
	
	System.out.print("양의 정수 : ");
	
	int input = sc.nextInt();
	
	int[] num = new int[input];
	
	for(int i = 0; i < num.length; i++) { 
		
		num[i] = i + 1;
		
//		System.out.print(i+1 + " ");
        System.out.print(num[i] + " ");		
		
	}System.out.println();
	System.out.println(Arrays.toString(num));
	
	
	
	
		
		
		
		
		
		
	}
	
	public void practice4() {
		
    /*int[] num = new int[5];
	
    
    
    for(int i = 0; i < num.length; i++) {
    	Scanner sc = new Scanner(System.in);
    	System.out.print("입력" + i + " : ");
    	int input = sc.nextInt();
    	num[i] = input;	
    	
    }*/
		
	Scanner sc = new Scanner(System.in);
      
	int num[] = new int[5];
    int searchNum;
    boolean flag = false;
      
    for(int i = 0; i<num.length; i++) {
         System.out.print("입력 " + i + " :");
         num[i] = sc.nextInt();
         if(i == 4) { 
            System.out.print("검색할 값 : ");
            searchNum = sc.nextInt();
            for(int x = 0; x < num.length; x++) {
               if(num[x] == searchNum) {
                  System.out.println("인덱스 : " + x);
                  flag = true;
                  
               }
            }
         }
      }
      if(flag == false) {
         System.out.println("일치하는 값이 존재하지 않습니다.");
      }	
   

		
	   

	}
	
	public void practice5() {
	
	Scanner sc = new Scanner(System.in);
	
	System.out.print("문자열 : ");
	String str = sc.nextLine();
	
	System.out.print("문자 : ");
	char ch = sc.next().charAt(0); // 입력 받은 문자열에서 0번 인덱스 문자를 반환
	           // String -> char
	
	
	char[] arr = new char[str.length()]; // 입력 받은 문자열 길이 만큼의 배열 생성
	
	String index = "";
	int count = 0; // str에 일치하는 ch가 몇개 있는지 카운트하는 변수

	for (int i = 0; i <arr.length; i++) {
		
		// 입력 받은 문자열에서 i번째 인덱스 문자를 arr[i]에 대입
		arr[i] = str.charAt(i);
		if (ch == arr[i]) { // 검색 조건
			index += i + " ";
			count++;
		}
	}
	
	System.out.println(str + "에 " + ch + "가 존재하는 위치(인덱스) : " + index);
	System.out.println(ch + " 개수 : " + count);
	
		
		
		
	}
	
	public void practice6() {
		
	Scanner sc = new Scanner(System.in);
	
	System.out.print("정수 : ");
	int num = sc.nextInt();
	
	int[] arr = new int[num];
	int sum = 0;
	
	for (int i = 0; i < arr.length; i++) {
		System.out.print("배열 " + i + "번째 인덱스에 넣을 값 : ");
		arr[i] = sc.nextInt();
		sum += arr[i];
	}
	
	for (int i = 0; i < arr.length; i++)
		System.out.print(arr[i] + " ");
	
	System.out.println("\n총 합 : " + sum);	
		
		
		
		
	}
	public void practice7() {
		
	Scanner sc = new Scanner(System.in);
	
	System.out.print("주민등록번호(-포함) : ");
	String str = sc.nextLine();
	
	char[] arr = new char[str.length()];
	
	for (int i = 0; i < arr.length; i++) {
		if (i >= 8) {
			arr[i] = '*';}
		else 
			arr[i] = str.charAt(i);
		System.out.print(arr[i]);
		
	}	
		
	}
	
	public void practice8(){
		
//		3이상인 홀수를 입력 받아 배열의 중간까지는 1부터 1씩 증가하여 오름차순으로 값을 넣고,
//		중간 이후부터 끝까지는 1씩 감소하여 내림차순으로 값을 넣어 출력하세요.
//		단, 입력한 정수가 홀수가 아니거나 3 미만일 경우 “다시 입력하세요”를 출력하고
//		다시 정수를 받도록 하세요.	
	
		Scanner sc = new Scanner(System.in);
		
		int num = 1;
		
		
		while(true) {
			System.out.print("정수 :");
		
			int input = sc.nextInt();
			
			if(input < 3 || input % 2 == 0) {
				
				System.out.println("다시 입력하세요");
			}
			else {
				
				int[] arr = new int[input]; 
			
			  for(int i = 0; i < arr.length; i++) {
				  
				  if(i < arr.length /2 ) {
					  arr[i] = num++;
				  }else {
					  arr[i] = num--;
				    
 				  }   
				  
				  if (i < arr.length - 1)
						System.out.print(arr[i] + ", ");
					else
						System.out.print(arr[i]);
				 
			  }
			   break;
			}
			
		}
		}
	
	public void practice9(){
		
//		10개의 값을 저장할 수 있는 정수형 배열을 선언 및 할당하고,
//		1~10 사이의 난수를 발생시켜 배열에 초기화한 후 출력하세요
//		
		int[] arr = new int[10];
		
		
//		for(int i = 0; i < arr.length; i++) {
//			int random = (int)(Math.random()*10+1);
//			arr[i] = random;
//			
//			}
//			
//			System.out.printf("발생한 난수 : %d %d %d %d %d %d %d %d %d %d",
//					arr[0],arr[1],arr[2],arr[3],arr[4],arr[5],arr[6],arr[7],arr[8],arr[9]);
//		
		System.out.print("발생한 난수 : ");
		for(int i = 0; i< arr.length; i++) {
			int random = (int)(Math.random()*10+1);
			arr[i] = random;
			System.out.print(arr[i] + " ");
			
		}
			
		
	
	}
	
	public void practice10( ) {
//		10개의 값을 저장할 수 있는 정수형 배열을 선언 및 할당하고,
//		1~10 사이의 난수를 발생시켜 배열에 초기화 후
//		배열 전체 값과 그 값 중에서 최대값과 최소값을 출력하세요.
		
		int[] num = new int[10];
		
		int max = num[0];
		int min = Integer.MAX_VALUE;
		System.out.print("발생한 난수 : ");
		for(int i = 0; i < num.length; i++) {
			num[i] = (int)(Math.random()*10+1);
			 
			
			if(num[i] > max) {
			  max = num[i];	
			
			}
			else if(num[i] < min) {
			  min = num[i]; 
			}
			System.out.print(num[i] + " ");
		}
		System.out.println();
		System.out.println("최대값 :" + max);
		System.out.println("최소값 :" + min);
		
	}
      
	public void practice11() {
		
//		10개의 값을 저장할 수 있는 정수형 배열을 선언 및 할당하고
//		1~10 사이의 난수를 발생시켜 중복된 값이 없게 배열에 초기화한 후 출력하세요. 
		 
		int[] arr = new int[10];
		
		for(int i = 0; i < arr.length; i++) {
			int random = (int)(Math.random()*10+1);
			arr[i] = random;
			
			for(int x =0; x < i; x++) {
				
				if(random == arr[x]) {
					
					i--;
					
					break;
				}
			}
		}
		
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
		 
		 
	 }
	
	 public void practice12() {
		 
//		 로또 번호 자동 생성기 프로그램을 만들기.
//		 (중복 값 없이 오름차순으로 정렬하여 출력하세요.)
		 
		 int[] lotto = new int[6];
		 
		 for(int i = 0; i < lotto.length; i++) {
			 int random = (int)(Math.random()*45+1);
			 
			 lotto[i] = random;
			 
			 for(int x = 0; x < i; x++) {
				 
				 if(random == lotto[x]) {
					 
					 i--;
					 break;
				 }
			 }
			 
			 
		 }
				
		 Arrays.sort(lotto);
		 
		 for(int i = 0; i < lotto.length; i++) {
			 
			 System.out.print(lotto[i] + " ");
		 }
		 
		 
		 
		 
		 
	 }
	 
	 public void practice13() {
//
//		 문자열을 입력 받아 문자열에 어떤 문자가 들어갔는지 배열에 저장하고
//		 문자의 개수와 함께 출력하세요.
//	 
	     Scanner sc = new Scanner(System.in);
	     
	     System.out.print("문자열 :");
	     String str = sc.nextLine();
	     
	     char[] arr = new char[str.length()];
	     int count = 0;
	     
	     System.out.print("문자열에 있는 문자 : ");
	     
	     for(int i = 0; i < arr.length; i++) {
	    	 arr[i] = str.charAt(i);
	    	 
	    	 boolean flag = true;
	    	 
	    	 for(int x = 0; x < i; x++) {
	    		 
	    		 if(arr[i] == arr[x]) {
	    			 flag = false;
	    			 
	    		 }
	    	 }
	    	 
	    	 if(flag == true) {
	    		 if(i == 0) {
	    		 System.out.print(arr[i]);
	    	 } else {
	    		 System.out.print("," + arr[i]);
	    		 
	    		 count++;
	    		 
	    	 }
	    	 
	    	 
	     }
		 
	 } 
	  System.out.println();   
      System.out.println("문자 개수 :" + count);
	
	 }
	 
	 public void practice14() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("배열의 크기를 입력하세요 :");
		int input = sc.nextInt();
		String[] str = new String[input];
	    sc.nextLine();
		
		int index = 0;
		
		while(true) {
			
			for (int i = index; i < str.length; i++) {
				System.out.print(i + 1 + "번째 문자열 :");
				str[i] = sc.nextLine();
				 
			}
			
			index = str.length;
			
			System.out.print("더 값을 입력하시겠습니까?(Y/N)");
			String num = sc.nextLine();
			
			if(num.equals("Y") || num.equals("y")) {
				System.out.print("더 입력하고 싶은 개수 : ");
				int input2 = sc.nextInt();
				String[] str2 = new String[str.length + input2];
				sc.nextLine();
				
				System.arraycopy(str, 0, str2, 0, str.length);
				str = str2;
				
			} else if (num.equals("n") || num.equals("N")) {
				System.out.println(Arrays.toString(str));
				break;
			
				
			} else {
				System.out.println("잘못 입력하셨습니다.");
			    continue;
			}
			
			
		}
		
		 
		 
		 
		 
		 
		 
		 
		 
		 
	 }
	 
	 public void practice15() {
		 
		 Scanner sc = new Scanner(System.in);
		 
		 System.out.print("배열의 크기를 입력하세요 : ");
		 int size = sc.nextInt();
		 sc.nextLine(); // 입력 버퍼 개행 문자 제거
		 
		 String[] arr = new String[size]; // 배열 선언 및 할당
		 
		 int start = 0; // while 내 for문의 초기식에 사용될 변수
		 
		 while(true) {
			 
			 for(int i=start; i < arr.length; i++) {
				 System.out.print((i+1) + "번째 문자열 : ");
				 arr[i] = sc.nextLine();
				 
			 }
			 
			 System.out.print("더 값을 입력하시겠습니까?(Y/N) : ");
			 char input = sc.nextLine().charAt(0);
			             // 입력 받은 문자열 중 제일 앞 문자 하나만 얻어옴
             
			 if(input =='Y' || input == 'y') {
				 
				 start = arr.length;
				 // 추가 입력 받기 위한 추가 배열의 시작 위치
				 
				 System.out.print("더 입력하고 싶은 개수 :");
				 int addSize = sc.nextInt();
				 sc.nextLine(); // 입력 버퍼 개행 문자 제거
				 
				 // 증가된 크기의 배열을 생성하여 arr 배열 깊은 복사
				 String[] copyArr = new String[arr.length + addSize];
				 
				 for(int i = 0; i < arr.length; i++) { // 기존 배열 크기 만큼만 반복
					 
					 copyArr[i] = arr[i]; // 복사 배열에 기존 배열 값을 같은 인덱스에 대입
					 
					 
					 
				 }
				 
				 // 배열 얕은 복사
				 arr = copyArr; // arr이 참조하는 주소 값을
				                // copyArr의 주소 값으로 바꿔서
				                // arr이 참조하는 배열의 크기가 증가한 것 처럼 보이게 함
				 
				 
			 } else { // y/n만 입력 했다는 상황을 가정
				 
				 break; // while 반복 종료
				 
				 
			 }
			 
			 
		 } // while 끝
		 
		 
		 System.out.println(Arrays.toString(arr));
		 
 		 
		 
		 
		 
		 
		 
		 
	 }
	
	 
	 
	 
	 
	 
	 
	 

}
