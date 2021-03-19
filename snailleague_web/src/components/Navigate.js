import React from 'react';
import { useHistory, Link } from 'react-router-dom';

class Navigate extends React.Component{
    render(){
      return (
    <div className="App">

     <Link to="/login">
        <button type="button">
            Login
        </button>
      </Link>

    <Link to="/registration">
    <button type="button">
          Registration
    </button>
    </Link>

    </div>
  )

}
}
export default Navigate;