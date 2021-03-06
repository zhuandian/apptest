import axios from './AxiosInterceptors';
import Api from "../../api/api";

async function get(url, params) {

    console.log(params)
    console.log(url)
    return new Promise((resolve, reject) => {
        axios.get(url, {
                params: params,
                headers: {'token': window.util.getStorage('token')}
            }
        ).then((res) => {
            resolve(res.data)
        })
    })
    // axios.get(url)
    //     .then(function (response) {
    //         return response;
    //     })
    //     .catch(function (error) {
    //         return error;
    //     });
}

async function post(url, params) {

    console.log(params)
    console.log(url)
    return new Promise((resolve, reject) => {
        axios.post(url,
            params
        ).then((res) => {
            resolve(res.data)
        }).catch((e) => {
        })
    })

}

export {
    get,
    post
}
