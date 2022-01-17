<template>
  <div style="height: 100%;overflow: hidden">
    <Card :padding=8>
      <Button type="primary" @click="show">新增</Button>
    </Card>
    <Card>
      <div slot="title" v-if="false"></div>
      <div slot="extra">
        <Button @click="handleSearch(page)">搜索</Button>
        <Button>重置</Button>
      </div>
      <MyTable border :page="page" :columns="columns" style="margin-top: 3px" @search="handleSearch"></MyTable>
    </Card>
    <Modal
        title="新增服务字典"
        width="800"
        :value="addShow"
        label-width=80
        :closable="false">
      <Form :label-width="80">
        <Row type="flex" justify="center" class="code-row-bg">
          <Col span="18">
            <FormItem label="字典名称" prop="passwd" class="font">
              <Input v-model="entity.name" style="width: 20%;"></Input>
            </FormItem>
          </Col>
          <Col span="18">
            <FormItem label="字典值" prop="passwdCheck" class="font">
              <Input v-model="entity.value" style="width: 60%;"></Input>
            </FormItem>
          </Col>
          <Col span="18">,
            <FormItem label="排序" prop="age" class="font">
              <Input type="text" v-model="entity.order" style="width: 60%;"></Input>
            </FormItem>
          </Col>
        </Row>
      </Form>
      <div slot="footer">
        <Button @click="()=>{this.addShow =false ;this.handleClear}" type="default">取消</Button>
        <Button @click="handleOk" :loading="buttonLoading" type="primary">确定</Button>
      </div>
    </Modal>
  </div>
</template>

<script>
import {addServiceDict, pageSearch} from '../common/api/DictApi'
import {responseHandle} from '../common/utils/response'
import MyTable from '../common/utils/MyTable'

export default {
  name: 'List',
  components: {
    MyTable
  },
  data () {
    return {
      columns: [
        {
          title: '序号',
          type: 'index',
          width: 100,
          align: 'center'
        },
        {
          title: '字典名',
          key: 'name',
          minWidth: 150,
          align: 'center'
        },
        {
          title: '字典值',
          key: 'value',
          minWidth: 120,
          align: 'center'
        },
        {
          title: '排序',
          key: 'order',
          align: 'center',
          width: 100
        },
        {
          title: 'Action',
          key: 'action',
          width: 150,
          align: 'center',
          render: (h, params) => {
            return h('div', [
              h('Button', {
                props: {
                  type: 'error',
                  size: 'small'
                },
                style: {
                  marginRight: '5px'
                },
                on: {
                  click: () => {
                    this.handlerDelete(params.row)
                  }
                }
              }, '删除')
            ])
          }
        }
      ],
      entity: {
        name: '',
        value: '',
        order: '',
        type: ''
      },
      page: {
        records: [],
        total: 0,
        current: 1,
        size: 10
      },
      loading: false,
      addShow: false,
      buttonLoading: false,
      height: document.body.clientHeight,
      tableHeight: '',
      isDelete: false,
      deleteLoading: false
    }
  },
  methods: {
    show () {
      this.addShow = true
    },
    handleSearch (page) {
      debugger
      this.loading = true
      this.page = page
      let param = this.page
      param.type = 1
      param.records = []
      // param.order = ['order']
      console.log(param)
      pageSearch(param).then(res => {
        if (responseHandle(res)) this.page = res.data.body
        this.loading = false
      })
    },
    changePage (current) {
      this.page.current = current
      this.handleSearch(this.page)
    },
    changePageSize (size) {
      this.page.size = size
      this.handleSearch(this.page)
    },
    handleClear () {
      this.entity = {}
    },
    handleOk () {
      this.buttonLoading = true
      this.entity.type = '1'
      addServiceDict(this.entity).then(res => {
        if (responseHandle(res)) {
          this.$Message.success('添加成功')
          this.addShow = false
        } else {
          this.$Message.error(res.data.msg)
        }
        this.buttonLoading = false
        this.handleSearch(this.page)
      })
    },
    handlerDelete (row) {
      debugger
      this.$Modal.confirm({
        title: '工作服务字典删除',
        content: '<p>您确定要删除检查事项<br>[' + '<span style="color:#c04f4f;">' + row.name + '</span>' + ']吗?</p>',
        onOk: () => {
        }
      })
    }
  },
  mounted () {
    this.handleSearch(this.page)
    this.tableHeight = (this.height * 0.75).toString()
    console.log(this.tableHeight)
  }
}
</script>

<style scoped>
.font /deep/ .ivu-form-item-label {
  font-size: 16px;
}

</style>
