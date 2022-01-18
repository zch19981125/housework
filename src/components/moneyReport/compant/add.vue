<template>
  <modal title="新增日常上报" v-model="isShow" @on-cancel="cancel" :closable="false">
    <Form :label-width="100" label-position="right">
      <MyFormItem label="费用名称">
        <Input style="width: 80%"></Input>
      </MyFormItem>
      <MyFormItem label="费用类型">
        <Select style="width: 80%"></Select>
      </MyFormItem>
      <MyFormItem label="费用">
        <Input style="width: 80%"></Input>
      </MyFormItem>
      <MyFormItem label="持续日期">
        <DatePicker style="width: 80%"></DatePicker>
      </MyFormItem>
    </Form>
  </modal>
</template>

<script>
import MyFormItem from '../../common/utils/MyFormItem'
export default {
  name: 'reportAdd',
  components: {
    MyFormItem
  },
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
