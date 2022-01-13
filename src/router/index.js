import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import List from '../components/serviceDict/List'
import ReposDictList from '../components/serviceDict/RepostList'
import serviceList from '../components/service/List'
import moneyReportList from '../components/moneyReport/List'
import servicePeopleList from '../components/servicePeople/List'
import customerList from '../components/customer/List'

Vue.use(Router)

const routes = [
  {path: '/index', component: HelloWorld},
  {path: '/dictList', component: List},
  {path: '/ReposDictList', component: ReposDictList},
  {path: '/serviceList', component: serviceList},
  {path: '/moneyReportList', component: moneyReportList},
  {path: '/servicePeopleList', component: servicePeopleList},
  {path: '/customerList', component: customerList},
  {path: '/', redirect: '/index'}
]
// eslint-disable-next-line no-undef
const router = new Router({
  mode: 'hash',
  routes // routes: routes 的简写
})

export default router
