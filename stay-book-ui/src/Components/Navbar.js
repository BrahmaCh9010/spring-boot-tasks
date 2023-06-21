import React from 'react'
import {  Link } from "react-router-dom";
function Navbar() {
    return(
        <div>
            <li>
                <Link to="/">Home</Link>
            </li>
            <li>
                <Link to="/cats">Contact us</Link>
            </li>
            <li>
                <Link to="/sheeps">Share</Link>
            </li>
            <li>
                <Link to="/goats">info</Link>
            </li>
        </div>
    );
}
export default Navbar;