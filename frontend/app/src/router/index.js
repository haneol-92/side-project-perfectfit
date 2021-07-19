import Vue from "vue";
import Router from 'vue-router'

Vue.use(Router)

const router = new Router({
    mode: "history",
    routes: [
        {path:'/', component: () => import('../components/Home.vue')},
        {path:'/Login', component: () => import('../components/Login.vue')},
        {path:'/Register', component: () => import('../components/Register.vue')}
    ]
})

export default router

