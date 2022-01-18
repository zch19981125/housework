import axios from 'axios'
import {baseUrl} from './Config'
import qs from 'qs'

export const pageSearch = (page) => {
  console.log(qs.stringify(page))
  return axios({
    method: 'post',
    url: baseUrl + 'service/pageSearch',
    headers: {'content-type': 'application/x-www-form-urlencoded'},
    data: qs.stringify(page)
  })
}
