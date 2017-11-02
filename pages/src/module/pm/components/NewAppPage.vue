<template>
    <div>
    新增一个iOS应用
        <Form ref="form" :model="form" :label-width="80">
            <FormItem label="git地址" prop="name">
                <Input type="text" v-model="form.name"></Input>
            </FormItem>
            <FormItem label="git地址" prop="description">
                <Input type="text" v-model="form.description"></Input>
            </FormItem>
            <FormItem label="git地址" prop="gitUrl">
                <Input type="text" v-model="form.gitUrl"></Input>
            </FormItem>
            <FormItem label="git用户名" prop="gitName">
                <Input type="text" v-model="form.gitName"></Input>
            </FormItem>
            <FormItem label="git密码" prop="gitPasswd">
                <Input type="password" v-model="form.gitPasswd"></Input>
            </FormItem>
            <FormItem>
                <Button type="primary" @click="handleSubmit('form')">提交</Button>
                <Button type="ghost" @click="handleReset('form')" style="margin-left: 8px">重置</Button>
            </FormItem>
        </Form>
    </div>
</template>

<script>
  import {mapState} from 'vuex'

  export default {
    components: {},
    data() {
      return {
        form: {
          name: 'iOS',
          description: 'iOS项目',
          gitUrl: 'https://github.com/chenshaomou/R11-Platform.git',
          gitName: 'color1986.chen@gmail.com',
          gitPasswd: 'color1986'
        }
      }
    },
    computed: {
      ...mapState([])
    },
    methods: {
      handleSubmit() {
        this.$store.dispatch('addnewApp', this.form)
      },
      handleReset() {
      }
    }
  }
</script>

<style scoped>
</style>
