<template>
  <div style="height: 100%;overflow: hidden">
    <Card padding=8>
      <Button type="primary" @click="()=>{this.addShow =true}">新增</Button>
    </Card>
    <Card>
      <Table border :columns="columns" :data="data" style="margin-top: 3px"></Table>
    </Card>
    <AddService :isShow="addShow" @on-callback="callback"></AddService>
  </div>
</template>

<script>
import AddService from './compant/add'
export default {
  name: 'serviceList',
  components: {
    AddService
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
          key: 'customer',
          width: 200,
          align: 'center'
        },
        {
          title: '服务地址',
          key: 'customer',
          minWidth: 120,
          align: 'center'
        },
        {
          title: '服务费',
          key: 'serviceMoney',
          width: 100,
          align: 'center'
        },
        {
          title: '工作人员',
          key: 'staffMember',
          width: 220,
          align: 'center'
        },
        {
          title: '服务类型',
          key: 'customer',
          width: 100,
          align: 'center'
        },
        {
          title: '服务时间',
          key: 'customer',
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
      addShow: false
    }
  },
  methods: {
    callback () {
      this.addShow = false
    }
  }
}
</script>

<style scoped>

</style>
