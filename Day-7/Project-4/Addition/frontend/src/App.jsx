import { useState } from "react";
import axios from "axios";

function App() {
  const [num1, setNum1] = useState("");
  const [num2, setNum2] = useState("");
  const [result, setResult] = useState(null);
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState("");

  const handleAddition = async () => {
    if (!num1 || !num2) {
      setError("Please enter both numbers");
      return;
    }
    
    setLoading(true);
    setError("");
    
    try {
      const response = await axios.get(`http://localhost:8080/add?a=${num1}&b=${num2}`);
      setResult(response.data);
    } catch (err) {
      setError("Failed to connect to backend. Make sure the backend is running on port 8080.");
      console.error("Error:", err);
    } finally {
      setLoading(false);
    }
  };

  return (
    <div className="min-h-screen bg-gray-100 flex items-center justify-center p-4">
      <div className="bg-white rounded-lg shadow-lg p-8 w-full max-w-md">
        <h1 className="text-3xl font-bold text-center text-gray-800 mb-8">Addition Calculator</h1>
        
        <div className="space-y-4">
          <input
            type="number"
            placeholder="First number"
            value={num1}
            onChange={(e) => setNum1(e.target.value)}
            className="w-full px-4 py-2 border border-gray-300 rounded-lg focus:ring-2 focus:ring-blue-500 focus:border-transparent"
          />
          <div className="text-center text-2xl font-bold text-gray-600">+</div>
          <input
            type="number"
            placeholder="Second number"
            value={num2}
            onChange={(e) => setNum2(e.target.value)}
            className="w-full px-4 py-2 border border-gray-300 rounded-lg focus:ring-2 focus:ring-blue-500 focus:border-transparent"
          />
          <button 
            onClick={handleAddition}
            disabled={loading}
            className="w-full bg-blue-500 hover:bg-blue-600 disabled:bg-gray-400 text-white font-semibold py-3 px-4 rounded-lg transition duration-200"
          >
            {loading ? "Calculating..." : "Calculate"}
          </button>
        </div>

        {error && (
          <div className="mt-4 p-3 bg-red-100 border border-red-400 text-red-700 rounded-lg">
            {error}
          </div>
        )}

        {result && (
          <div className="mt-6 p-4 bg-green-100 border border-green-400 rounded-lg">
            <h2 className="text-xl font-semibold text-green-800 text-center">
              Result: {result.num1} + {result.num2} = {result.result}
            </h2>
          </div>
        )}
      </div>
    </div>
  );
}

export default App;