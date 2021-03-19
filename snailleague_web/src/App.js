import React from 'react';
import {BrowserRouter,Switch,Route} from 'react-router-dom';
import logo from './logo.svg';
import './App.css';
import Login from './components/Login';

const App = () => {
  return (
    <div>
    <BrowserRouter>
        <Switch>
             <Route exact path='/login' component ={Login} />
        </Switch>
    </BrowserRouter>
    </div>
  )
}

export default App;
