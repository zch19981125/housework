<template>
  <Modal
    v-model="isShow"
    title="新增日常上报"
    width="800"
    @on-cancel="cancel">
    <div>
      <Form :label-width="100" label-position="right">
        <Row>
          <FormItem label="姓名" span="12">
            <Input v-model="entity.name" style="width: 80%"></Input>
          </FormItem>
          <FormItem label="擅长" :span="12">
            <Select v-model="entity.dicts" style="width: 80%">
              <Option v-for="(item,i) in serviceDicts" :key="i" :value="item.value">{{ item.name }}</Option>
            </Select>
          </FormItem>
          <FormItem v-model="entity.sex" label="性别" :span="12">
            <RadioGroup type="button" size="large" class="center">
              <Radio :value="1" >男</Radio>
              <Radio :value="0" >女</Radio>
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
  </Modal>
</template>

<script>
import FormItem from '../../common/utils/MyFormItem'
import {listServiceDict} from '../../common/api/DictApi'
import {responseHandle} from '../../common/utils/response'

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
      }
    }
  },
  methods: {
    cancel () {
      this.$emit('on-callback')
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
