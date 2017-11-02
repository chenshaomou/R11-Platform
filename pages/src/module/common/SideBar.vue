<template>
  <Menu active-name="1-2" :open-names="['1']">
    <Submenu name="1">
      <template slot="title">
        <Icon type="ios-paper"></Icon>
        产品管理管理
      </template>
      <MenuItem name="1-1">iOS</MenuItem>
      <MenuItem name="1-2">Android</MenuItem>
      <MenuItem name="1-3">H5</MenuItem>
      <MenuItem name="1-3">Java</MenuItem>
    </Submenu>
    <Submenu name="2">
      <template slot="title">
        <Icon type="ios-people"></Icon>
        用户管理
      </template>
      <MenuItem name="2-1">新增用户</MenuItem>
      <MenuItem name="2-2">活跃用户</MenuItem>
    </Submenu>
    <Submenu name="3">
      <template slot="title">
        <Icon type="stats-bars"></Icon>
        统计分析
      </template>
      <MenuGroup title="使用">
        <MenuItem name="3-1">新增和启动</MenuItem>
        <MenuItem name="3-2">活跃分析</MenuItem>
        <MenuItem name="3-3">时段分析</MenuItem>
      </MenuGroup>
      <MenuGroup title="留存">
        <MenuItem name="3-4">用户留存</MenuItem>
        <MenuItem name="3-5">流失用户</MenuItem>
      </MenuGroup>
    </Submenu>
  </Menu>
</template>

<script>
import { mapState } from 'vuex'

export default {
  components: {},
  data() {
    return {}
  },
  computed: {
    ...mapState([])
  },
  methods: {}
}
</script>

<style scoped>

</style>
