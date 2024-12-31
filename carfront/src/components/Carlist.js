//src/components/Carlist.js
import {useState,useEffect} from "react"
import { SEVER_URL } from "../constants"
import {DataGrid} from "@mui/x-data-grid"
import AddCar from "./AddCar"
import EditCar from "./EditCar"

function Carlist(){
    //Rest api에서 가져온 자동차 정보를 담을 상태 객체를 선언합니다. 비어 있는 배열을 기본값으로 cars라는 상태를 선언한다.
    const [cars, setCars]=useState([])
    //useEffect훅에서 fetch를 실행한다. 두 번째 인수로 비어 있는 배열을 전달하므로 fetch는 첫 번째 렌더링 후에 한 번만 실행된다.JSON응답 데이터에 있는 자동차 데이터를 cars상태에 저장전에 재 렌더링 되면서 cars에 서버에서 받아온 데이터가 저장된다.
    useEffect(()=>{
        fetchCars()
    },[])
    //map함수로 자동차 객체를 표 행으로 변환하고 table요소를 추가한다.
    //삭제 기능
    // /cars/{carId} 이 주소에 delete방식 요청을 보내면 된다.
    //각 행에 버튼을 만든다.
    const columns=[
        {field:"brand",headerName:"Brand",width:200},
        {field:"model",headerName:"Model",width:200},
        {field:"color",headerName:"Color",width:200},
        {field:"year",headerName:"Year",width:150},
        {field:"price",headerName:"Price",width:150},
        {
            
            headerName:"",
            sortble:false,
            filterable:false,
            renderCell:row=>
                <EditCar 
                    data={row} 
                    updateCar={updateCar}
                />
        },
        {
            field:"_links.self.href",
            headerName:"",
            sortble:false,
            filterable:false,
            renderCell:row=>
                <button
                    onClick={()=>onDelClick(row.id)}>
                    Delete
                </button>
        },
    ]

    const fetchCars=()=>{
        fetch(SEVER_URL+"cars")
        .then(response=>response.json())
        .then(data=>setCars(data._embedded.cars))
        .catch(err=>console.log(err))
    }

    const onDelClick=(url)=>{
        fetch(url,{method:"DELETE"})
        .then(()=>fetchCars())
        .catch(err=>console.log(err))
    }

    //새로운 자동차 추가
    const addCar=(car)=>{
        fetch(SEVER_URL+"cars",
            {
                method:"POST",
                headers:{"Content-Type":"application/json"},
                body:JSON.stringify(car)
            }
        )
        .then(response=>{
            if(response.ok){
                fetchCars()
            }else{
                alert("Something went wrong!")
            }
        })
        .catch(err=>console.log(err))
    }
    //자동차 업데이트
    const updateCar=(car,link)=>{
        fetch(link,{
            method:"PUT",
            headers:{"Content-Type":"application/json"},
            body:JSON.stringify(car)
        })
        .then(response=>{
            if(response.ok){
                fetchCars()
            }else{
                alert("Something went wrong!")
            }
        })
        .catch(err=>console.log(err))
    }
    
    return(
        <>
            <AddCar addCar={addCar}/>
            <div style={{height:500,width:"100%"}}>
                <DataGrid
                    rows={cars}
                    columns={columns}
                    getRowId={row=>row._links.self.href}
                    />
            </div>
        </>
    )
}
export default Carlist