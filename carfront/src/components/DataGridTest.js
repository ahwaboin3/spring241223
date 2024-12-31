//components/DataGridTest.js
import {DataGrid} from "@mui/x-data-grid"

function DataGridTest(){
    //배열안의 객체로 만들어 놓으면 자동으로 테이블을 만들어 줍니다.
    const columns=[
        {field:"brand",headerName:"Brand",width:200},
        {field:"model",headerName:"Model",width:200},
        {field:"color",headerName:"Color",width:200},
        {field:"year",headerName:"Year",width:150},
        {field:"price",headerName:"Price",width:150},
    ]
    const cars=[
        {brand:"Ford",model:"Mustang",color:"White",year:2021,price:39000}
    ]
    return(
        <>
            <div style={{height:500,width:"100%"}}>
                <DataGrid
                    rows={cars}
                    columns={columns}
                    getRowId={row=>row.brand}
                />
            </div>
        </>
    )
}
export default DataGridTest