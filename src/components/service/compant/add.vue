<template>
  <Modal v-model="isShow" width="800" @on-cancel="cancel" title="新增日常上报" :styles="{height:'1000px'}">
    <Form :label-width="80" label-position="right">
      <Row>
        <MyFormItem label="客户" :span="12">
          <span>115666666666666666666</span>
        </MyFormItem>
        <MyFormItem label="工作人员" span="12">
          <span>115666666666666666666</span>
        </MyFormItem>
        <MyFormItem label="服务类型" span="12"></MyFormItem>
        <MyFormItem label="服务费" span="12"></MyFormItem>
        <MyFormItem label="服务地址" span="12"></MyFormItem>
        <MyFormItem label="服务时间" span="12"></MyFormItem>
      </Row>
    </Form>
    <Modal
        v-model="customShow"
        title="Common Modal dialog box title">
      <p>Content of dialog</p>
      <p>Content of dialog</p>
      <p>Content of dialog</p>
    </Modal>
  </Modal>
</template>

<script>
import MyFormItem from '../../common/utils/MyFormItem'

export default {
  name: 'add',
  components: {
    MyFormItem
  },
  props: {
    isShow: {
      type: Boolean,
      default: false
    }
  },
  data () {
    return {
      customShow: false
    }
  },
  methods: {
    cancel () {
      this.$emit('on-callback')
    }
  }
}
</script>

<style scoped>

</style>
