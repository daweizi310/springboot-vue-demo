import Vue from 'vue'
import Router from 'vue-router'
import index from '@/views/index'
import toTestList from '@/views/toTestList'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'index',
      component: index
    },
    {
      path: '/toTestList',
      name: 'toTestList',
      component: toTestList
    }
  ]
})
