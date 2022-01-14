<template>
  <div>
    <Table border :max-height="tableHeight" :columns="columns" size="large" :data="page.records" style="margin-top: 4vh"
           stripe></Table>
    <div style="margin: 10px;overflow: hidden">
      <div style="float: right">
        <Page :total="page.total" :page-size="page.size" :current="page.current" show-sizer show-total show-elevator
              @on-change="changePage" @on-page-size-change="changePageSize" @on-prev="changePage"
              @on-next="changePage"></Page>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'MyTable',
  props: {
    columns: [],
    page: {
      records: [],
      total: 0,
      size: 0,
      current: 0
    }
  },
  data () {
    return {
      height: document.body.clientHeight,
      tableHeight: '',
      iPage: {}
    }
  },
  methods: {
    changePage (current) {
      this.iPage.current = current
      this.$emit('search', this.iPage)
    },
    changePageSize (size) {
      this.iPage.size = size
      this.$emit('search', this.iPage)
    }
  },
  mounted () {
    this.tableHeight = (document.body.clientHeight * 0.75).toString()
    this.iPage = this.page
    console.log(this.page + this.size)
  }
}
</script>

<style scoped>

</style>
