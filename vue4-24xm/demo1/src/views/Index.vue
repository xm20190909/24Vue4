<template>
    <div class="index">
        <nav>
            <router-link to="/login">登录</router-link>
            <router-link to="/register">注册</router-link>
        </nav>
        <div class="main">
            <h2>欢迎进入我们的MALL</h2>
        </div>
    </div>
</template>

<script>
    export default {
        name: "Index",
        mounted(){
            if (this.$cookies.isKey('username')) {
                let loginuser = this.$cookies.get('username')
                this.$store.commit('setLoginUser',loginuser);
                this.$router.push('/productlist');
            }
        }
    }
</script>

<style scoped>
    .index{width:1100px; height:100%; background:deepskyblue; margin:0 auto;}
    .main{display:flex; align-items: center; justify-content: center; height:90%;}
    .main h2{color:white; font-size:48px;}
    nav {
        display:flex;
        height:10%;
        flex-direction: row;
        align-items:center;
        justify-content: center;
    }
    nav a {
        font-weight: bold;
        color: white;
        margin-right:20px;
        text-decoration:none;
    }
</style>