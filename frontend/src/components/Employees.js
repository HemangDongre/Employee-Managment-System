import * as React from 'react';
import Box from '@mui/material/Box';
import TextField from '@mui/material/TextField';
import { useState } from 'react';
import { Button, Paper } from '@mui/material';
import { useEffect } from 'react';

export default function BasicTextFields() {
    const [FirstName, setFirstName] = useState('')
    const [LastName, setLastName] = useState('')
    const [employees, setemployees] = useState([])
    const handleClick =(e)=> {
        e.preventDefault()
        const employee = {FirstName,LastName}
        console.log(employee)

        //api call here
        fetch("http://localhost:8080/api/v1/employees",
        {method:"POST", headers:{"Content-Type":"application/json"},
    body:JSON.stringify(employee)
        }).then(()=>{console.log("post done")})
    }
    
    useEffect(()=>{
        fetch("http://localhost:8080/api/v1/employees")
        .then(res=>res.json())
        .then((result)=>
        {
            setemployees(result);
        })
    },[])

  return (<div>
    <Box
      component="form"
      sx={{
        '& > :not(style)': { m: 1, width: '25ch' },
      }}
      noValidate
      autoComplete="off"
    >
      <TextField id="outlined-basic" label="First Name" variant="outlined"
      value={FirstName}
      onChange={(e) => setFirstName(e.target.value)} 
      />
      <TextField id="outlined-basic" label="Last Name" variant="outlined" 
      value={LastName}
      onChange={(e) => setLastName(e.target.value)} 
      />
    </Box>
    <Button variant="contained" onClick={handleClick}>Done</Button>
    { employees.map(
        employee=>(
            <Paper elevation={6} style={{margin:"10px",padding:"15px", textAlign:"left"}} >
            FirstName: {employee.FirstName}
            LastName:{employee.LastName} 
            </Paper>
        ))}
            
    </div>
    
  );
}
