<template>
  <Modal v-model="isShow" @on-cancel="cancel">
  </Modal>
</template>

<script>
export default {
  name: 'add',
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
