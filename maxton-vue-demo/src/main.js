// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import Element from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import axios from 'axios';

Vue.use(Element, axios);
Vue.config.productionTip = false

axios.defaults.baseURL = 'http://172.18.113.190:9090';
Vue.prototype.$axios = axios

// 引入echarts
import echarts from 'echarts'
Vue.prototype.$echarts = echarts


/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})
