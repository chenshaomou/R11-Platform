<!--Created by 熊超超 on 2017/8/4.-->
<template>
  <div>
    <p @click="testAsync">demo</p>
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
      async testAsync () {
        const data = await this.$store.dispatch('testAsync')
        console.log(data)
      },
      test () {
        this.$store.dispatch('searchFlight').then(data => {
          this.$router.push('/passenger/list')
        })
      }
    }
  }
</script>

<style lang="less" scoped>
</style>
