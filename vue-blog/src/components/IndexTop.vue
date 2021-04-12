<template>
    <div class="top">
        <div class="top-nav">
            <ul class="top-nav-list">
                <li class="item-author item"><a><i></i>作者:贪心鸟</a></li>
                <li class="item-home item"><a href="">首页</a></li>
                <li class="item"><a href="">爱学习</a></li>
                <li class="item"><a href="">微动态</a></li>
                <li class="item"><a href="">工具集</a></li>
                <li class="item"><a href="">关于我</a></li>
                <li class="item"><a href="">留言板</a></li>
            </ul>
            <div class="top-right">
                <div class="login-block" :style="isLogin==0?'display:block':'display:none'">
                    <a href="javascript:;" @click="sendLogin">登录</a>
                    <span></span>
                    <a href="javascript:;">注册</a>
                </div>
                <div class="avatar" :style="isLogin==1?'display:block':'display:none'">
                    
                </div>
                <div class="search-block">
                    <input type="text" class="search-input" placeholder="在这里输入..">
                    <a href="javascript:;"><i></i></a>

                </div>
            </div>
        </div>
    </div>
</template>

<script>

export default {
    data(){
        return{
            isLogin: 0
        }
    },
    created(){
        this.$bus.$on('loginSuccess', this.loginSuccess)
    },
    methods:{
        sendLogin(){
            this.$bus.$emit('sendLoginTo', 1)
        },
        loginSuccess(e){
            this.isLogin = e
        }
    }
}
</script>

<style Lang="less" scoped>

/*从这里开始写css*/
.top{
    box-shadow: 0 2px 6px 0 rgba(0,0,0,.17);
    background-color: white;
}
.top-nav{
    width: 980px;
    height: 84px;
    margin: 0 auto;
}
.top-nav-list{
    float:left;
    font-size: 0;
}
.top-nav-list .item{
    float: left;
    margin: 20px 10px;

}
.top-nav-list .item a{
    font-size: 14px;
    padding: 15px 15px;
    background-color: aqua;
    border-top-left-radius: 40px;
    border-bottom-right-radius: 40px;
}
.top-nav-list .item-author{
    margin: 20px 0 20px 20px;
}
.top-nav-list .item-author a{
    position: relative;
    padding: 15px 0 15px 30px;
    background-color: white;
}

.top-nav-list .item-author i{
    position: absolute;
    display: block;
    background: url(../assets/img/头像.jpg) no-repeat 0 0;
    background-size: 100% 100%;
    width: 20px;
    height: 20px;
    top: 12px;
    left: 5px;
}

.top-right{
    float: right;
}

.login-block{
    float: right;
    margin: 20px 0;
}

.login-block a{
    float: left;
    font-size: 14px;
    padding: 15px 5px;
}

.login-block span{
    float: left;
    border-left:  1px #333 solid;
    height: 12px;
    margin: 15px 5px;
}

.avatar{
    float: right;
    width: 36px;
    height: 36px;
    background: url(../assets/img/头像.jpg) no-repeat 0 0;
    background-size: 100% 100%;
    border-radius: 36px;
    margin: 20px 0 auto 20px;
}

.search-block{
    float: right;
    position: relative;
    margin-right: 5px;
}

.search-input{
    float: right;
    width: 80px;
    height: 22px;
    border-radius: 20px;
    margin: 29px 0;
    padding: 0 15px;
    border: 2px solid #ccc;
    animation-name: search-input;
    animation-duration: 1s;
    animation-iteration-count: infinite;
    animation-timing-function: ease-in;
    animation-direction: alternate;
}

.search-input:hover{
    animation-play-state: paused;
}

.search-block i{
    position: absolute;
    display: block;
    width: 20px;
    height: 20px;
    right: 9px;
    top: 32px;
    background: url(../assets/img/page_icons.png) no-repeat -660px -728px;
}

@keyframes search-input {
    0%   {
        border-color: #ccc;
    }
    25%  {
        border-color: #ccc;
        border-top-color: rgb(9, 136, 158);
    }
    50%  {
        border-color: #ccc;
        border-top-color: rgb(9, 136, 158);
        border-right-color: rgb(9, 136, 158);
    }
    75%  {
        border-color: rgb(9, 136, 158);
        border-left-color: #ccc;
    }
    100% {
        border-color: rgb(9, 136, 158);
        animation-delay: 1s;
    }
}
</style>
