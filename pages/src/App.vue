<!--Created by 熊超超 on 2017/8/4.-->
<template>
  <div id="app" flex='dir:left main:left box:first'>
    <div>
      <side-bar></side-bar>
    </div>
    <div flex='dir:top'>
      <div flex-box="0">
        <header-bar></header-bar>
      </div>
      <div flex-box="1">
        <router-view></router-view>
      </div>
      <div flex-box="0">
        底部
      </div>
    </div>
  </div>
</template>

<script>
  import {mapState} from 'vuex'
  import HeaderBar from './module/common/HeaderBar.vue'
  import FooterBar from './module/common/FooterBar.vue'
  import SideBar from './module/common/SideBar.vue'
  import Loading from '$bc/Loading'
  import MyDialog from '$bc/MyDialog'

  export default {
    data() {
      return {}
    },
    components: { SideBar, HeaderBar, FooterBar, Loading, MyDialog },
    computed: {
      ...mapState(['toast', 'headerBar', 'footerBar'])
    },
    methods: {}
  }
</script>
<style lang="less">
  @import "./assets/css/animate.css";
</style>
