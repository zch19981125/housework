<template>
  <div style="height: 100%;overflow: hidden">
    <Card :padding=8>
      <Button type="primary" @click="()=>{this.addShow =true}">新增</Button>
    </Card>
    <Card>
      <MyTable border :page="page" :columns="columns" style="margin-top: 3px" @search="handleSearch"></MyTable>
    </Card>
    <AddService :isShow="addShow" @on-callback="callback"></AddService>
  </div>
</template>

<script>
import AddService from './compant/add'
import {pageSearch} from '../common/api/ServiceApi'
import {responseHandle} from '../common/utils/response'
import MyTable from '../common/utils/MyTable'

export default {
  name: 'serviceList',
  components: {
    AddService,
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
          title: '服务号',
          key: 'serviceNum',
          width: 150,
          align: 'center'
        },
        {
          title: '客户',
          key: 'custom',
          width: 200,
          align: 'center'
        },
        {
          title: '服务地址',
          key: 'address',
          minWidth: 120,
          align: 'center'
        },
        {
          title: '服务费',
          key: 'money',
          width: 100,
          align: 'center'
        },
        {
          title: '工作人员',
          key: 'servicePeople',
          width: 220,
          align: 'center'
        },
        {
          title: '服务类型',
          key: 'serviceType',
          width: 100,
          align: 'center'
        },
        {
          title: '服务时间',
          key: 'serviceDate',
          width: 200,
          align: 'center'
        },
        {
          title: '操作',
          key: 'staffMember',
          width: 250,
          render (h, param) {
            let err = []
            err.push(h('Button', {style: 'margin-left: 10px'}, '详情'))
            err.push(h('Button', {style: 'margin-left: 10px'}, '修改'))
            err.push(h('Button', {style: 'margin-left: 10px'}, '删除'))
            return h('div', err)
          }
        }
      ],
      addShow: false,
      page: {
        records: [],
        total: 0,
        current: 1,
        size: 10
      }
    }
  },
  methods: {
    callback (isSearch) {
      this.addShow = false
      if (isSearch) {
        this.handleSearch()
      }
    },
    handleSearch (page) {
      if (page) this.page = page
      let pageS = this.page
      pageS.records = []
      pageSearch(pageS).then(res => {
        if (responseHandle(res)) {
          this.page = res.data.body
        } else {
          this.$Message.error(res.data.msg)
        }
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
