import { useState } from 'react';
import State from './components/State';
import Guessing from './components/Guessing';

function App() {
  const [currentComponent, setCurrentComponent] = useState('Guessing');

  return (
    <div className="App">
      <button onClick={() => setCurrentComponent('State')}>State</button>
      <button onClick={() => setCurrentComponent('Guessing')}>Guessing</button>
      {currentComponent === 'Guessing' ? <Guessing /> : <State />}
    </div>
  );
}

export default App;