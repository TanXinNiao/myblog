
<template>
    <div class="content-left">
      <div class="articles">
        <div class="article" v-for="(article, index) in newArticles"
      :key="article.id">
          <div class="title">
            <span>{{article.tag}}</span>
            <i class="layui-icon layui-icon-triangle-r"></i>
            <a>{{article.title}}</a>
          </div>
          <div class="article-center">
            <div class="article-img" :style="{backgroundImage:'url('+article.imgUrl+')'}"><a href=""></a></div>
            <div class="note">{{article.note}}</div>
          </div>
          <div class="article-bottom">
            <ul>
              <li class="item item-name"><i class="fa fa-user"></i><a href="">作者</a></li>
              <li class="item item-date"><i class="fa fa-clock-o"></i><a href="">{{article.date}}</a></li>
              <li class="item item-view"><i class="fa fa-eye"></i><span>{{article.view}}</span><a href="">浏览</a></li>
              <li class="item item-comment"><i class="fa fa-comment-o"></i><span>{{article.comment}}</span><a href="">评论</a></li>
              <li class="item item-like"><i class="layui-icon layui-icon-praise"></i><span>{{article.like}}</span><a href="">赞</a></li>
            </ul>
          </div>
        </div>
      </div>
      <div class="pagination">
        <a class="prior-page" href="javascript:;" @click="prevPage()"><i class="layui-icon layui-icon-left"></i></a>
        <a class="num" href="javascript:;" v-for="page in showArticles" :key="page" @click="gotoPage(page)">{{page}}</a>
        <a class="next-page" href="javascript:;" @click="nextPage()"><i class="layui-icon layui-icon-left"></i></a>
      </div>
    </div>
</template>

