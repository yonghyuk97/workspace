import React, { useState } from 'react'; // imrs

// useState 복습
const InputName = () => {

    // state : 컴포넌트의 상태 
    // useState : 컴포넌트의 상태를 관리
    //              -> state 변화가 감지되면 컴포넌트를 리랜더링

    const [name,setName] = useState('');
    // name : 변수명
    // setName : name 변수의 setter
    // useState : name 변수에 대입되는 초기값을 ''(빈칸)으로 지정

    return(
        <div>
            <p>이름을 입력하세요</p>
            <input type='text' onChange={e=>setName(e.target.value)}/>
            <h3>{name}</h3>
        </div>
    );
};

const TodoList1 = () => {

    // 할 일을 저장할 변수
    // -> 상태가 변하면 컴포넌트(TodoList1)을 리랜더링  
    const [Todos, setTodos] = useState([
        {text : '프로젝트', completed : false},
        {text : '점심 먹기', completed : false}
    ]);

    console.log(Todos);

    // 할 일 입력 컴포넌트
    const InputTodo = ()=>{
        const [inputText, setInputText] = useState('');

        // 버틀 클릭 시 할 일 추가
        const addTodo = ()=> {
            const newTodo = {text : inputText, completed : false};

            // todos에 newTodo를 추가한 객체 배열 newTodos

            const newTodos = [...Todos, newTodo];

            // 새로운 객체배열 newTodos를 todos에 대입
            // -> 상태 변화 인식 -> 리랜더링 진행
            setTodos(newTodos);
            setInputText(''); // 입력된 할 일 삭제
          
            
        };

        return(
            <div>
                <h4>할 일 추가</h4>
                <input type='text'onChange={e=>setInputText(e.target.value)}/>
                <button onClick={addTodo}>추가하기</button>
            </div>
        );
    };



    return(
        <>
            <hr/>
            <InputName/>
            <hr/>

            <h1>Todo List1</h1>

            {/* 입력 */}
            <InputTodo/>
        </>
    );
};


// 외부에서 해당 파일 import 시 TodoList1 함수를 내보내는 것을 기본값으로 지정
export default TodoList1;