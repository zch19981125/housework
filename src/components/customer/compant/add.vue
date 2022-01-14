<template>
  <modal v-model="isShow" @on-cancel="cancel">
    <Form>
      <FormItem label="客户名称">
      </FormItem>
      <FormItem label="客户地址"></FormItem>
      <FormItem label="客服年龄"></FormItem>
      <FormItem label="客户性别"></FormItem>
      <FormItem label="客户电话"></FormItem>
      <FormItem label="客户身份证号"></FormItem>
    </Form>
  </modal>
</template>

<script>
export default {
  name: 'customerAdd',
  props: {
    isShow: Boolean,
    default: false
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
