package edu.kh.project;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class mainController {
	
	public static final String SERVICEKEY = "0cUp1WDc5csR7dKJ%2FiVSvuhVxKBv2SgCsLGyDk1xUwJ7k8LJpNCTJSRa3T4d9XjG9OYNBBKsnvIBOu%2BQKfl2ng%3D%3D";
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	
	@RequestMapping(value = "test", produces = "text/xml; charset=UTF-8")
	@ResponseBody
	public String test() throws IOException {

		
		String url = "http://apis.data.go.kr/1741000/TsunamiShelter3/getTsunamiShelter1List";
		url += "?serviceKey="+SERVICEKEY;
		url += "&pageNo=1"; 
		url += "&type=xml";
		url += "&numOfRows=2"; 

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

}
