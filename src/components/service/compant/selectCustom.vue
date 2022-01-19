<template>
  <Modal v-model="isShow" width="1200" :closable="false">
    <Table border ref="selection" :show-header="false" :data="page.records" :columns="columns" @on-select="handleSelect"
           style="margin-top: 3px">
    </Table>
    <Button @click="handleSelectAll(false)">Cancel all selected</Button>
    <div style="margin: 10px;overflow: hidden">
      <div style="float: right">
        <Page :total="page.total" :page-size="page.size" :current="page.current" show-sizer show-total show-elevator
              @on-change="changePage" @on-page-size-change="changePageSize" @on-prev="changePage"
              @on-next="changePage"></Page>
      </div>
    </div>
    <div slot="footer">
      <Button @click="sure" type="primary">确定</Button>
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
          type: 'selection',
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
        }
      ],
      page: {
        records: [],
        total: 0,
        current: 1,
        size: 10
      },
      sureEntity: {},
      cusSelection: [],
      responseData: []
    }
  },
  methods: {
    cancel () {
      this.sureEntity = {}
      this.$refs.selection.selectAll(false)
      this.$emit('on-callback', false)
    },
    sure () {
      let entity = this.sureEntity
      this.sureEntity = {}
      this.$refs.selection.selectAll(false)
      this.$emit('on-callback', entity)
    },
    changePage (current) {
      this.page.current = current
      this.handleSearch(this.page)
    },
    changePageSize (size) {
      this.page.size = size
      this.handleSearch(this.page)
    },
    handleSelect (selection, row) {
      debugger
      this.sureEntity = row
      this.sure()
    },
    handleSearch (page) {
      if (page) this.page = page
      let searchPage = this.page
      searchPage.records = []
      pageSearch(searchPage).then(res => {
        if (responseHandle(res)) this.page = res.data.body
        this.loading = false
      })
    },
    handleSelectAll (status) {
      this.$refs.selection.selectAll(status)
    }
  },
  mounted () {
    this.handleSearch()
    this.$refs.selection.selectAll(status)
  },
  watch: {
    isShow (newVal) {
      this.handleSearch()
      // 获取数据
      this.$refs.selection.selectAll(status)
    }
  }
}
</script>

<style scoped>

</style>
