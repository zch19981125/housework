<template>
  <Modal
      v-model="isShow"
      title="新增日常上报"
      width="800"
      @on-cancel="cancel">
    <div>
      <Form>
        <Row>
          <FormItem label="姓名" span="12"></FormItem>
          <FormItem label="擅长" :span="12"></FormItem>
          <FormItem label="性别" :span="12"></FormItem>
          <FormItem label="年龄" :span="12"></FormItem>
          <FormItem label="家庭住址" :span="12"></FormItem>
          <FormItem label="身份证号" :span="12"></FormItem>
          <FormItem label="身份证正面" :span="12"></FormItem>
          <FormItem label="身份证反面" :span="12"></FormItem>
        </Row>
      </Form>
    </div>
  </Modal>
</template>

<script>
import FormItem from '../../common/utils/MyFormItem'

export default {
  name: 'AddServicePeople',
  components: {
    FormItem
  },
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
