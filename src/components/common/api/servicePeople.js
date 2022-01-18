import axios from 'axios'
import {baseUrl} from './Config'
import qs from 'qs'

export const pageSearch = (page) => {
  console.log(qs.stringify(page))
  return axios({
    method: 'post',
    url: baseUrl + 'servicePeople/pageSearch',
    headers: {'content-type': 'application/x-www-form-urlencoded'},
    data: qs.stringify(page)
  })
}
export const add = (entity) => {
  return axios({
    method: 'post',
    url: baseUrl + 'servicePeople/add',
    data: qs.stringify(entity)
  })
}

export const del = (id) => {
  return axios({
    method: 'post',
    url: baseUrl + 'servicePeople/del',
    headers: {'content-type': 'application/x-www-form-urlencoded'},
    data: qs.stringify({id: id})
  })
}

export const get = (id) => {
  return axios({
    method: 'post',
    url: baseUrl + 'servicePeople/get',
    headers: {'content-type': 'application/x-www-form-urlencoded'},
    data: qs.stringify({id: id})
  })
}
