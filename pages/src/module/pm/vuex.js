/**
 * Created by 熊超超 on 2017/8/4.
 */
import api from './api'

export default {
  state: {
  },
  mutations: {},
  actions: {
    addnewApp ({state, commit, rootState}, params) {
      return api.addNewApp(params).then(data => {
      }).catch(e => {
      })
    }
  },
  getters: {}
}
