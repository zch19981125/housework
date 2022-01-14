<template>
  <modal v-model="isShow" @on-cancel="cancel">
    <Form>
      <FormItem label="费用名称">
      </FormItem>
      <FormItem label="费用类型"></FormItem>
      <FormItem label="费用"></FormItem>
      <FormItem label="持续日期"></FormItem>
    </Form>
  </modal>
</template>

<script>
export default {
  name: 'reportAdd',
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
