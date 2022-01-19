<template>
  <Modal :value="isShow" width="800" @on-cancel="cancel" title="新增日常上报" :styles="{height:'1000px'}" :closable="false">
    <Form :label-width="80" label-position="right">
      <Row>
        <MyFormItem label="客户" :span="12">
          <Input style="width: 80%" v-model="custom" search enter-button @on-search="searchCustom"/>
        </MyFormItem>
        <MyFormItem label="工作人员" span="12">
          <Input style="width: 80%" v-model="servicePeople" search @on-search="searchServicePerson" enter-button/>
        </MyFormItem>
        <MyFormItem  label="服务类型" span="12">
          <Select v-model="entity.dictId" style="width: 80%">
            <Option v-for="(item,i) in serviceDicts" :key="i" :value="item.id">{{ item.name }}</Option>
          </Select>
        </MyFormItem>
        <MyFormItem label="服务费" span="12">
          <Input v-model="entity.money" style="width: 50%">
            <span slot="append">元</span>
          </Input>
        </MyFormItem>
        <MyFormItem label="服务地址" v-model="entity.address" span="12">
          <Input v-model="entity.address" placeholder="Enter something..." style="width: 80%"/>
        </MyFormItem>
        <MyFormItem label="服务时间" span="12">
          <DatePicker type="date"  format="yyyy-MM-dd" v-model="entity.serviceDate" confirm placement="bottom-end" placeholder="Select date"
                      style="width: 80%"></DatePicker>
        </MyFormItem>
      </Row>
    </Form>
    <SelectServicePerson :isShow="selectServicePersonShow" @on-callback="callBack1"></SelectServicePerson>
    <SelectCustom :isShow="selectCustomShow" @on-callback="callBack2"></SelectCustom>
    <div slot="footer">
      <Button @click="cancel" type="default">取消</Button>
      <Button @click="handleOk()" :loading="buttonLoading" type="primary">确定</Button>
    </div>
  </Modal>
</template>

<script>
import MyFormItem from '../../common/utils/MyFormItem'
import SelectServicePerson from './selectServicePerson'
import SelectCustom from './selectCustom'
import {listServiceDict} from '../../common/api/DictApi'
import {responseHandle} from '../../common/utils/response'
import {addService} from '../../common/api/ServicePeopleApi'

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
        customId: '',
        servicePeopleId: [],
        dictId: '',
        money: '',
        address: '',
        serviceDate: ''
      },
      serviceDicts: [],
      custom: '',
      servicePeople: '',
      buttonLoading: false
    }
  },
  methods: {
    handleClear () {
      this.entity = {}
      this.custom = ''
      this.servicePeople = ''
    },
    cancel () {
      this.handleClear()
      this.$emit('on-callback')
    },
    handleOk () {
      this.buttonLoading = true
      addService(this.entity).then(res => {
        if (responseHandle(res)) {
          this.$Message.success('添加成功')
          this.handleClear()
          this.$emit('on-callback', true)
        } else {
          this.$Message.error(res.data.msg)
        }
        this.buttonLoading = false
      })
    },
    searchServicePerson () {
      this.selectServicePersonShow = true
    },
    searchCustom () {
      this.selectCustomShow = true
    },
    callBack1 (sureEntity) {
      debugger
      this.selectServicePersonShow = false
      this.selectCustomShow = false
      if (sureEntity instanceof Array && sureEntity.length > 0) {
        console.log(sureEntity)
        let i = 0
        let n = ''
        let ids = []
        while (i < sureEntity.length) {
          n = n + sureEntity[i].name
          ids.push(sureEntity[i].id)
          i = i + 1
        }
        this.servicePeople = n
        this.entity.servicePeopleId = ids
      } else {
        this.servicePeople = ''
        this.entity.servicePeopleId = []
      }
    },
    callBack2 (sureEntity) {
      this.selectServicePersonShow = false
      this.selectCustomShow = false
      if (!(sureEntity instanceof Array) && sureEntity.name && sureEntity.id) {
        console.log(sureEntity)
        this.custom = sureEntity.name
        this.entity.customId = sureEntity.id
      } else {
        this.custom = ''
        this.entity.customId = ''
      }
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

</style>
