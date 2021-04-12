<template>
  <div class="home">
    <IndexTop/>
    <IndexContent/>
    <Login :loginBox="loginBox"/>
    <!--点击登录后背景半透明处理-->
    <div class="back" :style="loginBox==0?'display:none':'display:block'"></div>
  </div>
</template>

<script>
import IndexTop from '@/components/IndexTop.vue'
import IndexContent from '@/components/IndexContent.vue'
import HelloWorld from '../components/HelloWorld.vue'
import Login from '../components/Login.vue'

export default {
  name: 'Home',
  created(){
    this.$bus.$on('sendLoginTo', this.getLogin)
  },
  methods:{
    getLogin(e){
      this.loginBox = e;
    }
  },
  data: function(){
    return{
      stus:[
        {id:1, name:"zr", age:10},
        {id:2, name:"zr2", age:11},
        {id:3, name:"zr3", age:12}
      ],
      loginBox: 0
    }
  },
  components: {
    IndexTop,
    IndexContent,
    Login,
    HelloWorld
  }
}
</script>
<style Lang="less" scoped>
.back{
  position:absolute;
  left:0;
  top:0;
  width:100%;
  height:2000px;
  background: #000;
  opacity: 0.5;
  z-index: 2;
}
</style>
