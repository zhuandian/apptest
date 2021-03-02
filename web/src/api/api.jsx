import {get, post} from '../utils/axios/request'
import axios from "../utils/axios/AxiosInterceptors";

var baseUrl = "http://192.168.51.109:8080";



class Api {


    //账号登录
    getAllInfoList() {
        return get(baseUrl + '/getAllInfoList');
    }

}

export default new Api()
