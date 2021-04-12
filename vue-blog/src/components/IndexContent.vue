<template>
    <div class="content">
        <IndexContentL/>
    </div>
    
</template>

<script>
import IndexContentL from './IndexContentL.vue'

export default{
    name: 'IndexContent',
    data(){
        return {

        }
    },
    components: {
        IndexContentL
    }
}
</script>

<style Lang="less" scoped>
.content{
    width: 980px;
    margin: 0 auto;
}
</style>