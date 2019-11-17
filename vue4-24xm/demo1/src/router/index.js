import Vue from 'vue'
import VueRouter from 'vue-router'
import Index from '../views/Index.vue'
import Login from '../views/Login.vue'
import Register from '../views/Register.vue'
import ProductList from '../views/ProductList.vue'
import Details from '../views/Details.vue'
import Cart from '../views/Cart.vue'

Vue.use(VueRouter)

const routes = [
    {
        path: '/',
        name: 'index',
        component: Index
    },
    {
        path: '/login',
        name: 'login',
        component: Login
    },
    {
        path: '/register',
        name: 'register',
        component: Register
    },
    {
        path: '/productlist',
        name: 'productlist',
        component: ProductList
    },
    {
        path: '/details',
        name: 'details',
        component: Details
    },
    {
        path: '/cart',
        name: 'cart',
        component: Cart
    }
]

const router = new VueRouter({
    mode: 'history',
    base: process.env.BASE_URL,
    routes
})

export default router
