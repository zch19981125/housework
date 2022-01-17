import axios from 'axios'
import {baseUrl} from './Config'
import qs from 'qs'

export const addServiceDict = (dict) => {
  return axios({
    method: 'post',
    url: baseUrl + 'custom/add',
    data: dict
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
