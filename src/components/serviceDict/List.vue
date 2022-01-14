<template>
  <div style="height: 100%;overflow: hidden">
    <Card :padding=8>
      <Button type="primary" @click="show">新增</Button>
    </Card>
    <Card>
      <div style="float: right">
        <Button @click="handleSearch(page)">搜索</Button>
        <Button>重置</Button>
      </div>
      <Table border :height="tableHeight" :columns="columns" size="large" :data="page.records" style="margin-top: 4vh"
             stripe></Table>
      <div style="margin: 10px;overflow: hidden">
        <div style="float: right">
          <Page :total="page.total" :page-size="page.size" :current="page.current" show-sizer show-total show-elevator
                @on-change="changePage" @on-page-size-change="changePageSize" @on-prev="changePage"
                @on-next="changePage"></Page>
        </div>
      </div>
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

export default {
  name: 'List',
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
          title: '操作',
          render (h, param) {
            let err = []
            err.push(h('Button', {style: 'margin-left: 10px'}, '详情'))
            err.push(h('Button', {style: 'margin-left: 10px'}, '修改'))
            err.push(h('Button', {style: 'margin-left: 10px'}, '删除'))
            return h('div', err)
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
      addShow: false,
      buttonLoading: false,
      height: document.body.clientHeight,
      tableHeight: ''
    }
  },
  methods: {
    show () {
      this.addShow = true
    },
    handleSearch () {
      let param = this.page
      param.type = 1
      param.records = []
      // param.order = ['order']
      console.log(param)
      pageSearch(param).then(res => {
        if (responseHandle(res)) this.page = res.data.body
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
