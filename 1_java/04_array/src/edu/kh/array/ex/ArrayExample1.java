package edu.kh.array.ex;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayExample1 {
	
	/* 배열 (Array)
	 * - 같은 자료형의 변수를 하나의 묶음으로 다루는 것 (자료구조)
	 * - 묶여진 변수들은 하나의 배열명으로 불러지고
	 *   구분은 index를 이용함 (index는 0부터 시작하는 정수)
	 *   
	 * */
	
	public void ex1() {
		
		
		// 변수 vs 배열
		
		// 1-1. 변수 선언
		
		int num;
		// Stack 영역에 int 자료형을 저장 할 수 있는 공간 4byte를 생성(할당)하고
		// 그 공간에 num 이라는 이름을 부여
		
		
		// 1-2. 변수 대입
		num = 10;
		// 생성된 num이라는 변수 공간에 10을 대입
		
		// 1-3. 변수 사용
		System.out.println("num에 저장된 값 : " + num);
		
		// num이 작성괸 자리에 num에 저장된 값을 읽어와서 출력
		
		// ------------------------------------------------------------
		
		// 2-1. 배열 선언
		int[] arr;
		// Stack 영역에 int[] (int 배열) 자료형 공간을 8byte 할당하고
		// 그 공간에 arr 이라는 이름을 부여
		// *** 해당 변수는 참조형으로 주소 값(8byte)만을 저장할 수 있음
		
		// 2-2. 배열 할당
		arr = new int[3];
		
		// new : "new 연산자" 라고 하며
		//       Heap 메모리 영역에 새로운 공간(배열, 객체)을 할당
		
		// int[3] : int 자료형 변수 3개를 하나의 묶음으로 나타내는 배열
		
		// new int[3] : heap 영역에 int 3칸 짜리 int[] 생성(할당)
		              // ** 생성된 int[] 에는 시작 주소가 지정된다 !! **
		
		//  arr     =   new int[3];
		// (int[])     (int[])    -> 같은 자료형 == 연산 가능
		
		// heap 영역에 생성된 int[]의 시작 주소를
		// stack 영역에 생성된 arr 변수에 대입
		
		// -> arr 변수가 int[]을 참조하게 됨 !
		//   (그래서 arr을 참조형이라고 함)
		
		// 2-3. 배열 요소 값 대입
		// arr은 int[] 참조형 변수 이지만 
		// arr[0] int 자료형 변수이기 때문에 정수 값을 대입할 수 있다.
		
		arr[0] = 10;
		arr[1] = 50;
		arr[2] = 1000;
		
		
		// 2-4. 배열 요소 값 읽어오기
		
		System.out.println(arr[0]); // arr이 참조하고 있는 배열의 0번 인덱스 값을 얻어옴
		System.out.println(arr[1]); // arr이 참조하고 있는 배열의 1번 인덱스 값을 얻어옴
		System.out.println(arr[2]); // arr이 참조하고 있는 배열의 2번 인덱스 값을 얻어옴
		
		
		
	}
	
	public void ex2() {
	
		  // 배열 선언 및 할당
		  int[] arr = new int[4];
		  
		  // 1) stack 영역에 int[] 자료형 참조형 변수 arr 선언
		  // 2) heap 영역에 int 자료형 4개를 묶음으로 다루는 int[] 할당
		  // 3) 생성된 int[]의 주소를 arr에 대입하여 
		  //    참조하는 형태를 만든다.
		  
		  // 배열 길이(몇 칸 인가) : 배열명.length
		  
		  System.out.println("배열의 길이 : " + arr.length);
		
		  arr[0] = 100;
		  arr[1] = 200;
		  arr[2] = 500;
		  arr[3] = 1000;
		  
		  // 배열과 for 문
		  // i == index
		  
		  for(int i =0; i < arr.length; i++) {
			  // 0이상 arr 배열 길이 미만의 정수
			  
			  System.out.printf("arr[%d]에 저장된 값 : %d\n"  , i , arr[i]  );
			  
		  }
		
		
		
		
	}

	// (참고지만 알고있는게 좋음)
	
	// 비어있다 : stack 영역에 선언된 변수에 값이 대입되지 않음
	
	// null : 참조형 변수가 선언 되었으나 아무곳도 참조하지 않음
    //          (빈칸 아님 !!)
	
	// 0 : int 자료형 0 (확실히 존재하는 값)
	
	// "" : String 자료형이지만 내용 없음(빈 문자열)
	
	
	public void ex3() {
	  
	  // 5명의 키(cm)를 입력 받고 평균 구하기
	      
      // 1번 키 입력 : 170.5
      // 2번 키 입력 : 165.7
      // 3번 키 입력 : 184.3
      // 4번 키 입력 : 190.2
      // 5번 키 입력 : 174.4
      
      // 입력 받은 키 : 170.5  165.7  184.3  190.2  174.4
      // 평균 : 177.02cm
		
	  Scanner sc = new Scanner(System.in);
	  
	  double[] height = new double[5];
	  
	  // double[] 자료형 참조 변수 height를 stack 영역에 생성하고 
	  // heap 영역에 새로 생성된 double 5칸 짜리 double[]의 시작 주소를 대입
	  
	  for(int i =0; i < height.length; i++) {
		  System.out.print(i+1 +"번 키 입력 : " );
		  
		  height[i] = sc.nextDouble();
		  // 각 인덱스에 입력 받은 값을 대입(초기화)
	  }
	  
	  System.out.println(); // 줄 바꿈
	  
	  // 평균 = 합계 / 합계에 더해진 값의 수
	  
	  System.out.print("입력 받은 키:");

	  double sum = 0;
	  
	  for(int i = 0; i < height.length; i++) {
		  System.out.print(height[i] + " ");
		  
		  sum += height[i]; // 배열에 저장된 값을 sum에 누적
	  }
	  
	  System.out.printf("\n평균 : %.2f cm\n" , sum / height.length);
		
      
		
		
		
	}
	
	public void ex4() {
		
	  // 입력 받은 인원 수 만큼의 점수를 입력 받아 배열에 저장
      // 입력이 완료되면 점수 합계, 평균, 최고점, 최저점 출력
      
      // ex)
      // 입력 받을 인원 수 : 4
      // 1번 점수 입력 : 100
      // 2번 점수 입력 : 80
      // 3번 점수 입력 : 50
      // 4번 점수 입력 : 60
      
      // 합계 : 290
      // 평균 : 72.50
      // 최고점 : 100
      // 최저점 : 50
		
	  Scanner sc = new Scanner(System.in);
	  
	  System.out.print("입력 받을 인원 수 : ");
	  int input = sc.nextInt();
	  
	  // 배열 선언 및 할당
	  // 할당할 배열의 크기는 입력 받은 크기 만큼(input)
	  
	  int[] score = new int[input];
	  
	  int sum = 0; // 합계 저장용 변수
	  
	  
	  for(int i = 0; i < score.length; i++) {
		  System.out.print((i+1) + "번 점수 입력 : ");
		  score[i] = sc.nextInt();
		  
		  sum += score[i]; // 점수를 입력 받자 마자 sum에 누적
	  }
	  
	  // 최고 / 최저점 구하기
      int max = score[0]; 
      int min = score[0];
      // 아래 for문을 이용해서 score 배열에 있는 모든 값과 max, min을 비교
      // 이 때,
      // score[i] 값이 max 보다 크면 max에 대입
      // score[i] 값이 min 보다 작으면 min에 대입
		
      for(int i = 0; i < score.length; i++) {
    	  
    	  if(score[i] > max) {// 최고점 비교
    		  max = score[i];
    		  
    	  } else if(score[i] < min) {// 최저점 비교
    		  min = score[i];
    	  }
      }
      
      System.out.println("합계 :" + sum);
      
      System.out.printf("평균 : %.2f\n" , sum / (double)score.length);
      
      System.out.println("최고점 : " + max);
      System.out.println("최저점 : " + min);
		
		
		
		
		
	}
	
	public void ex5() {
		
		// 배열 선언과 동시에 초기화
		
		char[] arr = new char[5];
		
		// char[] arr이 참조하는 배열 요소에 A, B, C, D, E 대입하기
		
		for(int i=0; i < arr.length; i++) {
			arr[i] = (char)('A' + i);
			// A == 65
			// B == 66
			// C == 67
	       
           // System.out.print(arr[i]+ " ");
			
		}
		
		// ** Arrays 클래스
		// -> Java에서 제공하는 배열과 관련된 기능을 모아둔 클래스
		int[] arr2 = new int[4];
		System.out.println(arr2);
		
		// Arrays.toString(배열명) : 모든 요소 값을 출력
		System.out.println(Arrays.toString(arr2));
        System.out.println(Arrays.toString(arr));	
		
	  	// 배열 선언과 동시에 (할당 및 ) 초기화
        char[] arr3 = {'A' , 'B' , 'C' , 'D' , 'E'};
        
        // char[] 참조 변수 arr3를 선언하고 
        // heap 영역에 char 5칸 char[]을 생성하고
        // 각각 'A' , 'B' , 'C' , 'D' , 'E'로 초기화 후 주소를 arr3에 대입
        
        // {} (중괄호)는 배열의 리터럴 표기법
        
        System.out.println("arr3 길이 : " + arr3.length);
        System.out.println(Arrays.toString(arr3));
		
	}
	
	public void ex6() {
		
		// 점심 메뉴 뽑기 프로그램
		
		String[] arr = {"김밥" , "서브웨이" , "햄버거" , "백반", "국밥", "파스타"};
		
		// 0 ~ (배열길이 -1) 사이의 난수 발생 
		
		System.out.println("오늘 점심 메뉴 : " +  arr[(int)(Math.random()*6) ]);
		
		// 0.0 <= x < 1.0
		// 0.0 <= x * 6 < 6.0
		// 0 <- (int)(x * 6) < 6
		// -> 0 1 2 3 4 5
		
		
	
	
		}
	
	public void ex7() {
		
	   // 배열을 이용한 검색
		
	   // 입력 받은 정수가 배열에 있는지 없는지 확인
	   // 만약 있다면 몇번 인덱스에 존재하는지도 출력
	   
	   // int 배열 참조변수 arr을 선언하고 각각 인덱스에 100 200 300 ... 1000 값을 초기화 하시오
		
	   int[] arr = {100,200,300,400,500,600,700,800,900,1000};
		//            0                                  9
	   Scanner sc = new Scanner(System.in);
	   
	   System.out.print("정수 입력 : ");
	   int input = sc.nextInt();
	   
	   // 신호를 나타내기 위한 변수
	   // flag == false : 일치하는 값이 존재하지 않음
	   // flag == true : 일치하는 값이 존재
	   
	   boolean flag = false; // 검사 전에는 없다고 가정
	   
	   // arr 배열 요소 순차 접근 (반복 접근)
	   for(int i = 0; i < arr.length; i++) {
		   
		   // arr[i]에 저장된 값과 input이 같을 경우
		   
		   if(arr[i] == input) {
			   
			   System.out.println(i + "번째 인덱스에 존재");
			   
			   flag = true; // 일치하는 값이 있으므로 true로 변경
			   
		   }
			   
		   
		   
		   
		   
	   }
	   
	   // flag 상태를 검사
	   
	   if(flag == false) {
		   System.out.println("존재하지 않음");
	   }
	   
	   
		
	
	
	
	}
	
	
	public void ex8() {
		
		// 입력 받은 값과 일치하는 값이 있으면 인덱스 번호 출력
		// 없으면 " 존재하지 않음"
		
		
		String[] arr = {"사과" , "딸기" , "바나나" , "키위" , "멜론" , "아보카도"};
		
		boolean flag = false;
		
		Scanner sc = new Scanner(System.in);
		System.out.print("과일 입력 : ");
		String input = sc.nextLine();
		
		for(int i = 0; i < arr.length; i++) {
			
			if(arr[i].equals(input)) { // String 비교시 equals 사용
				
				System.out.println(i + "번 인덱스에 존재");
				
				flag = true;
			}
			
		}
		
		if(flag == false) {
			
			System.out.println("존재하지 않음");
		}
		
		
 		
		
		
		
		
		
	}
	
	public void ex9() {
		
		
		//1. 문자열을 입력 받아 한 글자씩 잘라내어 char 배열에 순서대로 저장
		
		//2. 문자 하나를 입력 받아 일치하는 문자가 char 배열에 몇개 존재하는지 확인
		
		//3. 단, 일치하는 문자가 없을 경우 " 존재하지 않습니다." 출력
		
		// [사용 해야되는 기술, 기능]
		// 1) 배열 검색
		// 2) String.legth() : 문자열의 길이
		//     ex) "Hello".legth() -> 5
		
		// 3) String.charAt(index) : 문자열에서 특정 index에 위치한 문자 하나를 얻어온다
		//     ex) "Hello".charAt(1) -> 'e'
		//          01234 (인덱스 번호)
		
		// 4) count (숫자 세기)
		
		
		Scanner sc = new Scanner(System.in);
		
		
		
		System.out.print("문자열 입력 :");
		
		String input = sc.nextLine(); // 한 줄(띄어쓰기 포함) 입력 받기
		
		//1. 문자열을 입력 받아 한 글자씩 잘라내어 char 배열에 순서대로 저장
		
		char [] arr = new char[input.length()];
		
		for(int i = 0; i < arr.length; i++) {
			
			arr[i] = input.charAt(i);
			// arr[i]에 입력 받은 문자열 중 i번째 문자를 대입
			
		}
		
		//중간 확인
		
//		System.out.println(arr);
		
		System.out.print("검색할 문자 입력: ");
		char ch = sc.nextLine().charAt(0);
		         // String.charAt(0) : 문자열 제일 앞 문자 얻어오기
		
		int count = 0; // 같은 글자 개수를 세기 위한 변수
		
		for(int i =0; i < arr.length; i++) {
			
			if(arr[i] == ch) {
				// arr[i] 값과 검색할 문자 ch가 같은 경우
				// -> 카운트
				count++;
				
				
				
			}
			
		}
		
		// 결과 출력 
		if(count > 0) {
			System.out.println(count + "개 있음");
			
			
		}else {
		   // 3. 단, 일치하는 문자가 없을 경우 "존재하지 않습니다." 출력
	       System.out.println("존재하지 않습니다");		
			
		}
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
}
