// AddCar.js
//추가 기능
import { Dialog,DialogActions,DialogContent
    ,DialogTitle
 } from "@mui/material"
import { useState } from "react"

function AddCar(){
    //대화상자에도 대화상자 폼의 표시 여부를 정의하는 불린 상태인 open이 필요하다.
    const [open,setOpen]=useState(false)
    //모든 자동차 필드를 포함하는 상태를 선언한다.
    const [car,setCar]=useState({
        brand:"",
        model:"",
        color:"",
        year:"",
        price:""
    })

    //대화상자 폼을 닫고 여는 두 함수를 추가 한다.
    const handleClickOpen=()=>{
        setOpen(true)
    }
    const handleClickClose=()=>{
        setOpen(false)
    }

    const handleChange=(event)=>{
        setCar({...car,[event.target.name]:event.target.value})
    }

    return (
        <div>
            <button onClick={handleClickOpen}>New Car</button>
            <Dialog open={open} onClose={handleClickClose}>
                <DialogTitle>New Car</DialogTitle>
                <DialogContent>
                    <input placeholder="Brand" name="brand" value={car.brand} onChange={handleChange} />
                    <br/>
                    <input placeholder="Model" name="model" value={car.model} onChange={handleChange} />
                    <br/>
                    <input placeholder="Color" name="color" value={car.color} onChange={handleChange} />
                    <br/>
                    <input placeholder="Year" name="year" value={car.year} onChange={handleChange} />
                    <br/>
                    <input placeholder="Price" name="price" value={car.price} onChange={handleChange} />
                </DialogContent>
            </Dialog>
        </div>
    )
}
export default AddCar