import React, {Component} from 'react';
import {HashRouter as Router, Route} from 'react-router-dom';
import './App.css';

import HomePage from './pages/home/home'

class App extends Component {



    render() {
        return (
            <Router>
                <div>
                    <Route exact path="/" component={HomePage}/>
                    <Route path="/home" component={HomePage}/>
                </div>
            </Router>
        )
    }
}

export default App;