<script>
export default {
  name: 'IndexContentL',
  data: function(){
    return{
      articles:[
        {
          id: 1,
          tag: "Java",
          imgUrl: require("../assets/img/阿狸.jpg"),
          title: "Hello World!!!",
          note: "Redis 作为一个基于内存的高性能数据库，必须的有对应的持久化机制，否则一旦出现宕机，那数据可就全完了。即使有持久化机制，遇到宕机也要妥善处理，恢复数据，所以本篇文章探讨 Redis 的持久化机制",
          author: "作者",
          date: "2021-03-23",
          view: 21,
          comment: 22,
          like: 23
        },
        {
          id: 2,
          tag: "JavaScript",
          imgUrl: require("../assets/img/阿狸.jpg"),
          title: "标题2",
          note: "Redis 作为一个基于内存的高性能数据库，必须的有对应的持久化机制，否则一旦出现宕机，那数据可就全完了。即使有持久化机制，遇到宕机也要妥善处理，恢复数据，所以本篇文章探讨 Redis 的持久化机制",
          author: "作者",
          date: "2021-03-23",
          view: 21,
          comment: 22,
          like: 23
        },
        {
          id: 3,
          tag: "Java",
          imgUrl: require("../assets/img/阿狸.jpg"),
          title: "Hello World!!!",
          note: "Redis 作为一个基于内存的高性能数据库，必须的有对应的持久化机制，否则一旦出现宕机，那数据可就全完了。即使有持久化机制，遇到宕机也要妥善处理，恢复数据，所以本篇文章探讨 Redis 的持久化机制",
          author: "作者",
          date: "2021-03-23",
          view: 21,
          comment: 22,
          like: 23
        },
        {
          id: 4,
          tag: "Java",
          imgUrl: require("../assets/img/阿狸.jpg"),
          title: "Hello World!!!",
          note: "Redis 作为一个基于内存的高性能数据库，必须的有对应的持久化机制，否则一旦出现宕机，那数据可就全完了。即使有持久化机制，遇到宕机也要妥善处理，恢复数据，所以本篇文章探讨 Redis 的持久化机制",
          author: "作者",
          date: "2021-03-23",
          view: 21,
          comment: 22,
          like: 23
        },
        {
          id: 5,
          tag: "Java",
          imgUrl: require("../assets/img/阿狸.jpg"),
          title: "Hello World!!!",
          note: "Redis 作为一个基于内存的高性能数据库，必须的有对应的持久化机制，否则一旦出现宕机，那数据可就全完了。即使有持久化机制，遇到宕机也要妥善处理，恢复数据，所以本篇文章探讨 Redis 的持久化机制",
          author: "作者",
          date: "2021-03-23",
          view: 21,
          comment: 22,
          like: 23
        },
        {
          id: 6,
          tag: "Java",
          imgUrl: require("../assets/img/阿狸.jpg"),
          title: "Hello World!!!6",
          note: "Redis 作为一个基于内存的高性能数据库，必须的有对应的持久化机制，否则一旦出现宕机，那数据可就全完了。即使有持久化机制，遇到宕机也要妥善处理，恢复数据，所以本篇文章探讨 Redis 的持久化机制",
          author: "作者",
          date: "2021-03-23",
          view: 21,
          comment: 22,
          like: 23
        },
        {
          id: 7,
          tag: "Java",
          imgUrl: require("../assets/img/阿狸.jpg"),
          title: "Hello World!!!7",
          note: "Redis 作为一个基于内存的高性能数据库，必须的有对应的持久化机制，否则一旦出现宕机，那数据可就全完了。即使有持久化机制，遇到宕机也要妥善处理，恢复数据，所以本篇文章探讨 Redis 的持久化机制",
          author: "作者",
          date: "2021-03-23",
          view: 21,
          comment: 22,
          like: 23
        }
      ],
      uPage:1, //当前页
      perPage:6, //每页显示多少条
      totalPage:0 // 一共有多少页
    }
  },
  computed:{
    showArticles:{
      get(){
        this.totalPage = Math.ceil(this.articles.length / 6)
        return this.totalPage;
      }
    },
    newArticles:{ //渲染到页面
      get(){ // 分割数据
          return JSON.parse(JSON.stringify(this.articles)).splice((this.uPage-1)*this.perPage , this.perPage)
      }
    }
  },
  methods:{
    getPage(n){
      this.uPage = n;
    },
    gotoPage(page){
      this.uPage = page;
    },
    // 上一页
    prevPage(){
        if(this.uPage - 1 >0){             
            this.uPage = this.uPage-1;
          }else{
            this.uPage = 1
          }                      
    },  
    // 下一页
    nextPage(){  //若果是最后一页 
        if(this.uPage >= this.totalPage ){    
            this.uPage = this.totalPage            
        }else{
            this.uPage = this.uPage+1;  
        }   
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
  background-color: white;
  padding: 20px 20px 20px 20px;
  margin: 10px 0;
}

.article .title{
  float: left;
  width: 100%;
  margin: 0 0 14px 0;
}

.article .title span{
  float: left;
  background-color: #51aded;
  padding: 3px 10px;
  font-size: 14px;
}

.article .title i{
  display: block;
  float: left;
  margin-left: -6px;
  margin-top: 2px;
  color: #51aded;
  font-size: 16px;
}

.article .title i:before{
  content: "\e623";
}

.article .title a{
  float: left;
  padding: 2px 8px;
  font-weight: 600;
  font-size: 16px;
}


.article-center{
  float: left;
  width: 100%;
}

.article-img{
  display: block;
  float: left;
  width: 200px;
  height: 123px;
  background-size: 200px 123px;
  margin-right: 20px;
}

.article-center .note{
  overflow: hidden;
  line-height: 24px;
  text-indent: 2em;
  text-align: left;
}

.article-bottom{
  float: left;
  width: 100%;
}

.article-bottom{
  float: left;
  width: 100%;
}

.article-bottom ul{
  float: right;
  margin: 20px 20px 0 0;
  height: 17px;
}
.article-bottom .item{
  float: left;
  height: 100%;
}

.article-bottom .item i{
  display: inline-block;
  font-size: 16px;
  margin: 0 4px;
}

.article-bottom .item-name i:before{
  content: "\f007";
}

.article-bottom .item-date i:before{
  content: "\f017";
}

.article-bottom .item-view i:before{
  content: "\f06e";
}

.article-bottom .item-comment i:before{
  content: "\f0e5";
}

.article-bottom .item-like i:before{
  content: "\e6c6";
}

.article-bottom .item a{
  display: inline-block;
  height: 100%;
  font-size: 12px;
  margin: 0 4px;
}

.article-bottom .item span{
  display: inline-block;
  height: 100%;
  font-size: 12px;
}

.article-bottom .item-name{
  float: left;
}

.article-bottom .item-date{
  float: left;
}

.article-bottom .item-view{
  float: left;
}

.article-bottom .item-comment{
  float: left;
}

.article-bottom .item-like{
  float: left;
}

.pagination{
  position: relative;
}

.pagination a{
  margin: 6px 3px;
  display: inline-block;
  width: 60px;
  height: 60px;
  line-height: 60px;
  color: #fff;
  background: #2c3e50;
  font-size: 14px;
  font-weight: 600;
  transition: 0.3s;
  position: relative;
  padding-right: 26px;
}

.pagination a:hover{
  color: #e74c3c;
}

.pagination a::before, .pagination a:after{
  content: "";
  position: absolute;
  border-top: 30px solid transparent;
  border-bottom: 30px solid transparent;
}

.active{
  color: #e74c3c !important;
}

.prior-page{
  border-radius: 30px 0 0 30px;
}

.next-page{
  border-radius: 0 30px 30px 0;
}
.num:before, .next-page:before{
  border-right: 20px solid #2c3e50;
  right: 100%;
}

.num:after, .prior-page:after{
  border-right: 20px solid #f1f1f1;
  right: 0;
}

.pagination i{
  font-size: 14px;
  font-weight: 600;
}


    
</style>
