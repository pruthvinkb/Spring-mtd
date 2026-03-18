import React from 'react';

const LandingPage = () => {
  return (
    <div>
      <nav className="p-4">
        <ul className="flex space-x-6 justify-center">
          <li><a href="#home" className="hover:opacity-75 transition-opacity">Home</a></li>
          <li><a href="#about" className="hover:opacity-75 transition-opacity">About</a></li>
          <li><a href="#contact" className="hover:opacity-75 transition-opacity">Contact</a></li>
        </ul>
      </nav>
      <section id="home" className="py-20 px-4 text-center">
        <h1 className="text-4xl md:text-6xl font-bold mb-4">Welcome to Our Platform</h1>
        <p className="text-xl mb-8 max-w-2xl mx-auto">Discover amazing features and services</p>
        <button className="px-8 py-3 rounded-lg font-semibold hover:opacity-75 transition-opacity border">Get Started</button>
      </section>
      <section id="about" className="py-16 px-4">
        <div className="max-w-4xl mx-auto text-center">
          <h2 className="text-3xl font-bold mb-6">About Us</h2>
          <p className="text-lg leading-relaxed">We provide innovative solutions to help your business grow.</p>
        </div>
      </section>
      <section id="contact" className="py-16 px-4">
        <div className="max-w-4xl mx-auto text-center">
          <h2 className="text-3xl font-bold mb-6">Contact</h2>
          <div className="space-y-2">
            <p className="text-lg">Email: info@company.com</p>
            <p className="text-lg">Phone: (555) 123-4567</p>
          </div>
        </div>
      </section>
      <footer className="py-8 px-4 text-center border-t">
        <p className="text-sm">&copy; 2024 Your Company. All rights reserved.</p>
      </footer>
    </div>
  );
};

export default LandingPage;