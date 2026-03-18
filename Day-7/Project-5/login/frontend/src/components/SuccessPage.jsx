import React from 'react';

const SuccessPage = ({ user, onLogout }) => {
  return (
    <div className="max-w-md mx-auto">
      <div className="bg-white shadow-lg rounded-lg p-8 text-center">
        {/* Success Message */}
        <h2 className="text-2xl font-bold text-gray-900 mb-2">
          Login Successful!
        </h2>
        <p className="text-gray-600 mb-6">
          Welcome back, {user.username}
        </p>

        {/* Logout Button */}
        <button
          onClick={onLogout}
          className="bg-red-600 hover:bg-red-700 text-white px-6 py-3 rounded-md font-medium transition-colors duration-200"
        >
          Logout
        </button>
      </div>
    </div>
  );
};

export default SuccessPage;