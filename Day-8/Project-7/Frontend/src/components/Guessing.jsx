import { useState } from 'react';

function Guessing() {
  const targetNumber = 2; // Set your number here
  const [userGuess, setUserGuess] = useState('');
  const [result, setResult] = useState('');

  const checkGuess = () => {
    const guess = parseInt(userGuess);
    if (guess === targetNumber) {
      setResult('Correct number!');
    } else {
      setResult(`Wrong number`);
    }
  };

  return (
    <div>
      <p>Guess a number between 1 - 10:</p>
      <input
        type="number"
        value={userGuess}
        onChange={(e) => setUserGuess(e.target.value)}
        placeholder="Enter your guess"
      />
      <button onClick={checkGuess}>Check</button>
      {result && <h3 style={{ color: result.includes('Correct') ? 'green' : 'red' }}>{result}</h3>}
    </div>
  );
};

export default Guessing;