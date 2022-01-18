<template>
  <Modal :value="isShow" width="800" @on-cancel="cancel" title="新增日常上报" :styles="{height:'1000px'}" :closable = "false">
    <Form :label-width="80" label-position="right">
      <Row>
        <MyFormItem label="客户" :span="12">
          <Input style="width: 80%" v-model="custom" search enter-button @on-search="searchCustom"/>
        </MyFormItem>
        <MyFormItem label="工作人员" span="12">
          <Input style="width: 80%" search @on-search="searchServicePerson" enter-button/>
        </MyFormItem>
        <MyFormItem label="服务类型" span="12">
          <Select style="width: 80%">
            <!--            <Option></Option>-->
          </Select>
        </MyFormItem>
        <MyFormItem label="服务费" span="12">
          <Input style="width: 50%">
            <span slot="append">元</span>
          </Input>
        </MyFormItem>
        <MyFormItem label="服务地址" span="12">
          <Input placeholder="Enter something..." style="width: 80%"/>
        </MyFormItem>
        <MyFormItem label="服务时间" span="12">
          <DatePicker type="date" confirm placement="bottom-end" placeholder="Select date"
                      style="width: 80%"></DatePicker>
        </MyFormItem>
      </Row>
    </Form>
    <SelectServicePerson :isShow="selectServicePersonShow" @on-callback="callBack"></SelectServicePerson>
    <SelectCustom :isShow="selectCustomShow" @on-callback="callBack"></SelectCustom>
  </Modal>
</template>

<script>
import MyFormItem from '../../common/utils/MyFormItem'
import SelectServicePerson from './selectServicePerson'
import SelectCustom from './selectCustom'

export default {
  name: 'add',
  components: {
    SelectCustom,
    SelectServicePerson,
    MyFormItem
  },
  props: {
    isShow: {
      type: Boolean,
      default: false
    }
  },
  data () {
    return {
      selectCustomShow: false,
      selectServicePersonShow: false,
      entity: {
        custom: [],
        servicePeople: [],
        serviceType: '',
        money: '',
        address: '',
        createDate: ''
      }
    }
  },
  methods: {
    handleClear () {
    },
    cancel () {
      this.$emit('on-callback')
    },
    searchServicePerson () {
      this.selectServicePersonShow = true
    },
    searchCustom () {
      this.selectCustomShow = true
    },
    callBack () {
      this.selectServicePersonShow = false
      this.selectCustomShow = false
    }
  }
}
</script>

<style scoped>

</style>
