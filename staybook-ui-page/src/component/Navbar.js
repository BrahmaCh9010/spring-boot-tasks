import React from 'react'
import { Link } from "react-router-dom";

function Navbar() {
    return (
        <div className='navbar'>
            <div className='nav-logo'>
                StayBook
            </div>
            <ul className='nav-menu'>
                <li><Link to='/home'>Home</Link></li>
                <li><Link to='/login'>Login</Link></li>
                <li><Link to='/signup'>SignUp</Link></li>

            </ul>

        </div>
    )
}

export default Navbar