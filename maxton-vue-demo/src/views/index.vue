<template>
  <div>
    <p>这里是主页面</p>
    <el-button type="success" @click="toTestList">去测试接口列表</el-button>
    <!--<BarChart></BarChart>-->
  </div>
</template>
<script>
import BarChart from './charts/BarChart'
export default {
    name: 'eCharts',
    components: { BarChart },
    data() {
      return {
      }
    },
    created() {
    },
    mounted() {

    },
    methods: {
      toTestList() {
        this.$router.push({ name: 'toTestList' })
      }
    }
  }
</script>

<style scoped>
</style>
