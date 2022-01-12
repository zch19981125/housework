<template>
  <Div>
    <Card padding="8">
      <Button type="primary" @click="()=>{this.addShow =true}">新增</Button>
    </Card>
    <Card>
      <Table border :columns="columns" :data="data" style="margin-top: 3px"></Table>
    </Card>
  </Div>
</template>

<script>
export default {
  name: 'moneyReportList',
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
      ]
    }
  }
}
</script>

<style scoped>

</style>
