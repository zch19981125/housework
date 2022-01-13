<template>
  <div style="height: 100%;overflow: hidden">
    <Card padding=8>
      <Button type="primary" @click="show">新增</Button>
    </Card>
    <Card>
      <Table border :columns="columns" :data="data" style="margin-top: 3px" stripe></Table>
      <div style="margin: 10px;overflow: hidden">
        <div style="float: right">
          <Page :total="page.title" :page-size="page.size" :current="page.current" show-sizer show-total show-elevator
                @on-change="changePage" @on-page-size-change="changePage" @on-prev="changePage" @on-next="changePage"></Page>
        </div>
      </div>
    </Card>
    <Modal
        title="新增服务字典"
        width="800"
        v-model="addShow"
        label-width=80
        :closable="false">
      <Form :label-width="80">
        <Row type="flex" justify="center" class="code-row-bg">
          <Col span="18">
            <FormItem label="字典名称" prop="passwd" class="font">
              <Input type="password" style="width: 20%;"></Input>
            </FormItem>
          </Col>
          <Col span="18">
            <FormItem label="字典值" prop="passwdCheck" class="font">
              <Input type="password" style="width: 60%;"></Input>
            </FormItem>
          </Col>
          <Col span="18">
            <FormItem label="排序" prop="age" class="font">
              <Input type="text" style="width: 60%;"></Input>
            </FormItem>
          </Col>
        </Row>
      </Form>
    </Modal>
  </div>
</template>

<script>
import {init, pageSearch} from '../common/api/DictApi'

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
      page: {
        content: [],
        title: 0,
        current: 1,
        size: 10
      },
      data: [
        {name: '保洁', value: '1'}
      ],
      addShow: false
    }
  },
  methods: {
    show () {
      debugger
      init().then(res => {
        console.log('ddd')
      })
      this.addShow = true
    },
    changePage () {
      debugger
      pageSearch(this.page).then(res => {
        if (res.data.code === 200) {
          this.page = res.data.body
        }
      })
    }
  }
}
</script>

<style scoped>
.font /deep/ .ivu-form-item-label {
  font-size: 16px;
}

</style>
