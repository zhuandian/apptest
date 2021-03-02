import React, {Component} from 'react';
import './home.less'
import Api from "../../api/api";

export default class Home extends Component {



     async componentDidMount() {
         let params = {
             'id': 1
         }
         let result = await Api.getAllInfoList()
     }


    render() {
        return (
            <div>
                dsdsfa
            </div>
        )
    }
}