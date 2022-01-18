import axios from 'axios'
import {baseUrl} from './Config'
import qs from 'qs'

export const addCustom = (dict) => {
  return axios({
    method: 'post',
    url: baseUrl + 'custom/add',
    data: qs.stringify(dict)
  })
}
export const pageSearch = (page) => {
  console.log(qs.stringify(page))
  return axios({
    method: 'post',
    url: baseUrl + 'custom/pageSearch',
    headers: {'content-type': 'application/x-www-form-urlencoded'},
    data: qs.stringify(page)
  })
}
