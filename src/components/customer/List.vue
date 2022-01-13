<template>
  <Div>
    <Card padding=8>
      <Button type="primary" @click="()=>{this.addShow =true}">新增</Button>
    </Card>
    <Card>
      <Table border :columns="columns" style="margin-top: 3px"></Table>
    </Card>
    <customerAdd :isShow="addShow" @on-callback="callback"></customerAdd>
  </Div>
</template>

<script>
import customerAdd from './compant/add'
export default {
  name: 'customerList',
  components: {
    customerAdd
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
          key: 'customer',
          width: 200,
          align: 'center'
        },
        {
          title: '性别',
          key: 'customer',
          width: 120,
          align: 'center'
        },
        {
          title: '年龄',
          key: 'serviceMoney',
          width: 100,
          align: 'center'
        },
        {
          title: '家庭地址',
          key: 'staffMember',
          minWidth: 120,
          align: 'center'
        },
        {
          title: '身份证号',
          key: 'customer',
          width: 250,
          align: 'center'
        },
        {
          title: '登记时间',
          key: 'customer',
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
