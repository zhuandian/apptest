import React, {Component} from 'react';
import {Line,Liquid} from '@ant-design/charts';
import './style.css'
import Api from "../../api/api";


export default class Detail extends Component {


    constructor(props) {
        super(props)
        this.state = {
            appInfo: null,
            user: null,
            commentArray: [],
            config:{
                data:[],
                height: 400,
                xField: 'year',
                yField: 'value',
                point: {
                    size: 5,
                    shape: 'diamond',
                },
            },
            liquidConfig: {
                percent: 0.25,
                statistic: {
                    content: {
                        style: {
                            fontSize: 50,
                            fill: 'black',
                            lineHeight: 1,
                        },
                    },
                }
            }
        }
    }



    async componentDidMount() {
        let user = JSON.parse(window.util.getStorage('user'))
        let data = JSON.parse(window.util.getStorage('appInfoEntity'));

        this.setState({
            appInfo: data,
            user: user
        })

        let params = {
            "appInfoId": data.id
        }

        let result = await Api.getCommentListByAppInfoId(params)

        this.setState({
            commentArray: result.data
        })

        let params2 = {
            "deviceId": data.deviceId
        }
        let allInfoListByDeviceId = await Api.getAllInfoListByDeviceId(params2)

        let listArray = allInfoListByDeviceId.data

        let arrayItem=[];


        for(let i=0;i<listArray.length;i++){
            arrayItem.push({
                year:i,
                value:parseInt(listArray[i].usedPercentValue.split("%")[0])/100
            })
        }



        console.log(arrayItem,1111)

        let config = this.state.config
        config.data =arrayItem;


        let liquidConfig = this.state.liquidConfig
        liquidConfig.percent = parseInt(data.usedPercentValue.split("%")[0])/100;

        this.setState({
            config:config,
            liquidConfig:liquidConfig
        })


    }




    goCommentPage() {
        this.props.history.push("/comment?id=" + this.state.appInfo.id)
    }

    render() {
        let {appInfo, commentArray,config,liquidConfig} = this.state
        return (
            <div id='detail-root'>
                {
                    appInfo != null ?
                        <div id='info-item'>
                            <span id='item-title'>应用信息</span>
                            <span id='item-content'>设备id : {appInfo.deviceId}</span>
                            <span id='item-content'>设备安装app数量 : {appInfo.appCount}</span>

                            <span id='item-title'>系统信息</span>
                            <span id='item-content'>手机品牌 : {appInfo.deviceBrand}</span>
                            <span id='item-content'>手机型号 : {appInfo.systemModel}</span>
                            <span id='item-content'>安卓系统版本 : {appInfo.systemVersion}</span>
                            <span id='item-content'>CPU型号 : {appInfo.cpuType}</span>
                            <span id='item-content'>磁盘信息 : {appInfo.devSpace}</span>
                            <span id='item-content'>网速 : {appInfo.netSpeed}</span>
                            <span id='item-content'>内存使用率 : {appInfo.usedPercentValue}</span>
                        </div>
                        : <div></div>
                }


                <div id='liquid'>
                    <Liquid {...liquidConfig}/>
                </div>


                <span id='chars-title'>当前使用内存</span>

                <Line {...config} />
                <span id='chars-title'>近一小时数据</span>

                <span id='comment-title'>评论列表</span>

                {
                    (commentArray || []).map((item, index) => {
                        return <div id='comment-view-item'>
                            <span>用户 {item.userName}说:</span>
                            <span>{item.comment}</span>

                        </div>
                    })
                }


                <span id='btn-comment' onClick={() => this.goCommentPage()}>评论</span>
            </div>
        )
    }


}