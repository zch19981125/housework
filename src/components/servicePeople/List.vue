<template>
  <div style="height: 100%;overflow: hidden">
    <Card :padding=8>
      <Button type="primary" @click="show">新增</Button>
    </Card>
    <Card>
      <MyTable border :page="page" :columns="columns" style="margin-top: 3px" @search="handleSearch"></MyTable>
    </Card>
    <AddServicePeople :isShow="isShow" @on-callback="callback"></AddServicePeople>
  </div>
</template>

<script>
import AddServicePeople from './compant/Add'
import {responseHandle} from '../common/utils/response'
import {pageSearch} from '../common/api/ServicePeopleApi'
import MyTable from '../common/utils/MyTable'

export default {
  name: 'List',
  components: {AddServicePeople, MyTable},
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
          title: '擅长',
          key: 'dictName',
          width: 150,
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
      isShow: false
    }
  },
  methods: {
    callback () {
      this.isShow = false
    },
    show () {
      this.isShow = true
    },
    handleSearch (page) {
      if (page) this.page = page
      let pageS = this.page
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
