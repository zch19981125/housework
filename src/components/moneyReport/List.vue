<template>
  <Div>
    <Card padding=8>
      <Button type="primary" @click="()=>{this.addShow =true}">新增</Button>
    </Card>
    <Card>
      <Table border :columns="columns" style="margin-top: 3px"></Table>
    </Card>
    <reportAdd :isShow="addShow" @on-callback="callback"></reportAdd>
  </Div>
</template>

<script>
import reportAdd from './compant/add'
export default {
  name: 'moneyReportList',
  components: {
    reportAdd
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
          title: '类型',
          type: 'index',
          minWidth: 200,
          align: 'center'
        },
        {
          title: '费用',
          type: 'index',
          minWidth: 150,
          align: 'center'
        },
        {
          title: '持续日期',
          type: '',
          minWidth: 250,
          align: 'center'
        },
        {
          title: '操作',
          type: 'index',
          minWidth: 300,
          align: 'center'
        }
      ],
      addShow: false
    }
  },
  methods: {
    callback (oper) { // 关闭模态框回调
      debugger
      this.addShow = false
    }
  }
}
</script>

<style scoped>

</style>
