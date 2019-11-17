<template>
    <div class="details">
        <img :src="prod.imgurl" alt="">
        <div>
            <p>产品名称：{{prod.name}}</p>
            <p>产品价格：<span style="color:#ed4014;font-weight:bold;font-size:18px">{{prod.price}}</span>元</p>
            <p>详细说明：{{prod.desc}}</p>
            <p><Button type="primary" class="btn" @click="addCart()">点击购买</Button></p>
        </div>
    </div>
</template>

<script>
    export default {
        name: "Details",
        data(){
            return {
                prod:null
            }
        },
        created(){
            var id = this.$route.query.id;
            this.prod = this.getProdById(id);
        },
        methods:{
            getProdById(id){
                var prod = this.$store.state.prodlist.find((item)=>{
                    return (item.id == id);
                });
                return prod;
            },

            addCart(){
                this.$store.commit('addCart',{
                    id:this.prod.id,
                    name:this.prod.name,
                    price:this.prod.price,
                    imgurl:this.prod.imgurl,
                    count:1});
                this.$router.push('/cart');
            }
        }
    }
</script>

<style scoped>

</style>