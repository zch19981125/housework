<template>
  <div>
    <Col :span="span">
      <FormItem :label="label" :prop="prop" :props="prop" class="font">
        <template></template>
      </FormItem>
    </Col>
  </div>
</template>

<script>
export default {
  name: 'MyFormItem',
  props: {
    span: '',
    label: '',
    prop: ''
  }
}
</script>

<style scoped>
.font /deep/ .ivu-form-item-label {
  font-size: 16px;
}
</style>
