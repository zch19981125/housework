<template>
  <modal title="新增客户" v-model="isShow" @on-cancel="cancel">
    <Form label-width="120">
      <FormItem label="客户名称">
        <Input style="width: 80%"></Input>
      </FormItem>
      <FormItem label="客户地址">
        <Input style="width: 80%"></Input>
      </FormItem>
      <FormItem label="客服年龄">
        <div class="center">
          <InputNumber></InputNumber>
          <span>岁</span>
        </div>
      </FormItem>
      <FormItem label="客户性别">
        <RadioGroup type="button" size="large" class="center">
          <Radio label="男"></Radio>
          <Radio label="女"></Radio>
        </RadioGroup>
      </FormItem>
      <FormItem label="客户电话">
        <Input style="width: 80%"></Input>
      </FormItem>
      <FormItem label="身份证号">
        <Input style="width: 80%" placeholder="非必填"></Input>
      </FormItem>
    </Form>
  </modal>
</template>

<script>
import FormItem from '../../common/utils/MyFormItem'

export default {
  name: 'customerAdd',
  components: {
    FormItem
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
.center {
  width: 50%;
  position: absolute;
  left: 50%;
  margin-left: -35%;
}

</style>
