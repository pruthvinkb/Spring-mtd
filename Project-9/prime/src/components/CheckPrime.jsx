import { useState } from 'react';

function CheckPrime() {
  const [number, setNumber] = useState('');
  const [result, setResult] = useState('');

  const isPrime = (n) => {
    if(n <= 1) {
      return "Not Prime";
    }

    for(let i = 2; i < n; i++) {
      if(n % i === 0) {
        return "Not Prime";
      }
    }
    return "Prime";
  };

  const handleCheck = () => {
    const num = parseInt(number);
    if(isNaN(num)) {
      setResult('Please enter a valid number');
      return;
    }
    setResult(isPrime(num));
  };

  return (
    <div>
      <input 
        type="number" 
        value={number}
        onChange={(e) => setNumber(e.target.value)}
        placeholder="Enter a number"
      />
      <button onClick={handleCheck}>Check Prime</button>
      <p>Result: {result}</p>
    </div>
  );
}

export default CheckPrime;