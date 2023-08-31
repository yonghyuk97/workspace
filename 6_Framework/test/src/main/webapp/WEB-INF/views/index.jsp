<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>

</head>
<body>

<h1>테스트</h1>
   
   <button id="btn">버튼</button>

   <table border="1" id="result">
      <thead> 
         <tr> 
            <th>일련번호</th>
            <th>시도명</th>
            <th>시군구명</th>
            <th>대피지구명</th>
            <th>대피장소명</th>
            <th>주소</th>
            <th>경도</th>
            <th>위도</th>
            <th>수용가능인원수</th>
            <th>해변으로부터거리</th>
            <th>대피소 분류명</th>
            <th>해발높이</th>
         </tr>
      </thead>
      <tbody></tbody>
   </table>

   <script>
      $(function(){
         $("#btn").click(function(){
            $.ajax({
               url : "test",
               success:function(result){
            	   const testArr = $(result).find("row");

                   let value;
                   testArr.each(function(index, key){

                      value += "<tr>" 
                    	 + "<td>" + $(key).find("id").text()   + "</td>" 
                         + "<td>" + $(key).find("sido_name").text()   + "</td>" 
                         + "<td>" + $(key).find("sigungu_name").text()      + "</td>" 
                         + "<td>" + $(key).find("remarks").text()     + "</td>" 
                         + "<td>" + $(key).find("shel_nm").text()     + "</td>" 
                         + "<td>" + $(key).find("address").text()      + "</td>" 
                         + "<td>" + $(key).find("lon").text()       + "</td>" 
                         + "<td>" + $(key).find("lat").text()      + "</td>" 
                         + "<td>" + $(key).find("shel_av").text()       + "</td>" 
                         + "<td>" + $(key).find("lenth").text()       + "</td>" 
                         + "<td>" + $(key).find("shel_div_type").text()       + "</td>" 
                         + "<td>" + $(key).find("height").text()       + "</td>" 
                         + "</tr>"; 
                   })
                   
                   $("#result > tbody").html(value);
               },
               error:function(){
                  console.log("통신오류");
               }
            })
         })
      })
   </script>
</body>
</html>