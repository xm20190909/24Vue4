<template>
    <div id="register">
        <p>
            <Input type="text" prefix="ios-contact" placeholder="用户名" v-model="Uname" @on-blur="check1()"/>
            <span v-show="showErr1">{{err1}}</span>
        </p>
        <p>
            <Input type="password" prefix="md-lock" placeholder="密码" v-model="Pword" @on-blur="check2()"/>
            <span v-show="showErr2">{{err2}}</span>
        </p>
        <p>
            <Input type="password" prefix="md-lock" placeholder="确认密码" v-model="Cword" @on-blur="check3()"/>
            <span v-show="showErr3">{{err3}}</span>
        </p>
        <Button type="primary" @click="doRegister()">注册</Button>
        <Button type="primary" @click="reSet()">重置</Button>
    </div>
</template>

<script>
    import axios from 'axios'
    export default {
        name: "Register",
        data(){
            return{
                err1:'',
                err2:'密码需为6-16位字符',
                err3:'两次密码不一致',
                showErr1:false,
                showErr2:false,
                showErr3:false,
                Uname:'',
                Pword:'',
                Cword:''
            }
        },
        methods: {
            check1() {
                if (this.Uname == '') {
                    this.err1 = '用户名不能为空';
                    this.showErr1 = true;
                } else {
                    axios.get('http://localhost:8080/api/isexist', {params: {username: this.Uname}})
                        .then((res) => {
                            if (res.data) {
                                this.err1 = '用户名已存在';
                                this.showErr1 = true;
                            }else {
                                this.showErr1 = false;
                            }
                            }
                        )
                }
                return this.showErr1;
            },
            check2() {
                var reg = new RegExp(/^\w{6,16}$/)
                if (!reg.test(this.Pword)) {
                    this.showErr2 = true;
                }else{
                    this.showErr2 = false;
                }
                return this.showErr2;
            },
            check3() {
                if (!(this.Pword == this.Cword)) {
                    this.showErr3 = true;
                }else {
                    this.showErr3 = false;
                }
                return this.showErr3;
            },
            checkAll(){
                if (this.check1()==false&&this.check2()==false&&this.check3()==false){
                    return true;
                }else {
                    return false;
                }
            },
            doRegister(){
                if (this.checkAll()){
                    axios.post('http://localhost:8080/api/register',
                        {username:this.Uname,password:this.Pword})
                        .then((res)=>{
                            if (res.data){
                                alert("注册成功，将跳转到登录页面");
                                this.$router.push('/login');
                            }
                        })
                }
            },
            reSet(){
                this.Uname = '';
                this.Pword = '';
                this.Cword = '';
                this.showErr1 = false;
                this.showErr2 = false;
                this.showErr3 = false;
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