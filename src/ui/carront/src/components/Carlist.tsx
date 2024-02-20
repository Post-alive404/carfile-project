
import {useMutation, useQuery, useQueryClient} from "@tanstack/react-query";
import {deleteCar, getCars} from "../api/carapi.ts"
import {DataGrid, GridCellParams, GridColDef, GridToolbar} from "@mui/x-data-grid";
import {useState} from "react";
import {Snackbar} from "@mui/material";
import {AddCar} from "./AddCar.tsx";
import {EditCar} from "./EditCar.tsx";

export const Carlist = () => {
    const [open, setOpen] = useState(false);

    const queryClient = useQueryClient();


    const {data, error, isSuccess} = useQuery({
        queryKey: ["cars"],
        queryFn: getCars
    });

    const { mutate } = useMutation(deleteCar, {
        onSuccess: () => {
            setOpen(true);
            queryClient.invalidateQueries(['cars']);
        },
        onError: (err) => {
            console.error(err);
        }
    })

    const columns: GridColDef[] =[
        {field: 'brand', headerName: 'Brand', width: 200},
        {field: 'model', headerName: 'Model', width: 200},
        {field: 'color', headerName: 'Color', width: 200},
        {field: 'registrationNumber', headerName: 'Reg.nr.', width: 150},
        {field: 'modelYear', headerName: 'Model Year', width: 150},
        {field: 'price', headerName: 'Price', width: 150},
        {
            field: 'edit',
            headerName: '',
            width: 90,
            sortable: false,
            filterable: false,
            disableColumnMenu: true,
            renderCell: (params: GridCellParams) =>
                <EditCar cardata={params.row} />
        },
        {
            field: 'delete',
            headerName: '',
            width:90,
            sortable:false,
            filterable: false,
            disableColumnMenu: true,
            renderCell: (params: GridCellParams) => (
                <button
                    onClick={() => {
                        if (window.confirm(`Are you sure you want to delete ${params.row.brand} ${params.row.model}?`)) {
                            mutate(params.row._links.car.href);
                        }}}>
                    Delete
                </button>
            )
        },
    ];



    if(!isSuccess){
        return <span>Loading...</span>
    }
    else if (error){
        return <span>Error when fetching cars...</span>
    }
    else {
        return (
            <>
                <AddCar />
                <DataGrid rows={data}
                          columns={columns}
                          getRowId={row => row._links.self.href}
                          disableRowSelectionOnClick={true}
                          slots={{toolbar: GridToolbar}}
                />
                <Snackbar open={open} autoHideDuration={2000} onClose={() => setOpen(false)} message="Car deleted"/>
            </>

        );
    }
};