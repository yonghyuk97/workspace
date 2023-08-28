const insertBtn = document.getElementById("insertBtn");

// 글쓰기 버튼을 클릭 시

if(insertBtn != null){

    insertBtn.addEventListener("click", ()=>{
        // JS BOM 객체 중 location

        // location.href = "주소"
        // 해당 주소 요청 (GET방식)
       
        // location.href = "/board2"+ location.pathname.split("/")[2] + "/insert"
        location.href = `/board2/${location.pathname.split("/")[2]}/insert`
        //               /board2/1/insert
    })

}