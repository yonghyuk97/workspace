// 좋아요 버튼이 클릭 되었을 때 
const boardLike = document.getElementById("boardLike");

boardLike.addEventListener("click",e => {
    
    // 로그인 여부 검사
    if(loginMemberNo == ""){
        alert("로그인 후 이용해주시기 바랍니다.");
        return;
    }
    
    let check; // 기존에 좋아요 X(빈하트)    : 0
               // 기존에 좋아요 O(꽉찬하트)  : 1

    // contains("클래스명") : 클래스가 있으면 true, 없으면 false
    if(e.target.classList.contains("fa-regular")){ // 좋아요 X(빈하트)
        check = 0;
    }else{ // 좋아요 O(꽉찬하트)
        check = 1;
    }

    const data = {"memberNo":loginMemberNo, "boardNo" : boardNo, "check" : check}

    // ajax 코드 작성
    fetch("/board/like", {
        method : "POST" ,
        headers : {"content-Type" : "application/json"},
        body : JSON.stringify(data)
    })
    .then(resp => resp.text()) // 응답 객체를 필요한 형태로 파싱하여 리턴
    .then(count => { // 파싱된 데이터를 받아서 처리하는 코드 작성
        console.log("count : " + count);

        if(count == -1){ // Insert/Delete 실패 시
            console.log("좋아요 처리 실패");
            return;
        }

        // toggle() : 클래스가 있으면 없애고, 없으면 추가하고
            e.target.classList.toggle("fa-solid");
            e.target.classList.toggle("fa-regular");
        
        // 현재 게시글의 좋아요 수를 화면에 출력
        e.target.nextElementSibling.innerText = count;

    }) 
    .catch( err => { // 예외 발생 시 처리하는 부분
        console.log("예외 발생");
        console.log(err);
    })
    
});

if(loginMemberNo != ""){ // 쌤은 버튼이 없을떄로 함 updateBtn != null

    // 게시글 수정 버튼 클릭 시 
    document.getElementById("updateBtn").addEventListener("click", ()=>{
    
        location.href = location.pathname.replace("board","board2") + "/update" + location.search;
        // 원래 주소 : board/1/2012 에서 board를 board2로 바꾸고 뒤에 /update를 붙힌 다음 location.search( 쿼리스트링 ) 붙이기
    });

    // 게시글 삭제 버튼이 클릭 되었을 때
    document.getElementById("deleteBtn").addEventListener("click", () => {
    
        if(confirm("정말 삭제 하시겠습니까?")){
            location.href 
            = location.pathname.replace("board","board2")
                + "/delete";
            //   /board2/1/2006/delete (GET)
            
            // 삭제 서비스 호출 성공 시 redirect:/board/{boardCode}
            // + RedirectAttributes 이용해서 "삭제 되었습니다" alert 출력
    
            // 삭제 서비스 호출 실패 시 redirect:/board/{boardCoed}/{boardNo}
             // + RedirectAttributes 이용해서 "삭제 실패" alert 출력
        }
    });
}

// 목록으로 

const goToListBtn = document.getElementById("goToListBtn");

goToListBtn.addEventListener("click", ()=>{
    
    // 이동할 주소 저장
    let url = "/board/" + boardCode;

    // URL 내장 객체 : 주소 관련 정보를 나타내는 객체
    // URL.searchParams : 쿼리스트링만 별도 객체로 반환

    const params = new URL(location.href).searchParams;

    let cp;
    if(params.get("cp") != ""){ // 쿼리스트링에 cp가 있을 경우
        cp = "?cp=" + params.get("cp");
    }else{
        cp = "?cp=1";
    }

    // 조립
    url += cp;

    // 검색 key, query가 존재하는 경우 url에 추가
    if(params.get("key") != null){ 
        const key = "&key="+ params.get("key");
        const query = "&query=" + params.get("query");

        url += key + query; // url 뒤에 붙이기
    }


    // location.href = "주소"; -> 해당 주소로 이동
    location.href = url;


    
});

