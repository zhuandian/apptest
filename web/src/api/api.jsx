import {get, post} from '../utils/axios/request'
import axios from "../utils/axios/AxiosInterceptors";

var baseUrl = "http://192.168.51.109:8080";



class Api {


    //获取所有app上报信息
    getAllInfoList() {
        return get(baseUrl + '/getAllInfoList');
    }

    //账号登录
    login(param) {
        return post(baseUrl + '/login',param);
    }

    //添加评论
    addNewComment(param) {
        return post(baseUrl + '/addNewComment',param);
    }

    //获取评论列表
    getCommentListByAppInfoId(param) {
        return get(baseUrl + '/getCommentListByAppInfoId',param);
    }

}

export default new Api()
