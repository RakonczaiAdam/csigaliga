import React from 'react';
import { useHistory, Link } from 'react-router-dom';

class Registration extends React.Component{
    render(){
        return(
        <div className="App">
              <form>
                <div class="">
                  <label for="username" class="">Username</label>
                  <input type="text" class="" id="username" placeholder ="Username" />
                </div>
                <div class="">
                  <label for="pwd" class="">Password</label>
                  <input type="password" class="" id="pwd" placeholder ="Password"/>
                </div>
                 <div class="">
                  <label for="pwd" class="">Password again</label>
                  <input type="password" class="" id="pwd" placeholder ="Password"/>
                 </div>

                <button type="submit" class="btn btn-primary">Registration</button>
              </form>
              <Link to="/login">
                <button type="button">
                    Login
                </button>
              </Link>
            </div>
            )
    }
}

export default Registration;