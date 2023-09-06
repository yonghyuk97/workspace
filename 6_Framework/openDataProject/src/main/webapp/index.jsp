<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>대기오염 공공데이터</title>
<script src="https://code.jquery.com/jquery-3.7.0.min.js" integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>
<script src ="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<body>
   
	<h1>실시간 대기오염 정보</h1>
	
	지역 :
	
	<select id="location">
      <option>서울</option>
      <option>대구</option>
      <option>경기</option>
   </select>
   
   <button id="btn1">해당 지역 대기 오염 정보</button>
   <br><br>
   
   <table border="1" id="result1">
      <thead>
         <tr>
            <th>측정소명</th>
            <th>측정일시</th>
            <th>통합대기환경수치</th>
            <th>미세먼지농도</th>
            <th>아황산가스농도</th>
            <th>일산화탄소농도</th>
            <th>이산화탄소농도</th>
            <th>오존농도</th>
         </tr>
      </thead>
      <tbody></tbody>
   </table>
	
	<script>
      $(function(){
         $("#btn1").click(function(){
         
            $.ajax({
               url : "air",
               data : {"location": $("#location").val()},
               success : function(data){
                  console.log(data);
                  console.log(data.response.body.items);

                  const itemArr = data.response.body.items;
                  
                  let value = "";
                  for(let item of itemArr){
                     console.log(item);
                     value += "<tr>" 
                        + "<td>" + item.stationName + "</td>" 
                        + "<td>" + item.dataTime + "</td>" 
                        + "<td>" + item.khaiValue + "</td>" 
                        + "<td>" + item.pm10Value + "</td>" 
                        + "<td>" + item.so2Value + "</td>" 
                        + "<td>" + item.coValue + "</td>" 
                        + "<td>" + item.no2Value + "</td>" 
                        + "<td>" + item.o3Value + "</td>"
                        + "</tr>"; 
                  }
                  
                  $("#result1 > tbody").html(value);


               }, error : function(){
                  
                  console.log("통신 실패");
               }
            })
       
/*
            //--------------------------------------------------------------
            // 응답 데이터를 xml 형식으로 받을 때
            $.ajax({
               url : "air",
               data : {location : $("#location").val()},
               success : function(result){
                  console.log(result);

                  // $('요소명').find(매개변수)
                  // - 기준이 되는 요소의 하위 요소들 중 특정 요소를 찾을 때 사용
                  // - html, xml은 같은 markup language이기 떄문에 사용 가능하다.
                  // console.log($(result).find("item"));

                  // xml형식의 응답데이터를 받았을 때
                  // 1. 넘겨받은 데이터를 $() 제이쿼리화 시킨 후
                  //    응답 데이터 안에 실제 데이터가 담겨있는 요소 선택
                  const itemArr = $(result).find("item");
                  
                  const add = document.getElementsByTagName("tbody")[0];
                  console.log(add);
                  
                  let value;
                  // 2. 반복문을 통해 실제 데이터가 담긴 요소들에 접근해서 동적으로 요소 만들기
                  itemArr.each(function(index, item){
                     // console.log(item);
                     console.log($(item).find("stationName").text());

                     value += "<tr>" 
                        + "<td>" + $(item).find("stationName").text()   + "</td>" 
                        + "<td>" + $(item).find("dataTime").text()      + "</td>" 
                        + "<td>" + $(item).find("khaiValue").text()     + "</td>" 
                        + "<td>" + $(item).find("pm10Value").text()     + "</td>" 
                        + "<td>" + $(item).find("so2Value").text()      + "</td>" 
                        + "<td>" + $(item).find("coValue").text()       + "</td>" 
                        + "<td>" + $(item).find("no2Value").text()      + "</td>" 
                        + "<td>" + $(item).find("o3Value").text()       + "</td>" 
                        + "</tr>"; 
                  })
                  
                  // 3. 동적으로 만들어낸 요소를 화면에 출력
                  $("#result1 > tbody").html(value);

               },
               error : function(){
                  console.log("통신 실패");
               }
            })

            */
         })
      })

      
   </script>
	
   <hr>
   
   <h1>실시간 지진해일 긴급 대피장소</h1>
   
   <button id="btn2">실시간 지진해일 긴급 대피장소 정보</button>
   <br><br>
   
   <table border="1" id="result2">
      <thead>
         <tr>
            <th>시도명</th>
            <th>시군구명</th>
            <th>대피지구명</th>
            <th>대피장소명</th>
            <th>주소</th>
            <th>경도</th>
            <th>위도</th>
            <th>수용가능인원수</th>
            <th>대피소 분류명</th>
         </tr>
      </thead>
      <tbody></tbody>
   </table>

   <script>

      $(function(){
         $("#btn2").click(function(){
            $.ajax({
               url : "place",
               success:function(data){
            	   const itemArr = $(data).find("row");

                   let value;
                   itemArr.each(function(index, item){
                      console.log($(item).find("row").text());

                      value += "<tr>" 
                         + "<td>" + $(item).find("sido_name").text()   + "</td>" 
                         + "<td>" + $(item).find("sigungu_name").text()      + "</td>" 
                         + "<td>" + $(item).find("remarks").text()     + "</td>" 
                         + "<td>" + $(item).find("shel_nm").text()     + "</td>" 
                         + "<td>" + $(item).find("address").text()      + "</td>" 
                         + "<td>" + $(item).find("lon").text()       + "</td>" 
                         + "<td>" + $(item).find("lat").text()      + "</td>" 
                         + "<td>" + $(item).find("shel_av").text()       + "</td>" 
                         + "<td>" + $(item).find("shel_div_type").text()       + "</td>" 
                         + "</tr>"; 
                   })
                   
                   // 3. 동적으로 만들어낸 요소를 화면에 출력
                   $("#result2 > tbody").html(value);
               },
               error:function(){
                  console.log("통신오류");
               }
            })
         })
      })

   </script>

  <hr>
   
  <h1>초미세먼지 주간 예보</h1>
  
  <button id="btn3">통보코드와 통보시간으로 예보정보와 발생 원인 정보를 조회하는 대기질(미세먼지/오존) 예보통보 조회</button>
  <br><br>
  
  <table border="1" id="result3">
     <thead>
        <tr>
           <th>결과코드</th>
           <th>결과메세지</th>
           <th>목록</th>
           <th>통보시간</th>
           <th>통보코드</th>
           <th>예보개황</th>
           <th>발생원인</th>
           <th>예보등급</th>
           <th>행동요령</th>
           <th>예측통보시간</th>
        </tr>
     </thead>
     <tbody></tbody>
  </table>

  <script>

   document.getElementById("btn3").addEventListener("click",()=>{

      fetch("/clean")
      .then(resp => resp.json())
      .then(result =>{
         const Alist = $(result).find("items");
         console.log(Alist);
      })
      .catch(err => {
         console.log(err)
      })
   })

   const add = document.getElementsByTagName("tbody")[0];

  </script>

    <hr>
   
   <h1>실시간 지진해일 긴급 대피장소</h1>
   
   <button id="btn4">실시간 지진해일 긴급 대피장소 정보</button>
   <br><br>
   
   <table border="1" id="result5">
      <thead>
         <tr>
            <th>시도명</th>
            <th>시군구명</th>
            <th>대피지구명</th>
            <th>대피장소명</th>
            <th>주소</th>
            <th>경도</th>
            <th>위도</th>
            <th>수용가능인원수</th>
            <th>대피소 분류명</th>
         </tr>
      </thead>
      <tbody></tbody>
   </table>


   <script>

      $("#btn4").click(function(){
         console.log("왜 안되는 거냐 ?");
      })


      $(function(){
         $("#btn4").click(function(){
            $.ajax({
              url:"test",
              success:function(data){
               console.log(data);
              },
              error:function(){
               console.log("통신 장애");
              }
            })
         })
      })

   </script>


</body>
</html>