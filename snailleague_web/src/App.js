import React from 'react';
import {BrowserRouter,Switch,Route} from 'react-router-dom';
import logo from './logo.svg';
import './App.css';
import Login from './components/Login';
import Registration from './components/Registration';
import Navigate from './components/Navigate';

const App = () => {
  return (
    <div>

    <BrowserRouter>
        <Switch>
             <Route exact path='/login' component ={Login} />
             <Route exact path='/registration' component ={Registration} />
             <Route exact path='/' component ={Navigate} />

        </Switch>
    </BrowserRouter>


    </div>
  )
}

export default App;
