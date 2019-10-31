<template>
  <div>
    <el-table :data="testList" border>
      <el-table-column type="index" label="序号" width="50" align="center" />
      <el-table-column align="center" prop="name" label="姓名" />
      <el-table-column prop="age" align="center" label="年龄" />
      <el-table-column prop="birthday" align="center" label="生日" />
      <el-table-column prop="sex" align="center" label="性别" />
      <el-table-column prop="height" align="center" label="身高" />
      <el-table-column prop="address" align="center" label="地址" />
      <el-table-column prop="credits" align="center" label="积分" />
      <el-table-column prop="create_time" align="center" label="时间" />
    </el-table>
  </div>
</template>

<script>
  export default {
    name: 'toTestList',
    data() {
      return {
        testList: []
      }
    },
    created() {
      this.convert();
    },
    methods: {
      convert() {
        this.$axios.get('/userData/findAll').then(res=>{
          console.log(res.data)
          this.testList = res.data.data
        })
      }
    }
  }
</script>

<style scoped>

</style>
