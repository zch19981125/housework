<template>
  <Div>
    <Card :padding=8>
      <Button type="primary" @click="()=>{this.addShow =true}">新增</Button>
    </Card>
    <Card>
      <MyTable border :page="page" :columns="columns" style="margin-top: 3px" @search="handleSearch"></MyTable>
    </Card>
    <customerAdd :isShow="addShow" @on-callback="callback"></customerAdd>
  </Div>
</template>

<script>
import customerAdd from './compant/add'
import {pageSearch} from '../common/api/CustomApi'
import {responseHandle} from '../common/utils/response'
import MyTable from '../common/utils/MyTable'

export default {
  name: 'customerList',
  components: {
    customerAdd,
    MyTable
  },
  data () {
    return {
      columns: [
        {
          title: '序号',
          type: 'index',
          width: 80,
          align: 'center'
        },
        {
          title: '姓名',
          key: 'name',
          width: 200,
          align: 'center'
        },
        {
          title: '性别',
          key: 'sex',
          width: 120,
          align: 'center'
        },
        {
          title: '年龄',
          key: 'age',
          width: 100,
          align: 'center'
        },
        {
          title: '家庭地址',
          key: 'address',
          minWidth: 120,
          align: 'center'
        },
        {
          title: '身份证号',
          key: 'identityNum',
          width: 250,
          align: 'center'
        },
        {
          title: '登记时间',
          key: 'createDate',
          width: 200,
          align: 'center'
        },
        {
          title: '操作',
          key: 'staffMember',
          minWidth: 120,
          render (h, param) {
            let err = []
            err.push(h('Button', {style: 'margin-left: 10px'}, '详情'))
            err.push(h('Button', {style: 'margin-left: 10px'}, '修改'))
            err.push(h('Button', {style: 'margin-left: 10px'}, '删除'))
            return h('div', err)
          }
        }
      ],
      page: {
        records: [],
        total: 0,
        current: 1,
        size: 10
      },
      addShow: false,
      loading: false
    }
  },
  methods: {
    callback (isSearch) {
      debugger
      this.addShow = false
      if (isSearch) {
        this.handleSearch()
      }
    },
    handleSearch (page) {
      if (page) this.page = page
      let searchPage = this.page
      searchPage.records = []
      pageSearch(searchPage).then(res => {
        if (responseHandle(res)) this.page = res.data.body
        this.loading = false
      })
    }
  },
  mounted () {
    this.handleSearch()
  }
}
</script>

<style scoped>

</style>
