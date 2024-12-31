//src/components/Carlist.js
import {useState,useEffect} from "react"

function Carlist(){
    //Rest api에서 가져온 자동차 정보를 담을 상태 객체를 선언합니다. 비어 있는 배열을 기본값으로 cars라는 상태를 선언한다.
    const [cars, setCars]=useState([])
    //useEffect훅에서 fetch를 실행한다. 두 번째 인수로 비어 있는 배열을 전달하므로 fetch는 첫 번째 렌더링 전에 한 번만 실행된다.JSON응답 데이터에 있는 자동차 데이터를 cars상태에 저장합니다.
    useEffect(()=>{
        fetch("http://localhost:8080/cars")
        .then(response=>{return response.json()})
        .then(data=>{
            setCars(data._embedded.cars)
        })
        .catch(err=>console.log(err))
        .then(console.log(cars))
    },[])
    //map함수로 자동차 객체를 표 행으로 변환하고 table요소를 추가한다.
    return(
        <div>
            <table>
                <tbody>
                    {
                        cars.map((car,index)=>
                            <tr>
                                <td>{car.brand}</td>
                                <td>{car.model}</td>
                            </tr>
                        )
                    }
                </tbody>
            </table>
        </div>
    )
}
export default Carlist