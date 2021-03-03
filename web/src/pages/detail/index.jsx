import React, {Component} from 'react';
import './style.css'
import Api from "../../api/api";

export default class Detail extends Component {


    constructor(props) {
        super(props)
        this.state = {
            appInfo: null,
            user: null,
            commentArray: []
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

    }


    goCommentPage() {
        this.props.history.push("/comment?id=" + this.state.appInfo.id)
    }

    render() {
        let {appInfo, commentArray} = this.state
        return (
            <div id='detail-root'>
                {
                    appInfo != null ?
                        <div id='info-item'>
                            <span id='item-title'>应用信息</span>
                            <span id='item-content'>设备id : {appInfo.deviceId}</span>
                            <span id='item-content'>应用名称 : {appInfo.appName}</span>
                            <span id='item-content'>版本号 : {appInfo.versionCode}</span>
                            <span id='item-content'>版本名称 : {appInfo.versionName}</span>
                            <span id='item-content'>应用包名 : {appInfo.packageName}</span>
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