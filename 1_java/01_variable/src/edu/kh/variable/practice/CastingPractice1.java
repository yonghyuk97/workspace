package edu.kh.variable.practice;

public class CastingPractice1 {

	public static void main(String[] args) {
  // 선언 및 초기화된 5개의 변수를 가지고 알맞은 사칙연산(+,-,*,/)과 형변환을 이용하여 추석에 
  //작성되 값과 같은 결과가 나타나도록 코드를 완성하세요.
	   int iNum1 = 10;
	   int iNum2 = 4;
	   
	   float fNum = 3.0f;
	   
	   double dNum = 2.5;
	   
	   char ch = 'A';
	   
	   System.out.println(iNum1 / iNum2); //2
	   System.out.println((int)dNum); //2
	   
	   System.out.println(iNum2 *dNum); // 10.0
	   System.out.println((float)(iNum1)); // 10.0
	   
	   System.out.println((iNum1 / (float)iNum2)); // 2.5
	   System.out.println((double)dNum); // 2.5
	   
	   System.out.println((int)fNum); //3
	   System.out.println(iNum1/(int) fNum); //3
	   
               // float / double 차이점 
            

	   System.out.println(iNum1 / fNum); // 3.3333333
	   System.out.println((double)iNum1 /fNum); // 3.3333333333333333
	   
	   // float : 소수점 아래 8번째 자리까지 연산 후 반올림
               // double : 소수점 아래 16번쨰 자리까지 연산 후 반올림
              		

	   System.out.println("'"+ch+"'"); // 'A'
	   System.out.println((int)(ch)); //65
	   System.out.println(ch +iNum1); //75
	   System.out.println((char)(ch +iNum1)); //'k'
	   
	   
	   
	   
		
	}

}
