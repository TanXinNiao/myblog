<template>
  <div class="about">
    <h1>This is an about page</h1>
  </div>
</template>

<template>
    <div class="content-left">
      <div class="articles">
        <div class="article">
          <div class="title">
            <span>MQ</span>
            <i></i>
            <a>Hello World!!!</a>
          </div>
          <div class="article-center">
            <div class="article-img"><a href=""></a></div>
            <div class="note">
              Redis 作为一个基于内存的高性能数据库，必须的有对应的持久化机制，否则
              一旦出现宕机，那数据可就全完了。即使有持久化机制，遇到宕机也要妥善处理，
              恢复数据，所以本篇文章探讨 Redis 的持久化机制
            </div>
          </div>
          <div class="article-bottom">
            <ul>
              <li class="item"><i></i><a href="">name</a></li>
              <li class="item"><i></i><a href="">2021-03-23</a></li>
              <li class="item item-with-count"><i></i><span>21</span><a href="">浏览</a></li>
              <li class="item item-with-count"><i></i><span>22</span><a href="">评论</a></li>
              <li class="item item-with-count"><i></i><span>23</span><a href="">赞</a></li>
            </ul>
          </div>
        </div>
      </div>
    </div>
</template>

<script>
export default {
  name: 'IndexContentL',
  data: function(){
    return{
      stus:[
        {id:1, name:"zr", age:10},
        {id:2, name:"zr2", age:11},
        {id:3, name:"zr3", age:12},
        {id:4, name:"zr3", age:12},
        {id:5, name:"zr3", age:12},
        {id:6, name:"zr3", age:12},
        {id:7, name:"zr3", age:12},
        {id:8, name:"zr3", age:12},
        {id:9, name:"zr3", age:12},
        {id:10, name:"zr3", age:12},
        {id:11, name:"zr3", age:12},
        {id:12, name:"zr3", age:12},
        {id:13, name:"zr3", age:12},
        {id:14, name:"zr3", age:12}
      ]
    }
  }
}

</script>

<style Lang="less" scoped>
.content-left{
  float: left;
}
.articles{
  float: left;
  width: 630px;
}

.article{
  float: left;
}

.article .title{
  float: left;
  width: 100%;
}

.article .title span{
  float: left;
}


.article .title i{
  float: left;
  height: 120px;
  width: 120px;
  display: block;
}

.article .title i:before{
  content: \f007;
  font-family: FontAwesome;
  font-size: 120px;
}

.article .title a{
  float: left;
}


.article-center{
  float: left;
  width: 100%;
}

.article-bottom{
  float: left;
  width: 100%;
}
    
</style>