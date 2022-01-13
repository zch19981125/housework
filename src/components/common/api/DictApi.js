import axios from 'axios'

let baseUrl = 'http://127.0.0.1:8000/'
export const init = () => {
  debugger
  return axios({
    method: 'get',
    url: baseUrl + 'init'
  })
}

export const pageSearch = (page) => {
  debugger
  return axios({
    method: 'post',
    url: baseUrl + 'serviceDict/list'
  })
}
