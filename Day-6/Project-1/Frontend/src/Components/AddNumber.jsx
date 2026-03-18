import { useState } from "react";
function AddNumber() {
    const [num1, setNum1] = useState(0);
    const [num2, setNum2] = useState(0);
    
    const [result, setResult] = useState(0);
    
    function double() {
        setNum1(Number(num1) + Number(num1));
    }
    const handleAdd = () => {
        setResult(Number(num1) + Number(num2));
    };

    return (
        <>
        <input 
            type = "number" 
            value = {num1}
            onChange = {(e) => setNum1(e.target.value)}
        />
        <input 
            type = "number" 
            value = {num2}
            onChange = {(e) => setNum2(e.target.value)}
        />
        <button onClick = {handleAdd}>ADD</button>
        <h3>Result: {result}</h3>
        </>
    );
}
export default AddNumber;