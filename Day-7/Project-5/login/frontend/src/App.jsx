import React, { useState, useEffect } from 'react';
import axios from 'axios';
import './App.css';
import LoginForm from './components/LoginForm';
import RegisterForm from './components/RegisterForm';
import SuccessPage from './components/SuccessPage';

function App() {
  const [currentView, setCurrentView] = useState('login');
  const [user, setUser] = useState(null);
  const [isAuthenticated, setIsAuthenticated] = useState(false);

  // API base configuration
  const API_BASE_URL = 'http://localhost:8080/api/users';

  // Check if user is already logged in (from localStorage)
  useEffect(() => {
    const savedUser = localStorage.getItem('user');
    if (savedUser) {
      setUser(JSON.parse(savedUser));
      setIsAuthenticated(true);
      setCurrentView('success');
    }
  }, []);

  // Register API call
  const handleRegister = async (userData) => {
    try {
      const response = await axios.post(`${API_BASE_URL}/register`, userData, {
        headers: { 'Content-Type': 'application/json' }
      });
      
      if (response.data.success) {
        return { success: true, data: response.data.data };
      } else {
        return { success: false, message: response.data.message };
      }
    } catch (error) {
      return { 
        success: false, 
        message: error.response?.data?.message || 'Registration failed' 
      };
    }
  };

  // Login API call
  const handleLogin = async (credentials) => {
    try {
      const response = await axios.post(`${API_BASE_URL}/login`, credentials, {
        headers: { 'Content-Type': 'application/json' }
      });
      
      if (response.data.success) {
        return { success: true, data: response.data.data };
      } else {
        return { success: false, message: response.data.message };
      }
    } catch (error) {
      return { 
        success: false, 
        message: error.response?.data?.message || 'Login failed' 
      };
    }
  };

  // Handle successful login
  const handleLoginSuccess = (userData) => {
    setUser(userData);
    setIsAuthenticated(true);
    setCurrentView('success');
    localStorage.setItem('user', JSON.stringify(userData));
  };

  // Handle successful registration
  const handleRegisterSuccess = (userData) => {
    setUser(userData);
    setIsAuthenticated(true);
    setCurrentView('success');
    localStorage.setItem('user', JSON.stringify(userData));
  };

  // Handle logout
  const handleLogout = () => {
    setUser(null);
    setIsAuthenticated(false);
    setCurrentView('login');
    localStorage.removeItem('user');
  };

  return (
    <div className="min-h-screen bg-gradient-to-br from-blue-50 to-indigo-100">
      {/* Header */}
      <header className="bg-white shadow-sm border-b border-gray-200">
        <div className="max-w-7xl mx-auto px-4 sm:px-6 lg:px-8">
          <div className="flex justify-between items-center h-16">
            <div className="flex items-center">
              <h1 className="text-2xl font-bold text-gray-900">
                The Page
              </h1>
            </div>
          </div>
        </div>
      </header>

      {/* Main Content */}
      <main className="max-w-7xl mx-auto py-6 sm:px-6 lg:px-8">
        {!isAuthenticated ? (
          <div className="flex justify-center items-center min-h-[calc(100vh-200px)]">
            <div className="w-full max-w-md">
              {currentView === 'login' ? (
                <LoginForm
                  onLoginSuccess={handleLoginSuccess}
                  onSwitchToRegister={() => setCurrentView('register')}
                  onLogin={handleLogin}
                />
              ) : (
                <RegisterForm
                  onRegisterSuccess={handleRegisterSuccess}
                  onSwitchToLogin={() => setCurrentView('login')}
                  onRegister={handleRegister}
                />
              )}
            </div>
          </div>
        ) : (
          <div className="px-4 py-6 sm:px-0">
            <SuccessPage user={user} onLogout={handleLogout} />
          </div>
        )}
      </main>
    </div>
  );
}

export default App;