package com.kh.opendata.model.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class clean {
	
		
	   //필드
	   private String resultCode; // 결과코드
	   private String resultMsg; // 결과 메세지
	   private String items; // 목록
	   
	   private String dataTime; // 통보시간
	   private String informCode; // 통보코드
	   private String infornOverall;// 예보개황
	   private String informCause;// 발생원인
	   private String informGrade;// 예보등급
	   private String actionKnack;// 행동강령
	   private String informData;// 예보통보시간
		   
}


