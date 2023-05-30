import Vue, { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import BootstrapVue3 from 'bootstrap-vue-3'
import Toast from 'vue-toastification'

import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'
import 'vue-toastification/dist/index.css'

createApp(App)
	.use(Toast, {
		transition: 'Vue-Toastification__fade',
		maxToasts: 10,
		newestOnTop: true,
	})
	.use(BootstrapVue3)
	.use(router)
	.mount('#app')
