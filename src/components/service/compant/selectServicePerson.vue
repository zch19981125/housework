<template>
  <Modal v-model="isShow" width="1200" :closable="false">
    <Table :show-header="false" border ref="selection" :page="page" :columns="columns" :data="page.records" @on-select="handleSelect"
           style="margin-top: 3px"
           @search="handleSearch">
      <template slot-scope="{ row, index }" slot="salary">
        <Input type="text" v-model="salary" v-if="editIndex === index"/>
        <span v-else>{{ row.salary }}</span>
      </template>
      <template slot-scope="{ row, index }" slot="action">
        <div v-if="editIndex === index">
          <Button @click="handleSave(index)">保存</Button>
          <Button @click="editIndex = -1">取消</Button>
        </div>
        <div v-else>
          <Button @click="handleEdit(row, index)">操作</Button>
        </div>
      </template>
    </Table>
    <div style="margin: 10px;overflow: hidden">
      <div style="float: right">
        <Page :total="page.total" :page-size="page.size" :current="page.current" show-sizer show-total show-elevator
              @on-change="changePage" @on-page-size-change="changePageSize" @on-prev="changePage"
              @on-next="changePage"></Page>
      </div>
    </div>
    <div slot="footer">
      <Button type="primary" @click="sure">确定</Button>
      <Button @click="cancel">关闭</Button>
    </div>
  </Modal>
</template>

<script>
import {pageSearch} from '../../common/api/ServicePeopleApi'
import {responseHandle} from '../../common/utils/response'
import MyTable from '../../common/utils/MyTable'

export default {
  name: 'selectServicePerson',
  components: {MyTable},
  props: {
    isShow: false
  },
  data () {
    return {
      columns: [
        {
          title: '序号',
          type: 'selection',
          maxWidth: 80,
          align: 'center'
        },
        {
          title: '姓名',
          key: 'name',
          maxWidth: 200,
          align: 'center'
        },
        {
          title: '擅长',
          key: 'dictName',
          maxWidth: 150,
          align: 'center'
        },
        {
          title: '性别',
          key: 'sex',
          maxWidth: 120,
          align: 'center'
        },
        {
          title: '年龄',
          key: 'age',
          maxWidth: 100,
          align: 'center'
        },
        {
          title: '身份证号',
          key: 'identityNumber',
          maxWidth: 250,
          align: 'center'
        },
        {
          title: '本次服务工资',
          maxWidth: 200,
          slot: 'salary'
        },
        {
          title: '操作',
          maxWidth: 200,
          slot: 'action'
        }
      ],
      salary: '',
      editIndex: '',
      editId: '',
      sureEntity: [],
      page: {
        records: [],
        total: 0,
        current: 1,
        size: 10
      }
    }
  },
  methods: {
    changePage (current) {
      this.page.current = current
      this.handleSearch(this.page)
    },
    changePageSize (size) {
      this.page.size = size
      this.handleSearch(this.page)
    },
    cancel () {
      this.sureEntity = []
      this.$refs.selection.selectAll(false)
      this.$emit('on-callback', '')
    },
    sure () {
      let entity = this.sureEntity
      this.sureEntity = []
      this.$refs.selection.selectAll(false)
      this.$emit('on-callback', entity)
    },
    handleEdit (row, index) {
      this.editId = row.id
      this.salary = row.salary
      this.editIndex = index
    },
    handleSave (index) {
      this.data[index].salary = this.salary
      this.data[index].id = this.editId
      this.editIndex = -1
    },
    handleSelect (selection, row) {
      this.sureEntity = selection
    },
    handleSearch (page) {
      if (page) this.page = page
      let pageS = this.page
      pageSearch(pageS).then(res => {
        if (responseHandle(res)) {
          try {
            this.page = res.data.body
          } catch (e) {
          }
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
