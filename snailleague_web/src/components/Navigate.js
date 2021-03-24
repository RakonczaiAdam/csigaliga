import React from 'react';
import { useHistory, Link } from 'react-router-dom';

import "../styles/basic.css";

class Navigate extends React.Component{
    render(){
        return(
        <div className="baseContainer">
            <div className="header">
                <h1>Welcome to the Snail League!</h1>
            </div>
            <Link to="/login">
                <button type="button">Login</button>
            </Link>
            <Link to="/registration">
                <button type="button">Registration</button>
            </Link>
        </div>
        )
    }
}
export default Navigate;
