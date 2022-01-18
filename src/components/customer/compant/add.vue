<template>
  <modal title="新增客户" :value="isShow" @on-cancel="cancel">
    <Form :label-width="120">
      <FormItem label="客户名称">
        <Input v-model="entity.name" style="width: 80%"></Input>
      </FormItem>
      <FormItem label="客户地址">
        <Input v-model="entity.address" style="width: 80%"></Input>
      </FormItem>
      <FormItem label="客服年龄">
        <div class="center">
          <InputNumber v-model="entity.age"></InputNumber>
          <span>岁</span>
        </div>
      </FormItem>
      <FormItem label="客户性别">
        <RadioGroup v-model="entity.sex" type="button" size="large" class="center">
          <Radio label="男"></Radio>
          <Radio label="女"></Radio>
        </RadioGroup>
      </FormItem>
      <FormItem label="客户电话">
        <Input v-model="entity.telephone" style="width: 80%"></Input>
      </FormItem>
      <FormItem label="身份证号">
        <Input v-model="entity.identityNum" style="width: 80%" placeholder="非必填"></Input>
      </FormItem>
    </Form>
  </modal>
</template>

<script>
import FormItem from '../../common/utils/MyFormItem'
import {addCustom} from '../../common/api/CustomApi'
import {responseHandle} from '../../common/utils/response'

export default {
  name: 'customerAdd',
  components: {
    FormItem
  },
  props: {
    isShow: Boolean,
    default: false
  },
  data () {
    return {
      entity: {
        name: '',
        address: '',
        age: '',
        sex: '',
        telephone: '',
        identityNum: ''
      }
    }
  },
  methods: {
    cancel () {
      this.$emit('on-callback')
    },
    add () {
      addCustom(this.entity).then(res => {
        if (responseHandle(res)) {
          this.$Message.success('添加成功')
        } else {
          this.$Message.error('添加失败')
        }
      })
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
