import React, {Component} from 'react';
import './style.css'
import Api from "../../api/api";
import {getCurrentDate} from '../../utils/util'
import {Toast} from "antd-mobile";

export default class Comment extends Component {


    constructor(props) {
        super(props)
        this.state = {
            appInfo: null,
            user: null
        }
    }

    async componentDidMount() {
        let user = JSON.parse(window.util.getStorage('user'))
        let data = this.props.location.query;

        this.setState({
            appInfo: data,
            user: user
        })
    }


    async handleCommentClick() {

        var commentText = document.getElementById('text-comment').value

        if (commentText.length < 1) {
            Toast.fail('请输入评论内容...')
        } else {
            let params = {
                "appInfoId": window.util.getSearchByName('id'),
                "userId": this.state.user.id,
                "userName": this.state.user.userName,
                "comment": commentText,
                "createAt": getCurrentDate(),
            }


            let result = await Api.addNewComment(params)
            if (result != null && result.msg == "success") {
                Toast.success('添加成功...')
                document.getElementById('text-comment').value = ""
            } else {
                Toast.fail('添加评论失败...')
            }

        }

    }

    render() {
        return (
            <div id='comment-root'>
                <textarea id='text-comment' placeholder='请输入评论内容...' type="text"/>

                <span id='add-comment' onClick={() => this.handleCommentClick()}>评 论</span>
            </div>
        )
    }
}