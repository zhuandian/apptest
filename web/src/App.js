import React, {Component} from 'react';
import {HashRouter as Router, Route} from 'react-router-dom';
import './App.css';

import HomePage from './pages/home/home'
import DetailPage from './pages/detail/index'
import LoginPage from './pages/login/login'

class App extends Component {



    render() {
        return (
            <Router>
                <div>
                    <Route exact path="/" component={HomePage}/>
                    <Route path="/home" component={HomePage}/>
                    <Route path="/detail" component={DetailPage}/>
                    <Route path="/login" component={LoginPage}/>
                </div>
            </Router>
        )
    }
}

export default App;
