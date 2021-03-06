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

        window.util.setStorage('appInfoEntity', JSON.stringify(itemEntity))
        this.props.history.push('/detail')
    }

    render() {
        let {appInfoArray} = this.state
        return (
            <div id='home-root'>
                {
                    (appInfoArray || []).map((item, index) => {
                        return <div id='info-item' onClick={()=>this.goDetailPage(item)}>
                            <span id='item-title'>当前设备信息</span>



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