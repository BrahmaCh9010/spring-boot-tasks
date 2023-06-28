import React, { useState } from "react";
import { BrowserRouter as Router, Route, Routes, Link } from 'react-router-dom'
import "./navbar.css";
import { Login } from "./Pages/Login";

function NavBarCode() {
 
  return (
    <>
    <Router>
      <nav className="navbar">
        <div className="nav-container">
          <div className="nav-logo">
            <span>S</span>tay
            <span>B</span>ook
          </div>
          <div className="nav-links">
          <ul>
            <li>
              <Link to="/">Login</Link>
            </li>
          </ul>
          </div>
        </div>
        
      </nav>
      <section className='hero-section'>
        <p>Welcome to </p>
        <h1>StayBook app</h1>
        
    </section>
    
    </Router>
    </>
  );
}

export default NavBarCode;