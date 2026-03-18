import { useState } from "react";
import './Calculator.css';

function Calculator() {
    const [expression, setExpression] = useState('');
    const [result, setResult] = useState(0);

    const handleCalculate = () => {
        try {
            setResult(eval(expression));
        } catch (error) {
            setResult('Error');
        }
    }

    return (
        <div className="min-h-screen bg-gradient-to-br from-slate-900 via-purple-900 to-slate-900 flex items-center justify-center p-4">
            <div className="w-full max-w-md bg-white/10 backdrop-blur-lg border border-white/20 rounded-2xl shadow-2xl p-8">
                <div className="text-center mb-8">
                    <h1 className="text-3xl font-bold bg-gradient-to-r from-blue-400 to-purple-400 bg-clip-text text-transparent mb-2">
                        Calculator
                    </h1>
                    <div className="w-16 h-1 bg-gradient-to-r from-blue-400 to-purple-400 rounded-full mx-auto"></div>
                </div>
                
                <div className="space-y-6">
                    <div className="relative">
                        <input 
                            type="text" 
                            value={expression} 
                            onChange={(e) => setExpression(e.target.value)}
                            placeholder="Enter expression (e.g., 5 + 3 * 2)"
                            className="w-full p-4 text-lg bg-white/5 border border-white/20 rounded-xl text-white placeholder-gray-400 focus:outline-none focus:ring-2 focus:ring-blue-400/50 focus:border-transparent transition-all duration-300 backdrop-blur-sm"
                        />
                        <div className="absolute inset-0 rounded-xl bg-gradient-to-r from-blue-400/10 to-purple-400/10 pointer-events-none opacity-0 transition-opacity duration-300 peer-focus:opacity-100"></div>
                    </div>
                    
                    <div className="bg-white/5 border border-white/10 rounded-xl p-4 backdrop-blur-sm">
                        <p className="text-sm text-gray-400 mb-1">Result</p>
                        <p className="text-2xl font-bold text-white break-all">{result}</p>
                    </div>
                    
                    <button 
                        onClick={handleCalculate} 
                        className="w-full bg-gradient-to-r from-blue-500 to-purple-600 hover:from-blue-600 hover:to-purple-700 text-white font-semibold py-4 px-6 rounded-xl shadow-lg hover:shadow-xl transform hover:scale-[1.02] active:scale-[0.98] transition-all duration-200 focus:outline-none focus:ring-2 focus:ring-blue-400/50"
                    >
                        <span className="flex items-center justify-center gap-2">
                            <svg className="w-5 h-5" fill="none" stroke="currentColor" viewBox="0 0 24 24">
                                <path strokeLinecap="round" strokeLinejoin="round" strokeWidth={2} d="M9 7h6m0 10v-3m-3 3h.01M9 17h.01M9 14h.01M12 14h.01M15 11h.01M12 11h.01M9 11h.01M7 21h10a2 2 0 002-2V5a2 2 0 00-2-2H7a2 2 0 00-2 2v14a2 2 0 002 2z" />
                            </svg>
                            Calculate
                        </span>
                    </button>
                </div>
                
                <div className="mt-8 text-center">
                    <p className="text-xs text-gray-400">Enter mathematical expressions like 2+2, 10*5, or (8-3)/2</p>
                </div>
            </div>
        </div>
    );
}

export default Calculator;