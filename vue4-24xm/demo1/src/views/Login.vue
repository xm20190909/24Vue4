<template>
    <div>
        <p>
            <Input type="text" prefix="ios-contact" placeholder="用户名" v-model="username"/>
        </p>
        <p>
            <Input type="password" prefix="md-lock" placeholder="密码" v-model="password"/>
        </p>
        <Button type="primary" @click="doLogin()">登录</Button>
        <Button type="primary" @click="reSet()">重置</Button>
    </div>
</template>

<script>
    import axios from 'axios'
    export default {
        name: "Login",
        data() {
            return {
                username:'',
                password:''
            }
        },
        methods: {
            doLogin(){
                axios.post('http://localhost:8080/api/login',{username:this.username,password:this.password})
                    .then((res)=>{
                        if (res.data) {
                            this.$store.commit('setLoginUser',this.username);
                            this.$router.push('/productlist');
                        } else{
                            alert('用户名或密码错误，请重新输入');
                            this.username = '';
                            this.password = '';
                        }
                    })
            },
            reSet(){
                this.username = '';
                this.password = '';
            }
        }
    }
</script>

<style scoped>
    p{
        margin: 10px;
    }
    p > *{
        width: 200px;
    }
    button {
        margin: 10px;
    }
</style>