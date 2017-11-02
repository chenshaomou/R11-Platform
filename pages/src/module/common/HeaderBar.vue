<template>
    <Breadcrumb separator=">">
        <BreadcrumbItem href="/">Home</BreadcrumbItem>
        <BreadcrumbItem href="/components/breadcrumb">Components</BreadcrumbItem>
        <BreadcrumbItem>Breadcrumb</BreadcrumbItem>
    </Breadcrumb>
</template>

<script>
  import {mapState} from 'vuex'

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
