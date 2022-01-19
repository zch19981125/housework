<template>
  <div style="height: 100%;overflow: hidden">
    <Card :padding=8>
      <Button type="primary" @click="()=>{this.addShow =true}">新增</Button>
    </Card>
    <Card>
      <MyTable border :page="page" :columns="columns" style="margin-top: 3px" @search="handleSearch"></MyTable>
    </Card>
    <Modal
        title="新增服务字典"
        width="800"
        v-model="addShow"
        :label-width="80"
        :closable="false">
      <Form :label-width="80">
        <Row type="flex" justify="center" class="code-row-bg">
          <Col span="18">
            <FormItem label="字典名称"  prop="passwd" class="font">
              <Input style="width: 20%;" v-model="entity.name"></Input>
            </FormItem>
          </Col>
          <Col span="18">
            <FormItem label="字典值" prop="passwdCheck" class="font">
              <Input style="width: 20%;" v-model="entity.value"></Input>
            </FormItem>
          </Col>
          <Col span="18">
            <FormItem label="排序"  prop="age" class="font">
              <Input style="width: 20%;" v-model="entity.order"></Input>
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
import MyTable from '../common/utils/MyTable'
import {addServiceDict, pageSearch} from '../common/api/DictApi'
import {responseHandle} from '../common/utils/response'

export default {
  name: 'ReposDictList',
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
      page: {
        records: [],
        total: 0,
        current: 1,
        size: 10
      },
      entity: {
        name: '',
        value: '',
        order: '',
        type: ''
      },
      addShow: false,
      buttonLoading: false
    }
  },
  methods: {
    handleClear () {
      this.entity = {}
    },
    handleSearch (ipage) {
      this.page = ipage
      let param = this.page
      param.type = '2'
      pageSearch(param).then(res => {
        if (responseHandle(res)) this.page = res.data.body
      })
    },
    handleOk () {
      debugger
      this.buttonLoading = true
      this.entity.type = '2'
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
  }
}
</script>

<style scoped>

</style>
