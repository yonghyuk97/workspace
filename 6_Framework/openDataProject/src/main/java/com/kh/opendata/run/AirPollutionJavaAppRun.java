package com.kh.opendata.run;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.kh.opendata.model.vo.Air;

public class AirPollutionJavaAppRun {

	// 발급받은 인증키 변수처리
	public static final String SERVICEKEY = "0cUp1WDc5csR7dKJ%2FiVSvuhVxKBv2SgCsLGyDk1xUwJ7k8LJpNCTJSRa3T4d9XjG9OYNBBKsnvIBOu%2BQKfl2ng%3D%3D";
	
	public static void main(String[] args) throws IOException { // UnsupportedEncodingException의 부모로 예외처리
		
		// OpenAPI 서버로 요청하고자 하는 url 작성
		String url = "http://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getCtprvnRltmMesureDnsty";
		url += "?serviceKey="+SERVICEKEY; // 서비스키가 재대로 부여되지 않았을 경우 =>SERVICE_KEY_IS_NOT_REGISTERED_ERROR
		url += "&sidoName=" + URLEncoder.encode("서울","UTF-8");
		url += "&returnType=json"; // 리턴타입
		url += "&numOfRows=2"; // 결과 개수
		
		// System.out.println(url);
		
		// ** HttpURLConnection 객체를 활용해서 OpenAPI 요청 절차 **
		
		// 1. 요청할 주소를 전달해서 java.net.URL 객체 생성하기
		URL requestUrl = new URL(url); 
		
		// 2. 생성된 URL 객체를가지고 HttpUrlConnection 객체 얻어내기
		HttpURLConnection urlConn = (HttpURLConnection)requestUrl.openConnection();
		
		// 3. 요청 시 필요한 Header 설정하기
		urlConn.setRequestMethod("GET");
		
		// 4. 해당 OpenAPI 서버로 요청 보낸 후 입력 스트림을 통해 응답데이터 받기
		BufferedReader br = new BufferedReader( new InputStreamReader( urlConn.getInputStream() ) );
		
		String responseText = "";
		String line;
		while( (line=br.readLine()) != null) { // 한 줄씩 읽어올 데이터가 있는 동안 반복
			// System.out.println(line);
			
			responseText += line;
			/*
		      {
		         "response":
		            {
		               "body":
		            {
		               "totalCount":40,
		               "items":
		                  [
		                      {
		                         "so2Grade":"1",
		                         "coFlag":null,
		                         "khaiValue":"52",
		                         "so2Value":"0.003",
		                         "coValue":"0.5",
		                         "pm10Flag":null,
		                         "o3Grade":"1",
		                         "pm10Value":"15",
		                         "khaiGrade":"2",
		                         "sidoName":"서울",
		                         "no2Flag":null,
		                         "no2Grade":"2",
		                         "o3Flag":null,
		                         "so2Flag":null,
		                         "dataTime":"2023-08-23 14:00",
		                         "coGrade":"1",
		                         "no2Value":"0.032",
		                         "stationName":"정릉로",
		                         "pm10Grade":"1",
		                         "o3Value":"0.029"
		                      },
		                      {
		                         "so2Grade":"1",
		                         "coFlag":null,
		                         "khaiValue":"-",
		                         "so2Value":"0.002",
		                         "coValue":"0.5",
		                         "pm10Flag":null,
		                         "o3Grade":"2",
		                         "pm10Value":"3",
		                         "khaiGrade":null,
		                         "sidoName":"서울",
		                         "no2Flag":null,
		                         "no2Grade":"1",
		                         "o3Flag":null,
		                         "so2Flag":null,
		                         "dataTime":"2023-08-23 14:00",
		                         "coGrade":"1",
		                         "no2Value":"0.013",
		                         "stationName":"도봉구",
		                         "pm10Grade":"1",
		                         "o3Value":"0.039"
		                         }, ...
		                      ]
		               }
		            }
		      }
		      */
			System.out.println(responseText);
			
			// JsonObject, JsonArray 이용해서 파실할 수 있음 (gson 라이브러리)
			
			// json 데이터를 원하는 데이터만 추출하여 VO에 담기
			// 응답데이터 text를 JsonObject화 시키는 작업 필요 (파싱)
			JsonObject totalObj =  JsonParser.parseString(responseText).getAsJsonObject();
			// System.out.println("total : " + totalObj);
			
			// response 속성 접근
			JsonObject responseObj =totalObj.getAsJsonObject("response");
			// System.out.println("response :" + responseObj);
			
			// body 속성 접근
			JsonObject bodyObj = responseObj.getAsJsonObject("body");
			// System.out.println("body :" + bodyObj);
			
			// totalCount 속성 접근
			int totalCount = bodyObj.get("totalCount").getAsInt();
			// System.out.println("totalCount : " + totalCount);
			
			// items(JsonArray형태) 속성 접근
			JsonArray itemArr = bodyObj.getAsJsonArray("items");
			// System.out.println("itemArr : " + itemArr);
			
			ArrayList<Air> list = new ArrayList<>();
			
			for(int i = 0; i < itemArr.size(); i++) {
				// items에 담겨있는 item객체 하나씩 추출
				
				JsonObject item = itemArr.get(i).getAsJsonObject();
				// System.out.println(item);
				
				Air air = new Air();
				
				air.setStationName(item.get("stationName").getAsString()); //측정소명
				air.setDataTime(item.get("dataTime").getAsString()); //측정일시
				air.setKhaiValue(item.get("khaiValue").getAsString()); //통합대기환경수치
				
				air.setPm10Value(item.get("pm10Value").getAsString()); //미세먼지농도
				air.setSo2Value(item.get("so2Value").getAsString()); //아황산가스농도
				air.setCoValue(item.get("coValue").getAsString()); //일산화탄소농도
				air.setNo2Value(item.get("no2Value").getAsString()); //이산화질소농도
				air.setO3Value(item.get("o3Value").getAsString()); //오존농도
				
				list.add(air);
				
				
			}
			// list에 담긴 VO객체확인
			for(Air a :list) {
				System.out.println(a);
			}
		}	
			
		// 5. 다 사용한 스트림 객체 반납하기
		br.close();
		urlConn.disconnect();
		
	}
	
}
