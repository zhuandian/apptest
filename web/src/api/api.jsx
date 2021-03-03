import {get, post} from '../utils/axios/request'
import axios from "../utils/axios/AxiosInterceptors";

var baseUrl = "http://192.168.51.109:8080";



class Api {


    getAllInfoList() {
        return get(baseUrl + '/getAllInfoList');
    }

    //账号登录
    login(param) {
        return post(baseUrl + '/login',param);
    }

}

export default new Api()
