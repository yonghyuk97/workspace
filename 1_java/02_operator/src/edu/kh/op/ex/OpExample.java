package edu.kh.op.ex;

import java.util.Scanner;

public class OpExample { // 예제 코드 작성용 클래스
	
	//  ex1() 메소드
	//  -> OpExample이 가지고 있는 기능 중 ex1()이라는 기능
	public void ex1() {
		
		
		// syso 작성 후 ctrl + space 누르면 출력구문 나옴
		System.out.println("OpExample 클래스에 ex1() 기능 수행");
		System.out.println("클래스 분리 테스트");
		System.out.println("println 자동완성 해봤어요~");
		
		
	}
	
	// ex2() 메소드(메소드라는건 기능이다)
    public void ex2() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수 입력 1 : ");
		int input1 = sc.nextInt(); // 다음 입력되는 정수를 읽어옴
			
		System.out.print("정수 입력 2 :");
		int input2 = sc.nextInt();
		
		System.out.printf("%d / %d = %d\n", input1, input2, input1 / input2);
		System.out.printf("%d %% %d = %d\n", input1, input2, input1 % input2);
		
	}
	
	public void ex3() {
		// 증감(증가, 감소)연산자 : ++, --
		// -> 피연산자(당하는 값)을 1 증가 또는 감소 시키는 연산자
		
		int iNum1 = 10;
		int iNum2 = 10;
		
		iNum1++;
		iNum2--;
		
		System.out.println("iNum1 : " + iNum1);
		System.out.println("iNum2 : " + iNum2);
		
		// 전위 연산 : ++3, --2 연산자가 앞쪽에 배치
		// - 다른 연산자보다 먼저 증가 / 감소
		
		int temp1 = 5;
		System.out.println(++temp1 + 5);
						// ++ 5  +  5
						//   6   +  5 == 11
		
		System.out.println("temp1 : " + temp1);
		
		
		// 후위 연산 : 10++, 6-- 연산자가 뒤쪽에 배치
		// - 다른 연산자보다 나중에 증가/감소
		int temp2 = 3;
		System.out.println( temp2 -- + 2);
						//   3--     + 2 == 5
						//  temp2 = 2; (1감소)
		
		System.out.println("temp2 : " + temp2);
		
		int a = 3;
		int b = 5;
		int c = a++ + --b;
		
		// (a)3++   +   --5(b)
		//c = (a)3++ + 4(b)
		//c = 7
		
		// 미뤄놨던 a 후위연산 a++ == 3+1 == 4
		
		// 최종적으로 a, b, c는 각각 얼마인가?
		System.out.printf("%d / %d / %d\n", a, b, c);
		
	}
	
	public void ex4() {
		
		//비교 연산자 : >, <, >=, <=, ==, !=
		// - 비교 연산자의 결과는 항상 논리값(true / false)
		// - 등호(=)가 포함된 연산자에서 등호는 항상 오른쪽!
		
		// 같다 기호는 =, == 어떤 것?
		// 같다 기호는 == 작성해 줍니다.
		// 왜? 등호 1개(=) 대입 연산자로 사용
		//		--> 구분을 위해서 두개(==)를 "같다"라는 의미로 사용한다.
		
		
		int a = 10;
		int b = 20;
		
		System.out.println(a > b); // false
		System.out.println(a < b); // true
		System.out.println(a != b); // true
		System.out.println(a == b); // false
		System.out.println((a == b) == false); // true
		
		System.out.println("---------------------------------");
		
		int c = 4;
		int d = 5;
		
		System.out.println(c < d); // true
		System.out.println(c + 1 <= d); // true
		//System.out.println((++c != d) == (--c != d)); // false
						// (++4 != 5) -> false
						// (--5 != 5) -> true
						// false == true
						// -> false
		
		System.out.println("---------------------------------");
		
		int temp = 723;
		
		System.out.println("temp는 짝수인가? " + (temp % 2 == 0) );
		System.out.println("temp는 짝수인가? " + (temp % 2 != 1) );
		
		System.out.println("temp는 홀수인가? " + (temp % 2 == 1) );
		System.out.println("temp는 홀수인가? " + (temp % 2 != 0) );
		
		System.out.println("temp는 3의 배수인가? " + (temp % 3 == 0));
		System.out.println("temp는 4의 배수인가? " + (temp % 4 == 0));
		System.out.println("temp는 5의 배수인가? " + (temp % 5 == 0));
		
	}
	
	public void ex5() {
		
		// 논리 연산자 : &&(AND) , ||(OR)
		
		// & = 앰퍼센트
		
		//&& = AND와 같다. 양쪽 다 true 일떄만 true
		
		//|(shift+백슬래쉬) | => 버티칼바 양쪽다 false 일떄만 false 이고 한쪽이 true 일때는 true 가 나온다
		
		// ex) && AND 연산자 => t && t == t  , t&&f == f  ,  f&&t == f , f&&f == f
		     // ~와, 그리고(~이고), ~면서, ~이면서, ~부터, ~까지, ~사이
		
		// ex) 사과와 바나나, 사과 그리고 바나나, 사과 이면서 바나나, 사과 부터 바나나
		
		int a = 100;
		
			
		// a는 100 이상 이면서 짝수인가? 
		System.out.println(" a는 100 이상인가? " + (a >= 100));// a는 100 이상인가?
		System.out.println(" a는 짝수인가? "+ (a % 2== 0)); //a 는 짝수?
		
		System.out.println(a >= 100 && a % 2 ==0);
		
		
		int b = 5;
		
		// b는 1부터 10까지 숫자 범위에 포함되어 있는가?
		// (b는 1부터 10 사이의 숫자인가?)
		// (b는 1보다 크거나 같으면서 10보다 작거나 같은가?)
		
		System.out.println(b >= 1); // b는 1 이상인가?
		
		System.out.println(b <= 10); // b는 10 이하인가?
		
		System.out.println(b >= 1 && b <= 10);
		
		System.out.println("------------------------");

		
		// ex) || OR 연산자 => t||t == t ,  t\\f == t , f||t = t , f||f = f
		
		// 또는, ~ 거나, ~이거나
		
		int c = 10;
		
		// c는 10을 초과 했거나 짝수인가?
		
		System.out.println(c < 10 || c % 2 == 0);
		
		
	}
	
	public void ex6() {
		
		// 논리 부정 연산자 : !
		// -> 논리 값을 반대로 바꾸는 연산자
		
		boolean bool1 = true;
		boolean bool2 = !bool1; // false
		
		System.out.println("bool1 : " + bool1); // true
		System.out.println("bool2 : " + bool2); // false
		
		System.out.println("-------------------------------");
		
		Scanner sc = new Scanner(System.in);
		
		// 정수를 하나 입력 받았을 때
		// 1) 해당 정수가 1부터 100 사이 값이 맞는지 확인 (1이상 100이하)
		// 2) (1번에서 했던거 반대 되는걸 물어보는 것) 1부터 100 사이 값이 아닌지 확인
		
		System.out.print("정수 입력 : ");
		int input = sc.nextInt();
		
		// 1 <= input <= 100
		boolean result1 = 1 <= input && input <= 100;
		
		System.out.printf("%d은/는 1이상, 100 이하의 정수인가? :%b\n", input, result1 );
		
		// 1 이상 이면서 100 이하  <-> 1 미만 또는 100 초과
		
		boolean result2 = (input < 1) || (input > 100);
		
		boolean result3 = !(1 <= input && input <= 100);
		
		System.out.printf("%d은/는 1미만, 100 초과 정수인가? %b / %b\n", input, result2, result3);
	}
	
	public void ex7() {
		
		//복합 대입 연산자 : +=, -=, *=, /=, %=
		// -> 피연산자가 자신과 연산 후 결과를 다시 자신에게 대입
		int a = 10;
		
		// a를 1 증가
		a++; // a = a + 1, a += 1
		
		System.out.println("a를 1증가 : " + a); //11
		
		// a를 4증가
		a += 4;
		System.out.println("a를 4증가 : " + a); // 15
		
		// a를 10감소
		a -= 10;
		System.out.println("a를 10감소 : " + a); // 5
		
		// a를 3배 증가
		a *= 3; 
		System.out.println("a를 3배 증가 : " + a); // 15
		// a를 6으로 나눴을 때 몫
		a /= 6;
		System.out.println("a를 6으로 나눴을 때  : " + a); // 2
		// a를 2로 나눴을 떄 나머지
		a %= 2;  // %= 나머지라는 기호
		System.out.println("a를 2로 나눴을 떄 나머지 : " + a); // 0
	
	
	}
	public void ex8() {
		
		// 삼항 연산자 : 조건식 ? 식1 : 식2
		
		// - 조건식의 결과가 true 이면 식 1,
		//   조건식의 결과가 false 이면 식2를 수행하는 연산자
		
		// * 조건식 : 연산 결과가 true / false인 식
		//			(비교, 논리, 논리 부정 연산이 포함)
		int num = 30;
		
		//num 이 30보다 크면(초과) : " num은 30보다 큰 수 이다."
		// 만약에 아니면 		   : " num은 이하의 수 이다." 출력
		
			
		String str1 = "num은 30보다 큰 수 이다.";
		String str2 = "num은 30 이하의 수 이다.";
		
		String result = num > 30 ? str1 : str2;
					//      조건식 ?  식1  :  식2
					//               t      f
		//num 값이 30을 초과하면 str1
		//num 값이 30을 초과하지 못하면 str2를
		//result 변수에 저장
		
		System.out.println(result);
		System.out.println("---------------------------------------------");
		
		//입력 받은 정수가 음수인지 양수인지 구분
		// 단 , 0은 양수로 처리
		
		// ex)
		// 정수 입력 : 4
		// 양수 입니다.
		
		// 정수 입력 : -5
		// 음수 입니다.
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수 입력 : ");
		int input = sc.nextInt();
		
		String str3 = "양수 입니다.";
		String str4 = "음수 입니다.";
		
		String result2 = input >= 0 ? str3 : str4;
		System.out.println(result2);
		
		
		
	}
	
}
