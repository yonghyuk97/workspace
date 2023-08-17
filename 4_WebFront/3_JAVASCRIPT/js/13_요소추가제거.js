// 추가 버튼(#add)가 클릭 되었을 때
document.getElementById("add").addEventListener("click", function(){

    // div 요소 생성
    const div = document.createElement("div"); // <div></div>

    // div에 row클래스 추가
    div.classList.add("row"); // <div class="row"></div>

    // ---------------------------------------------------------------

    // input 요소 생성
    const input = document.createElement("input"); // <input>

    // input에 in 클래스 추가
    input.classList.add("in"); // <input class="in">

    // input에 "type" 속성, "number" 속성값 추가(type = "number")

    // - 요소.setAttribute("속성" , "속성값") : 요소에 속성/속성값 추가
    input.setAttribute("type","number"); // <input class="in" type="number">

     // ---------------------------------------------------------------

    // span 요소 생성
    const span = document.createElement("span"); // <span></span>

    // span에 remove 클래스 추가
    span.classList.add("remove"); // classList가 아닌 setAttribute를 사용해서 class 생성 가능 <span class="remove"></span>

    // span에 내용으로 "X" 추가
    span.innerHTML = "X"; // <span class="remove"> X </span>

    //span이 클릭 되었을 때에 대한 이벤트 동작 추가
    span.addEventListener("click", function(){

        // 요소.parentElement : 부모 요소
        // 요소.remove() : 요소 제거

        // 부모(.row)제거
        span.parentElement.remove();


    })

    // -----------------------------------------------------------------------

    // div 내부에(자식으로 input, span 순서대로 추가해주기)
    div.append(input); // 순서 중요!!
    div.append(span);

    // #container에 div를 마지막 자식으로 추가
    document.getElementById("container").append(div);
})

document.getElementById("calc").addEventListener("click", function(){
    
    // 합계 저장용 변수
    let sum = 0;
    
    const list = document.getElementsByClassName("in");

    // 배열용 향상된 for문 (for of) 사용
    for(let input of list){

        // sum에 입력값 누적
        // -> input에 작성된 값은 모두 string -> 숫자 변환 Number() 필요
        sum += Number(input.value);

        // Number("") == 0 // 빈칸은 0으로 변환되기 떄문에 신경쓰지 말자
    }
    

    alert("합계 : " + sum);

    
})
