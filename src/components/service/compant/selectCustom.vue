<template>
  <Modal v-model="isShow" width="1200" :closable = "false">
    <MyTable border :page="page" :columns="columns" style="margin-top: 3px" @search="handleSearch"></MyTable>
    <div slot="footer">
      <Button @click="cancel">关闭</Button>
    </div>
  </Modal>
</template>

<script>
import MyTable from '../../common/utils/MyTable'
import {pageSearch} from '../../common/api/CustomApi'
import {responseHandle} from '../../common/utils/response'
export default {
  name: 'selectCustom',
  components: {
    MyTable
  },
  props: {
    isShow: false
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
      page: {
        records: [],
        total: 0,
        current: 1,
        size: 10
      }
    }
  },
  methods: {
    cancel () {
      this.$emit('on-callback', '')
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
  }
}
</script>

<style scoped>

</style>
