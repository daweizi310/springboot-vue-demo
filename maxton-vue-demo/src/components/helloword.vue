<template>
  <div>
    <el-table :data="clientList" border>
      <el-table-column type="index" label="序号" width="70" align="center" />
      <el-table-column align="center" prop="ip" label="IP" />
      <el-table-column prop="pcsystem" align="center" label="操作系统" />
      <el-table-column prop="client_code" align="center" label="解码字符" />
      <el-table-column prop="monitor_version" align="center" label="monitor版本" />
      <el-table-column prop="group_name" align="center" label="小组名称" />
    </el-table>
  </div>
</template>

<script>
  export default {
    // name: 'eCharts',
    data() {
      return {
        clientList: []
      }
    },
    created() {
      // this.convert();
    },
    methods: {
      // convert() {
      //   this.$axios.get('/client/findAll').then(res=>{
      //     this.clientList = res.data.data
      //   })
      // }
    }
  }
</script>

<style scoped>
  h1 {
    font-weight: normal;
  }
</style>
