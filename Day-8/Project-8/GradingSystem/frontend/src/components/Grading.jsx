import { useState } from 'react';

function Grading() {
  const [score, setScore] = useState('');
  const [grade, setGrade] = useState('');

  const calculateGrade = () => {
    const numScore = parseFloat(score);
    let result;
    
    if (numScore > 100) {
        result = 'Invalid Score'
    }
    else if (numScore > 90) {
      result = 'A';
    } else if (numScore > 80) {
      result = 'B';
    } else if (numScore > 70) {
      result = 'C';
    } else if (numScore > 60) {
      result = 'D';
    } else if (numScore > 50) {
      result = 'E';
    } else if (numScore < 50 && numScore >= 0) {
      result = 'F';
    } else {
        result = 'Invalid Score';
    }
    
    setGrade(result);
  };

  return (
    <div style={{ padding: '20px', maxWidth: '400px', margin: '0 auto' }}>
      <h1>Grading System</h1>
      <div>
        <input
          type="number"
          value={score}
          onChange={(e) => setScore(e.target.value)}
          placeholder="Enter score"
          style={{ padding: '8px', marginRight: '10px' }}
        />
        <button onClick={calculateGrade} style={{ padding: '8px 16px' }}>
          Calculate Grade
        </button>
      </div>
      {grade && (
        <div style={{ marginTop: '20px', fontSize: '18px' }}>
          <strong>Grade: {grade}</strong>
        </div>
      )}
    </div>
  );
}

export default Grading;