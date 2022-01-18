<template>
  <Modal v-model="isShow" width="1200" :closable="false">
    <MyTable border :page="page" :columns="columns" style="margin-top: 3px" @search="handleSearch">
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
    </MyTable>
    <div slot="footer">
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
          type: 'index',
          maxWidth: 80,
          align: 'center'
        },
        {
          title: '姓名',
          key: 'customer',
          maxWidth: 200,
          align: 'center'
        },
        {
          title: '擅长',
          key: 'serviceNum',
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
          key: 'salary',
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
      entity: [{
        id: '001',
        customer: '顶顶顶',
        serviceNum: '保洁',
        sex: '女',
        age: '18',
        staffMember: '惠泽园',
        identityNumber: '37232116669863214',
        salary: '100'
      }],
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
