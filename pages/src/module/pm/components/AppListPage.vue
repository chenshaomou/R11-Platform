<!--Created by 熊超超 on 2017/8/4.-->
<template>
  <div>
    <Button>
      <router-link :to="{ name: 'newAppPage'}">新增</router-link>
    </Button>
  </div>
</template>

<script>
  import {mapState} from 'vuex'

  export default {
    data() {
      return {

      }
    },
    computed: {
      ...mapState({
        flight: state => state.demo.todos
      })
    },
    methods: {

    }
  }
</script>

<style lang="less" scoped>
</style>
