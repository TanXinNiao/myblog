import Vue from 'vue'
import App from './App.vue'
import router from './router'
import './plugins/element.js'
import axios from 'axios'
import './assets/css/global.css'
import './assets/css/font-awesome-4.7.0/css/font-awesome.css'
import './assets/css/layui/css/layui.css'

Vue.config.productionTip = false

Vue.prototype.$bus = new Vue()
axios.defaults.baseURL = 'http://localhost:8181'
Vue.prototype.$http = axios

new Vue({
  router,
  render: h => h(App)
}).$mount('#app')
