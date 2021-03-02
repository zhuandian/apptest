import React, {Component} from 'react';
import './style.css'
import Api from "../../api/api";

export default class Home extends Component {


    constructor(props) {
        super(props)
        this.state = {
            appInfoArray :  []
        }
    }

    async componentDidMount() {
        let result = await Api.getAllInfoList()

        console.log(result)
        this.setState({
            appInfoArray : result.data
        })
    }


    goDetailPage(itemEntity){
        var path = {
            pathname:'/detail',
            query:itemEntity,
        }

        this.props.history.push(path)
    }

    render() {
        let {appInfoArray} = this.state
        return (
            <div id='home-root'>
                {
                    (appInfoArray || []).map((item, index) => {
                        return <div id='info-item' onClick={()=>this.goDetailPage(item)}>
                            <span id='item-title'>应用信息</span>
                            <span id='item-content'>设备id : {item.deviceId}</span>
                            <span id='item-content'>应用名称 : {item.appName}</span>
                            <span id='item-content'>版本号 : {item.versionCode}</span>
                            <span id='item-content'>版本名称 : {item.versionName}</span>
                            <span id='item-content'>应用包名 : {item.packageName}</span>
                            <span id='item-title'>系统信息</span>
                            <span id='item-content'>手机品牌 : {item.deviceBrand}</span>
                            <span id='item-content'>手机型号 : {item.systemModel}</span>
                            <span id='item-content'>安卓系统版本 : {item.systemVersion}</span>
                            <span id='item-content'>CPU型号 : {item.cpuType}</span>
                            <span id='item-content'>磁盘信息 : {item.devSpace}</span>
                            <span id='item-content'>网速 : {item.netSpeed}</span>
                            <span id='item-content'>内存使用率 : {item.usedPercentValue}</span>
                        </div>
                    })
                }
            </div>
        )
    }
}