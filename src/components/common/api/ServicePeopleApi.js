import axios from 'axios'
import qs from 'qs'
import {baseUrl} from './Config'

export const pageSearch = (page) => {
  console.log(qs.stringify(page))
  return axios({
    method: 'post',
    url: baseUrl + 'servicePeople/pageSearch',
    headers: {'content-type': 'application/x-www-form-urlencoded'},
    data: qs.stringify(page)
  })
}
