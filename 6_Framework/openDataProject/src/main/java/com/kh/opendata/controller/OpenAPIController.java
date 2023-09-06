package com.kh.opendata.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.opendata.model.vo.clean;

@Controller
public class OpenAPIController {


	public static final String SERVICEKEY = "0cUp1WDc5csR7dKJ%2FiVSvuhVxKBv2SgCsLGyDk1xUwJ7k8LJpNCTJSRa3T4d9XjG9OYNBBKsnvIBOu%2BQKfl2ng%3D%3D";
	

	@ResponseBody
	@RequestMapping(value= "air.do", produces = "application/json; charset=UTF-8")
	public String airMethod(String location) throws IOException {
		

		String url = "http://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getCtprvnRltmMesureDnsty";
		url += "?serviceKey="+SERVICEKEY; 
		url += "&returnType=xml"; 
		url += "&sidoName=" + URLEncoder.encode(location, "UTF-8"); 
		
		URL requestUrl = new URL(url);
		HttpURLConnection urlConn = (HttpURLConnection)requestUrl.openConnection();
		urlConn.setRequestMethod("GET");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));
		
		String responseText = "";
		String line;
		while((line=br.readLine()) !=null) {
			responseText += line;
		}
		
		br.close();
		urlConn.disconnect(); 
		
		return responseText;
	}
	
	// xml 형식으로 대기오염 OpenAPI 활용하기
	//@RequestMapping(value = "air", produces = "text/xml; charset=UTF-8")
	@ResponseBody
	public String airPollution(String location) throws IOException {
		
		String url = "http://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getCtprvnRltmMesureDnsty";
		url += "?serviceKey="+SERVICEKEY; // 서비스키가 추가
		url += "&sidoName=" + URLEncoder.encode(location, "UTF-8"); // 지역명 추가(한글이 들어가면 인코딩 처리 해야함)
		url += "&returnType=xml"; // return 타입
		url += "&numOfRows=20"; // 결과 개수
		
		// 1. 작성된 url 정보를 넣어서 url 객체 생성
		URL requestUrl = new URL(url);
		
		// 2. 생성된 URL 객체로 URLConnection 생성
		HttpURLConnection urlConn = (HttpURLConnection)requestUrl.openConnection();
		
		// 3. 요청시 필요한 Header 설정
		urlConn.setRequestMethod("GET");
		
		String responseText = "";
		String line;
		// 4. 해당 OpenAPI 서버로 요청 후 입력 스트림을 통해서 응답데이터 읽어오기
		BufferedReader br =new BufferedReader(new InputStreamReader(urlConn.getInputStream()));
		
		while((line=br.readLine()) != null) {
			responseText += line;
		}
		
		
		// 5. 다 사용한 스트림 반납 및 연결 해제
		br.close();
		urlConn.disconnect();
		
		
		return responseText;
	}
	
	// xml 형식으로 지진 해일 대피소 OpenApi 활용하기
	// @RequestMapping(value = "place", produces = "text/xml; charset=UTF-8")
	@ResponseBody
	public String test() throws IOException {
		
		String url = "http://apis.data.go.kr/1741000/TsunamiShelter3/getTsunamiShelter1List";
		url += "?serviceKey="+SERVICEKEY; // 서비스키가 추가
		url += "&pageNo=1"; 
		url += "&type=xml"; // return 타입
		url += "&numOfRows=2"; // 결과 개수
		
		URL request = new URL(url);
		
		HttpURLConnection connection = (HttpURLConnection)request.openConnection();
		
		connection.setRequestMethod("GET");
		
		String result = "";
		String line;
		
		BufferedReader br =new BufferedReader(new InputStreamReader(connection.getInputStream()));
		
		while((line=br.readLine()) != null) {
			result += line;
				
		}
		br.close();
		connection.disconnect();
		
		return result;

	}
	
	@RequestMapping(value="clean", produces = "application/json; charset=UTF-8" )
	@ResponseBody
	public String cleanUp() throws IOException{
		
		String url = "http://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getMinuDustFrcstDspth";
		url += "?serviceKey=" + SERVICEKEY;
		url += "&returnType=json";

		URL requestUrl = new URL(url);
		
		HttpURLConnection urlConn = (HttpURLConnection)requestUrl.openConnection();
		
		urlConn.setRequestMethod("GET");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));
		
		String responseText = "";
		String line = "";
		
		while((line = br.readLine()) != null) {
			
			responseText += line;
		}
		
		br.close();
		urlConn.disconnect();
		
				
		return responseText;
	}
	
	@RequestMapping(value="test", produces = "text/xml; charset=UTF-8")
	@ResponseBody
	public String test2() throws IOException{
		
		
		String url = "http://apis.data.go.kr/1741000/TsunamiShelter3/getTsunamiShelter1List";
		url += "?serviceKey=" + SERVICEKEY;
		url += "&pageNo=1";
		url += "&nomOfRows=10";
		url += "&type=xml";
		
		URL testUrl = new URL(url); 
		
		
		HttpURLConnection testUrlConnection = (HttpURLConnection)testUrl.openConnection();
		
		testUrlConnection.setRequestMethod("GET");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(testUrlConnection.getInputStream()));
		
		String resultpass = "";
		String line = "";
		
		while((line = br.readLine()) != null) {
			resultpass += line;
		}
		
		System.out.println(resultpass);
		
		br.close();
		testUrlConnection.disconnect();
		
		
		return resultpass;
	}

	
}
