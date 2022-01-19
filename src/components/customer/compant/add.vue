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
          <Radio label="1">男</Radio>
          <Radio label="0">女</Radio>
        </RadioGroup>
      </FormItem>
      <FormItem label="客户电话">
        <Input v-model="entity.telephone" style="width: 80%"></Input>
      </FormItem>
      <FormItem label="身份证号">
        <Input v-model="entity.identityNum" style="width: 80%" placeholder="非必填"></Input>
      </FormItem>
    </Form>
    <div slot="footer">
      <Button @click="cancel" type="default">取消</Button>
      <Button @click="handleOk()" :loading="buttonLoading" type="primary">确定</Button>
    </div>
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
        age: 0,
        sex: '',
        telephone: '',
        identityNum: ''
      },
      buttonLoading: false
    }
  },
  methods: {
    cancel () {
      this.entity = {}
      this.$emit('on-callback')
    },
    handleOk () {
      this.buttonLoading = true
      addCustom(this.entity).then(res => {
        if (responseHandle(res)) {
          this.$Message.success('添加成功')
          this.entity = {}
          this.$emit('on-callback', true)
        } else {
          this.$Message.error('添加失败')
        }
        this.buttonLoading = false
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
