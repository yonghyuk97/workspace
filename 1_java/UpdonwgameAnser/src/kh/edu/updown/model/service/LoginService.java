package kh.edu.updown.model.service;

import java.util.Scanner;

import kh.edu.updown.model.vo.Member;

public class LoginService {
	
	private Scanner sc = new Scanner(System.in);

	// 업다운 게임 시작
	// 1 ~ 100 사이 숫자 중 랜덤하게 한 숫자를 지정하고 업/다운 게임을 진행
	// 맞춘 횟수가 현재 로그인한 회원의 최초 또는 최고 기록인 경우 회원의 highScore 필드 값을 변경
	public void startGame(Member loginMember) {
		
		System.out.println("[Game Start...]");
		
		int input = 0, answer = 0, count = 1;
		
		
		answer = (int)(Math.random()* 100+1);
		
		do {
			System.out.println(answer);
			System.out.print ("번째 입력 :");
			input = sc.nextInt();
			
			if(input > answer) {
				System.out.println("-- DOWN --");
				count++;
			} else if(input < answer) {
				System.out.println("-- UP --");
				count++;
			}
			
			
		
			
		}
		
		while(input != answer);
		
		System.out.println("정답!!");
		System.out.println("입력 시도 횟수 : " + count);
		loginMember.setHighScore(count);
//		if(loginMember.getHighScore() > count) {
//			System.out.println("*** 최고 기록 달성 ***");
//		}else{System.out.println("*** 최고 기록 달성을 위해 화이팅!***");}
		
		String result =loginMember.getHighScore() > count ? "*** 최고 기록 달성 ***" : "*** 기록달성을 위해 퐈이팅 ***";
		System.out.println(result);
		
	}

	
	
	


	// 내 정보 조회
	// 로그인한 멤버의 정보 중 비밀번호를 제외한 나머지 정보만 화면에 출력
	public void selectMyInfo(Member loginMember) {
		
		System.out.println("[내 정보 조회]");
		
		String str = "아이디 :" + loginMember.getMemberId();
		
	    str += "\n이름 :" + loginMember.getMemberName();
	     
	    str += "\n최고점수 :" + loginMember.getHighScore();
	     
	    System.out.println(str);
}

	// 전체 회원 조회
	// 전체 회원의 아이디, 이름, 최고점수를 출럭
	public void selectAllMember(Member[] members) {
		
		System.out.println("[전체 회원 조회]");
		
			if(members == null) {
				System.out.println("회원 정보가 없습니다");
				
			}
			
			for(int i = 0; i < members.length; i++) {
				
				System.out.println(members[i]);
			}
			
		
		
	}

	// 비밀번호 변경
	// 현재 비밀번호를 입력 받아 
	// 같은 경우에만 새 비밀번호를 입력 받아 비밀번호 변경
	public void updatePassword(Member loginMember) {
		
		System.out.println("[비밀번호 변경]");
		
		System.out.print("현재 비밀번호 입력 : ");
		String memberPw = sc.next();
		
		System.out.print("변경할 비밀번호 입력 : ");
		String memberPw2 = sc.next();
		
		if(memberPw.equals(loginMember.getMemberPw())) {
			
			loginMember.setMemberPw(memberPw2);
			System.out.println("비밀번호 변경이 완료되었습니다");
		} else { System.out.println("비밀번호가 다릅니다");}
		
	}
	

}
