<template>
  <Modal v-model="isShow" @on-cancel="cancel" title="新增日常上报">
    <Form>
      <Row>
        <Col span="12">
          <FormItem label="客户"></FormItem>
        </Col>
        <Col span="12" >
          <FormItem label="工作人员"></FormItem>
        </Col>
        <Col span="12">
          <FormItem label="服务类型"></FormItem>
        </Col>
        <Col span="12" >
          <FormItem label="服务费"></FormItem>
        </Col>
        <Col span="12">
          <FormItem label="服务地址"></FormItem>
        </Col>
        <Col span="12" >
          <FormItem label="服务时间"></FormItem>
        </Col>
      </Row>
    </Form>
  </Modal>
</template>

<script>
export default {
  name: 'add',
  props: {
    isShow: {
      type: Boolean,
      default: false
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
