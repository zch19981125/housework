<template>
  <Modal
      v-model="isShow"
      title="新增日常上报"
      width="800">
    <div>
      <Form :label-width="100" label-position="right">
        <Row>
          <FormItem label="姓名" span="12">
            <Input v-model="entity.name" style="width: 80%"></Input>
          </FormItem>
          <FormItem label="擅长" :span="12">
            <Select multiple  v-model="entity.dicts" style="width: 80%">
              <Option v-for="(item,i) in serviceDicts" :key="i" :value="item.id">{{ item.name }}</Option>
            </Select>
          </FormItem>
          <FormItem label="性别" :span="12">
            <RadioGroup v-model="entity.sex" type="button">
              <Radio label="1" :value="1">男</Radio>
              <Radio label="0" :value="2">女</Radio>
            </RadioGroup>
          </FormItem>
          <FormItem label="年龄" :span="12">
            <div class="center" style="margin-left: -40%">
              <InputNumber v-model="entity.age"></InputNumber>
              <span>岁</span>
            </div>
          </FormItem>
          <FormItem label="家庭住址" :span="12">
            <Input v-model="entity.address" style="width: 80%"></Input>
          </FormItem>
          <FormItem label="身份证号" :span="12">
            <Input v-model="entity.identityNum" style="width: 80%"></Input>
          </FormItem>
          <FormItem label="身份证正面" :span="12"></FormItem>
          <FormItem label="身份证反面" :span="12"></FormItem>
        </Row>
      </Form>
    </div>
    <div slot="footer">
      <Button @click="cancel" type="default">取消</Button>
      <Button @click="handleOk" :loading="buttonLoading" type="primary">确定</Button>
    </div>
  </Modal>
</template>

<script>
import FormItem from '../../common/utils/MyFormItem'
import {listServiceDict} from '../../common/api/DictApi'
import {responseHandle} from '../../common/utils/response'
import {add} from '../../common/api/servicePeople'

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
  data () {
    return {
      serviceDicts: [],
      entity: {
        dicts: [],
        age: 0
      },
      buttonLoading: false
    }
  },
  methods: {
    cancel () {
      this.$emit('on-callback')
      this.entity = {}
      this.entity.age = 0
    },
    handleOk () {
      this.buttonLoading = true
      add(this.entity).then(res => {
        if (responseHandle(res)) {
          this.$Message.success('添加成功')
          this.$emit('on-callback', true)
          this.entity = {}
          this.entity.age = 0
        } else {
          this.$Message.error(res.data.msg)
        }
        this.buttonLoading = false
      })
    },
    handleSelectServiceType () {
      listServiceDict(1).then(res => {
        if (responseHandle(res)) {
          this.serviceDicts = res.data.body
        }
      })
    }
  },
  mounted () {
    this.handleSelectServiceType()
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
