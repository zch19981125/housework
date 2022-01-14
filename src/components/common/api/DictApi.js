import axios from 'axios'
import qs from 'qs'

let baseUrl = 'http://127.0.0.1:8000/'
export const init = () => {
  return axios({
    method: 'get',
    url: baseUrl + 'init'
  })
}

export const pageSearch = (page) => {
  console.log(qs.stringify(page))
  return axios({
    method: 'post',
    url: baseUrl + 'serviceDict/list',
    headers: {'content-type': 'application/x-www-form-urlencoded'},
    data: qs.stringify(page)
  })
}
export const addServiceDict = (dict) => {
  return axios({
    method: 'post',
    url: baseUrl + 'serviceDict/add',
    data: dict
  })
}

export const pageSearchRepost = (page) => {
  return axios({
    method: 'post',
    url: baseUrl + 'serviceDict/list',
    headers: {'content-type': 'application/x-www-form-urlencoded'},
    data: qs.stringify(page)
  })
}
