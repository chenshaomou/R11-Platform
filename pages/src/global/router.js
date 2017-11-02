/**
 * Created by 熊超超 on 2017/8/4.
 */
import Vue from 'vue'
import Router from 'vue-router'

import common from '../module/common/router'
import pm from '../module/pm/router'

Vue.use(Router)

const router = new Router({
  routes: [
    ...common,
    ...pm,
    {
      path: '*',
      redirect: '/'
    }
  ]
})
export default router
