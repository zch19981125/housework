<template>
  <div>
    <Col :span="span">
      <FormItem :label="label" :prop="prop" class="font"></FormItem>
    </Col>
  </div>
</template>

<script>
export default {
  name: 'MyFormItem',
  props: {
    span: '',
    label: '',
    props: ''
  }
}
</script>

<style scoped>
.font /deep/ .ivu-form-item-label {
  font-size: 16px;
}
</style>
