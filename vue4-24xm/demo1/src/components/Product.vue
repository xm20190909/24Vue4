<template>
    <div class="product">
        <img :src="info.imgurl" alt="">
        <p>商品名称：{{info.name}}</p>
        <p>商品价格：{{info.price}}</p>
        <p><router-link :to="{name:'details',query:{id:info.id}}">查看详情</router-link></p>
    </div>
</template>

<script>
    export default {
        name: "Product",
        data(){
            return {}
        },
        props:['info']
    }
</script>

<style scoped>
    .product{
        width:25%;
    }
    .product img{
        width:80%;
    }
    .product p{margin-bottom:10px;}
</style>