//src/components/Asynch.js

export default function Asynch(){
    //1. 자바스크립트 제어 흐름
    //(1) 동기적 제어 흐름
    //동기적 제어 흐름은 현재 실행주인 코드가 종료되기 전까지 다음 줄의 코드를 실행하지 않는 것을 의미한다.
    //코드의 흐름과 실제 제어 흐름이 동일하다.
    //(2) 비동기적 제어 흐름
    //비동기적 제어 흐름은 현재 실행중인 코드가 종료되기 전에 다음 라인의 코드를 실행하는 것을 의미한다.
    //코드 흐름과 실제 제어 흐름이 다른다
    //비동기 작업을 기다리는 동안 메인 스레드는 다른 작업을 처리한다.
    //비동기적으로 처리하는 자바스크립트 내부 함수
    // AJAX API요청
    // 파일 읽기
    // 암호화/복호화
    // 작업 예약/작업 반복(setTimeout, setInterval)

    //동기적으로 실행
    let a=10
    console.log("a :", a)
    console.log("Finished")

    //비동기적으로 실행
    let b=42
    setTimeout(()=>{
        console.log("b :", b)
    },1000)
    console.log("B Finished")

    //비동기적으로 실행을 콜백으로 해결
    function finishedB(callback){
        setTimeout(()=>{
            console.log("b1 :", b)
            callback()
        },1000)
    }

    finishedB(()=>{
        console.log("B1 Finished")
    })

    //프로미스 이용
    //비동기 작업을 처리하는 기존 방법은 작업의 성공 또는 실패에 따르는 콜백 함수를 이용하는 것이다.
    //프로미스는 비동기 작업의 결과를 나타내는 객체다. 프로미스를 이용하면 비동기 호출을 실행할 때 코드를 간소화할 수 있다.
    //프로미스는 세가지 상태 중 하나일 수 있다.
    //대기: 초기 상태
    //이행: 작업 성공
    //거부: 작업 실패
    // 사용 중인 API가 프로미스를 지원하면 프로미스로 비동기 호출을 실행할 수 있다.
    //응답이 반환되면 비동기 호출이 수행되고 then메소드 내의 콜백 함수가 response를 인수로 받고 실행된다.
    //doAsyncCall().then(response=>//response로 필요한 작업을 수행)
    //then메서드는 프로미스 객체를 반환한다. 여러 then 메서드를 체인으로 연결할 수 있다. 즉, 여러 비동기 작업을 순서대로 실행할 수 있다.
    //doAsyncCall().then(response=>//response에서 data를 얻음).then(data=>//data로 필요한 작업을 수행)
    //catch()를 이용하면 프로미스에 예외 처리를 추가할 수 있다.
    //doAsyncCall().then(response=>//response에서 data를 얻음).then(data=>//data로 필요한 작업을 수행).catch(error=>console.log(error))

    return(
        <div></div>
    )
}