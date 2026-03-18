import { useState } from "react";

function App() {
  const [count, setCount] = useState(0);

  const incrementCounter = () => {
    setCount(count + 1);
  };

  const decrementCounter = () => {
    setCount(count - 1);
  };

  return (
    <>
      <div>total count {count} </div>
      <button onClick={decrementCounter}>Sub - 1</button>
      <button onClick={incrementCounter}>Add + 1</button>
    </>
  );
}

export default App;