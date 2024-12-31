//EditCar.js
import { Dialog,DialogActions,DialogContent
    ,DialogTitle
 } from "@mui/material"
import { useState } from "react"

function EditCar({data,updateCar}){
    const [open,setOpen]=useState(false)
    const [car,setCar]=useState({
        brand:"",model:"",color:"",
        year:"",price:""
    })
    const handleClickOpen=()=>{
        setCar({
            brand:data.row.brand,model:data.row.model,
            color:data.row.color,year:data.row.year,
            price:data.row.price
        })
        setOpen(true)
    }
    const handleClickClose=()=>{
        setOpen(false)
    }
    const handleChange=(event)=>{
        setCar({...car,[event.target.name]:event.target.value})
    }
    //자동차를 업데이트하고 모달 폼을 닫음
    const handleSave=()=>{
        updateCar(car,data.id)
        handleClickClose()
    }
    return(
        <div>
            <button onClick={handleClickOpen}>Edit Car</button>
            <Dialog open={open} onClose={handleClickClose}>
                <DialogTitle>Edit Car</DialogTitle>
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
                <DialogActions>
                    <button onClick={handleClickClose}>Cancel</button>
                    <button onClick={handleSave}>Save</button>
                </DialogActions>
            </Dialog>
        </div>
    )
}
export default EditCar