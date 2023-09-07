import './App.css';

// components 폴더의 Exam1.js를 가져와서 사용
// 사용할 때 이름을 
import Ex1 from './components/Exam1';
import Ex2 from './components/Exam2';

import PropsEx from './components/R01_props.js';
import State1 from './components/R02_state1.js';
import State2 from './components/R03_state2.js';
import State3 from './components/R04_state3.js';
import TodoList1 from './components/R05_todolist1.js';

function App() {
  // 리액트의 컴포넌트(= 화면을 구성하는 단위)는 딱 하나의 요소만을 반환할 수 있다.
  // -> 여러 요소를 반환하고 싶을 경우 부모 요소로 묶어준다 !!
  return (
    /* fragment(<></>) : 반환되는 요소를 감쌀 때 사용, 해석 */
    <>
    {/* jsx 주석 */}
      <h1>hello React!!!</h1>

      <div>리액트 배운다~</div>

      {/* <Ex1/> */}

      {/* <Ex2/> */}

      {/* <PropsEx name={'홍길동'}/> */} 
      {/* <PropsEx name={'김길동'}/> */}  
      {/* <PropsEx name={'이길동'}/> */} 

      {/* R02_state1 */}
      {/* <State1/> */}

      {/* R03_state2 */}
      {/* <State2 init={100}/> */}

      {/* <hr/> */}
      {/* R03_steat3 */}
      {/* <State3/> */}

      {/* R05_todolist1 */}
      <TodoList1/>
    </>
  );
}

export default App;
