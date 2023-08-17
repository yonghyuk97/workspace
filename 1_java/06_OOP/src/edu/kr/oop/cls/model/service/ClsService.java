package edu.kr.oop.cls.model.service;

import edu.kr.oop.cls.model.vo.Student;
import edu.kr.oop.cls.model.vo.User;
//import edu.kr.oop.cls.model.vo.TestVO;
// The type edu.kr.oop.cls.model.vo.TestVO is not visible

public class ClsService /*extends Student*/{
	                     // 부모 Student를 상속 받음
	public void ex1() {
		
		  // 클래스 접근 제한자 확인하기
		
		  Student std = new Student();
		  // public class Student는 import 가능
		  
		  // TestVO test = new TestVO();
		  // (default) class TestVO는 import 불가 (다른 패키지)
		   
		  
		 System.out.println("다른 패키지");
		 System.out.println(std.v1);
		 // 다른 패키지에서도 접근 가능한 public만 에러x
		 
		 
		 //System.out.println(std.v2);
		 //System.out.println(std.v3);
		 //System.out.println(std.v4);
		 
		 
		 //  상속 관계에서 직접 접근 가능
		 //System.out.println(v1);
		 //System.out.println(v2); // protected 직접 접근 가능 
		 //System.out.println(v3);
		 //System.out.println(v4);
		
	}
	
	public void ex2() {
		
		
		// static 필드 확인 예제
		
		// 학생 객체 2개 생성
		
		Student std1 = new Student();
		Student std2 = new Student();
		
		// 학생 객체에 name 세팅

		std1.setName("김철수");
		std2.setName("이영희");
		
		// 정보 출력 
		System.out.println(std1.schoolName); // public 이기 때문에 직접 접근 가능
		System.out.println(std1.getName()); 
		
		System.out.println(std2.schoolName); // public 이기 때문에 직접 접근 가능
		System.out.println(std2.getName());
		
		// schoolName 변경
		std1.schoolName ="KH 정보교육원";
		System.out.println("변경 후 std1 : " + std1.schoolName);
		System.out.println("std2 : " + std2.schoolName); // KH고등학교 (X) -> KH정보교육원
		
		// std3 생성
		Student std3 = new Student();
		System.out.println("std3 : " + std3.schoolName);
		
		//schoolName에 노란줄이 뜨는 이유 -> 제대로 작성하지 않아서
		
		// *** static이 붙은 필드(변수)는 클래스명.변수명으로 사용함 
		
		System.out.println(std3.getName());
		
		
		Student.schoolName = "KH";
		System.out.println("Student.schoolName : " + Student.schoolName);
		
		/* static 
		 * 
		 * 1) 공유 메모리 영역 (또는 정적 메모리 영역) 이라고 함
		 * 
		 * why? 프로그램 시작 시 static이 붙은 코드들이 모두 
		 * static 영역에 생성되고,
		 * 프로그램이 종료될 때 까지 사라지지 않음. (정적)
		 * 그리고 static 영역에 생성된 변수는 어디서든지 공유할 수 있다. (공유)
		 * 
		 * 2) 사용 방법 : 클래스명.변수명
		 * 
		 * 
		 * 
		 * 
		 */
		
		
			
		}
		
	public void ex3() {
		// 생성자 확인 테스트            // 2.Student 객체가 생성된후
		                           // 기본 생성자에게 작성된 코드를 수행
		
		// Student 객체를 기본 생성자를 이용해 생성하고 이를 참조하는 참조변수 s1에 대입
		Student s1 = new Student();	
	                     // 기본 생성자
		
		     //1. Student 클래스를 보고
		     // Student 객체를 만들겠다.
		
		// User 기본 생성자를 이용해서 객체 생성
		User u1 = new User();
		
		// User 객체 필드 초기화 확인
		System.out.println( u1.getUserId());
		System.out.println( u1.getUserPw());
		System.out.println( u1.getUserName());
		System.out.println( u1.getUserAge());
		System.out.println( u1.getUserGender());
		
		// User 기본 생성자를 이용해서 객체 생성
		User u2 = new User();
		
		System.out.println( u2.getUserId());
		System.out.println( u2.getUserPw());
		System.out.println( u2.getUserName());
		System.out.println( u2.getUserAge());
		System.out.println( u2.getUserGender());
		
		// 문제점 : u1이 참조하고 있는 User객체와
		//        u2가 참조하고 있는 User 객체의 필드 값이 모두 동일함
		//         why? 같은 기본 생성자 User 객체를 생성 했기 때문에
		
		System.out.println("-----------------------------------");
		// 해결 방법 1 : setter를 이용해서 새로운 값을 대입
		
		u2.setUserId("asdf1234");
		u2.setUserPw("1qwerewqr");
		u2.setUserName("김철순");
		u2.setUserAge(19);
		u2.setUserGender('여');
		
		System.out.println( u2.getUserId());
		System.out.println( u2.getUserPw());
		System.out.println( u2.getUserName());
		System.out.println( u2.getUserAge());
		System.out.println( u2.getUserGender());
		
		
		
		
		//해결 방법 2 : 매개 변수 생성자를 이용해서
	    //            객체가 생성 될 떄 부터 다른 값으로 필드를 초기화
		
		
		User u3 = new User("test3","pass333"); // 매개변수 생성자
		                 // 생성자 수행 시 전달할 값을 작성 (순서 꼭 지켜야됨 !!)
		
		System.out.println( u3.getUserId());
		System.out.println( u3.getUserPw());
         		
	}
	
    public void ex4() { // 매개변수 생성자 예제
		
		User u1 = new User();// 기본 생성자
		User u2 = new User("user02" , "pass02");// 매개변수 2개 생성자
		User u3 = new User("user03" , "pass03" , "김수지" , 25 , '여');// 매개변수 5개 생성자
		User u4 = new User("user04" , "pass04" , "이한규" , 32 , '남');
		User u5 = new User("user05" , "pass05" , "박서준" , 38 , '남');
		
		System.out.printf("u1 : %s / %s / %s / %d / %c\n", 
        u1.getUserId(), u1.getUserPw(), u1.getUserName(),
        u1.getUserAge(), u1.getUserGender() );
  
        System.out.printf("u2 : %s / %s / %s / %d / %c\n", 
        u2.getUserId(), u2.getUserPw(), u2.getUserName(),
        u2.getUserAge(), u2.getUserGender() );
  
        System.out.printf("u3 : %s / %s / %s / %d / %c\n", 
        u3.getUserId(), u3.getUserPw(), u3.getUserName(),
        u3.getUserAge(), u3.getUserGender() );
  
        System.out.printf("u4 : %s / %s / %s / %d / %c\n", 
        u4.getUserId(), u4.getUserPw(), u4.getUserName(),
        u4.getUserAge(), u4.getUserGender() );
  
        System.out.printf("u5 : %s / %s / %s / %d / %c\n", 
        u5.getUserId(), u5.getUserPw(), u5.getUserName(),
        u5.getUserAge(), u5.getUserGender() );
		
	}
	

	
	
	
	
	
	
	
	
	

}
