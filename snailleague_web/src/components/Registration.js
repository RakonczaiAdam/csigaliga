import React from 'react';
import { useHistory, Link } from 'react-router-dom';

import "../styles/basic.css";

class Registration extends React.Component{
    render(){
        return(
        <div className="baseContainer">
            <div className="whiteBox">
                <div className="header">
                    <h1>Please enter your details to continue!</h1>
                </div>
                <form className="loginForm">
                    <div>
                        <input type="text" class="" id="username" placeholder ="Username" />
                    </div>
                    <div>
                        <input type="password" class="" id="pwd" placeholder ="Password"/>
                    </div>
                    <div>
                        <input type="password" class="" id="pwd" placeholder ="Confirm Password"/>
                    </div>
                    <button type="submit" class="btn btn-primary">Registration</button>
                    <Link to="/">
                        <button type="button">Back</button>
                    </Link>
                </form>
            </div>
        </div>
        )
    }
}

export default Registration;
