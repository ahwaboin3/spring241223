import './App.css';
//axios 라이브러리 이용
//네트워크 호출에 많이 이용되는 다른 라이브러리로 axios가 있다.
//axios라이브러리에는 JSON데이터의 자동 변환과 같은 몇 가지 이점이 있다.

import { useEffect, useState } from 'react';

function App() {
  const [temp,setTemp]=useState("")
  const [desc,setDesc]=useState("")
  const [icon,setIcon]=useState("")
  const [isReady,setReady]=useState(false)
  //콜백함수가 첫 번째 렌더링 전에 한 번 호출된다.
  useEffect(()=>{
    fetch("https://api.openweathermap.org/data/2.5/weather?q=London&appid=f91f941c5a4e99dede2a98ed106b5c7f")
    .then(result=>result.json())
    .then(jsonResult=>{
      setTemp(jsonResult.main.temp)
    })
  },[])

  return (
    <div className="App">
      
    </div>
  );
}

export default App;
