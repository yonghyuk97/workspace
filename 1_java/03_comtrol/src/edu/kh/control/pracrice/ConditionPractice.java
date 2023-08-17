package edu.kh.control.pracrice;

import java.util.Scanner;

public class ConditionPractice {
	
	 public void practice1() {
//		 키보드로 입력 받은 정수가 양수이면서 짝수일 때만 “짝수입니다.”를 출력하고
//		 짝수가 아니면 “홀수입니다.“를 출력하세요.
//		 양수가 아니면 “양수만 입력해주세요.”를 출력하세요
		 Scanner sc = new Scanner(System.in);
		 System.out.println("숫자를 한개 입력하세요");
		 int input = sc.nextInt();
		 
		 String str;
		 
		 if (input >0 && input % 2 == 0) {
			 str = ("짝수 입니다");
			 
		 }else if(input < 0) {
			 str = "양수만 입력해주세요";
		 }else {
			 str = "홀수 입니다";
		 }
		  System.out.println(str);
		
	}
	 public void practice2() {
//		 국어, 영어, 수학 세 과목의 점수를 키보드로 입력 받고 합계와 평균을 계산하고
//		 합계와 평균을 이용하여 합격 / 불합격 처리하는 기능을 구현하세요.
//		 (합격 조건 : 세 과목의 점수가 각각 40점 이상이면서 평균이 60점 이상일 경우)
//		 합격 했을 경우 과목 별 점수와 합계, 평균, “축하합니다, 합격입니다!”를 출력하고
//		 불합격인 경우에는 “불합격입니다.”를 출력하세요. 
		 Scanner sc = new Scanner(System.in);
		 
		 System.out.print(" 국어점수 :");
		 int input = sc.nextInt();
		 
		 System.out.print(" 수학점수 :");
		 int input1 = sc.nextInt();
		 
		 System.out.print(" 영어점수 :");
		 int input2 = sc.nextInt();
		 
		 int sum = input + input1 + input2;
		 float avg = (input + input1 + input2) / 3;
		 
		 
		 
		 if (input >=40 && input1 >= 40 && input2 >=40 && avg >= 60 ) {
			 System.out.println("국어 :" + input);
			 System.out.println("수학 :" + input1);
			 System.out.println("영어 :" + input2);
			 System.out.println("합계 :" + sum);
			 System.out.println("평균 :" + avg);
			 System.out.println("축하합니다, 합격입니다!");
		 } else {
			 System.out.println(" 불합격입니다.");
		 }
		 
		 
		 
	 }
	 public void practice3() {
//		 1~12 사이의 수를 입력 받아 해당 달의 일수를 출력하세요.(2월 윤달은 생각하지 않습니다.)
//		 잘못 입력한 경우 “OO월은 잘못 입력된 달입니다.”를 출력하세요. (switch문 사용) 
		
		 Scanner sc = new Scanner(System.in);
		 System.out.println("월 입력 : ");
		 int input = sc.nextInt();
		 
		 String result;
		 // 1,3,5,7,8,10,12 =  31
		 // 4 ,6, 9, 11 = 30
		 // 2 = 28
		 switch(input) {
		 
		 case 1 : case 3: case 5 : case 7 : case 8 : case 10 : case 12 :
			 result = "31일 까지 있습니다"; break;
		 case 4 : case 6: case 9 : case 11 :
			 result = "30일 까지 있습니다"; break;
		 case 2 :
			 result = "28일 까지 있습니다"; break;
		 default : 
			 result = input + "월은 잘못 입력된 달입니다";
			 
			 
		 } System.out.println(result);
		 
		 
		 
		 
	 }
	 public void practice4() {
//		 키, 몸무게를 double로 입력 받고 BMI지수를 계산하여 계산 결과에 따라
//		 저체중/정상체중/과체중/비만을 출력하세요.
//		 BMI = 몸무게 / (키(m) * 키(m))
//		 BMI가 18.5미만일 경우 저체중 / 18.5이상 23미만일 경우 정상체중
//		 BMI가 23이상 25미만일 경우 과체중 / 25이상 30미만일 경우 비만
//		 BMI가 30이상일 경우 고도 비만

		 Scanner sc = new Scanner(System.in);
		 
		 System.out.println("키(m)을 입력해 주세요");
		 double  height = sc.nextDouble();
		 System.out.println("몸무게 (kg)를 입력해 주세요");
		 double  weight = sc.nextDouble();
		 
		 double bmi = weight / (height * height);
		 String str;
		 
		 System.out.println("BMI 지수 : " + bmi);
		 
		 if(bmi < 18.5) {
			 str ="저체중";
			 
		 } else if(bmi < 23 ) {
			 str ="정상체중";
		 
		 } else if(bmi < 25) {
			 str ="과체중";
		 
		 } else if(bmi < 30) {
			 str ="비만";
		 
		 } else { str = "고도 비만"; }
		 
		 System.out.println(str);
		 
		 
	 }
	 public void practice5() {
		 
//		 중간고사, 기말고사, 과제점수, 출석횟수를 입력하고 Pass 또는 Fail을 출력하세요.
//		 평가 비율은 중간고사 20%, 기말고사 30%, 과제 30%, 출석 20%로 이루어져 있고
//		 이 때, 출석 횟수는 총 강의 횟수 20회 중에서 출석한 날만 따진 값으로 계산하세요.
//		 70점 이상일 경우 Pass, 70점 미만이거나 전체 강의에 30% 이상 결석 시 Fail을 출력하세요.
		 
		 Scanner sc = new Scanner(System.in);
		 
		 System.out.print("중간 고사 점수 : ");
		 double midTerm = sc.nextDouble();
		 
		 System.out.print("기말 고사 점수 : ");
		 double finalTerm = sc.nextDouble();
		 
		 System.out.print("과제 점수 : ");
		 double homework = sc.nextDouble();
		 
		 System.out.print("출석 횟수 : ");
		 double attendance = sc.nextDouble();
		 
		 System.out.println("================= 결과 =================");
		 
		 if(attendance <= 20 * (1 - 0.3)) { // 30% 이상 결석 <-> 70% 미만 출석
			 System.out.println("Fail [출석 횟수 부족 (" + (int)attendance + "/20)]");
		 } else {
			 
			 midTerm *= 0.2;
			 finalTerm *= 0.3;
			 homework *= 0.3;
			 attendance *= 5 * 0.2;
			 
			 // 합계
			 double sum = midTerm + finalTerm + homework + attendance;
			 
			 System.out.printf("중간 고사 점수(20) : %.1f\n" , midTerm);
			 System.out.printf("기말 고사 점수(30) : %.1f\n" , finalTerm);
			 System.out.printf("과제 점수(20) : %.1f\n" , homework);
			 System.out.printf("출석 점수(20) : %.1f\n" , attendance);
			 System.out.printf("총점 : %.1f\n" , sum);
			 
			 if(sum >= 70) {
				 System.out.println("PASS");
			 } else {
				 System.out.println("Fail [점수미달]");
			 }
		 }
		  
		
		 
		 
	 }     

}
