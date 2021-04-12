<template>
    <div class="login-box" :style="loginBox==0?'display:none':'display:block'">
        <form class="box" action="">
            <h1>欢迎来到贪心鸟的博客！</h1>
            <input type="text" v-model="username" name="" placeholder="用户名">
            <input type="password" v-model="password" name="" placeholder="密码">
            <div class="warn" :style="isWarn==0?'display:none':'display:block'">{{warnMessage}}</div>
            <input type="submit" name="" value="登录" @click="login">
        </form>
    </div>
</template>

<script>
export default {
    props: ['loginBox'],
    props:{
        loginBox :0
    },
    data(){
        return{
            username: '',
            password: '',
            isWarn: 0,
            warnMessage: '用户名不能为空！'
        }
    },
    methods:{
        login(){
        
            if(this.username.length == 0){
                this.isWarn = 1;
                this.warnMessage = '用户名不能为空！';
                return;
            }
            if(this.password.length == 0){
                this.isWarn = 1;
                this.warnMessage = '密码不能为空！';
                return;
            }
            if(this.username.length < 2){
                this.isWarn = 1;
                this.warnMessage = '用户名的长度最小为2！';
                return;
            }
            if(this.username.length > 6){
                this.isWarn = 1;
                this.warnMessage = '用户名的长度最大不超过6！';
                return;
            }
            if(this.password.length < 6){
                this.isWarn = 1;
                this.warnMessage = '密码的长度最小为6！';
                return;
            }
            if(this.password.length > 16){
                this.isWarn = 1;
                this.warnMessage = '密码的长度最大不超过16！';
                return;
            }
            this.$http.post('/loginVerify', {
                username: this.username,
                password: this.password
            }).then((response) => {
                if(response.data == 'success'){
                    this.$bus.$emit('loginSuccess', 1)
                    this.$bus.$emit('sendLoginTo', 0)
                }
            })
            this.isWarn = 0;
        }
    }
}
</script>

<style Lang="less" scoped>
.login-box{
    width: 300px;
    padding: 40px;
    position: absolute;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);
    background: #191919;
    opacity: 0.8;
    text-align: center;
    z-index: 3;
}
.box{
    
}
.box h1{
    color: white;
    text-transform: uppercase;
    font-weight: 500;
    padding-bottom: 14px;
}
.box input[type = "text"],.box input[type="password"]{
    border: 0;
    background: none;
    display: block;
    margin: 20px auto;
    text-align: center;
    border: 2px solid #3498db;
    padding: 14px 10px;
    width: 200px;
    outline: none;
    color: white;
    border-radius: 24px;
    transition: 0.25s;
}
.box input[type = "text"]:focus, .box input[type = "password"]:focus{
    width: 280px;
    border-color: #2ecc71;
}
.box input[type = "submit"]{
    border: 0;
    background: none;
    display: block;
    margin: 20px auto;
    width: 116px;
    text-align: center;
    border: 2px solid #2ecc71;
    padding: 14px 40px;
    outline: none;
    color: white;
    border-radius: 24px;
    transition: 0.25s;
    cursor: pointer;
}
.box input[type = "submit"]:hover{
    background: #2ecc71;
}
.warn{
    color: red;
    font-weight: 600;
}
</style>