<template>
  <body>
    <b-table hover :items="items" @click:row="handleClick"></b-table>
  </body>
</template>

<script>
export default {
  name: "List.vue",
  data() {
    return {
      fields: [
          {key: 'No'},
          {key: 'Sports'},
          {key: 'region'},
          {key: 'Name'},
          {key: 'Leader'},
          {key: 'Date'}
      ],
      items: [
        { No: 1, Sports: 'Soccer', region: '서울', Name: 'FC 맨체스터', Leader: '김희중', Date: '2021.06.30'},
        { No: 2, Sports: 'Basketball', region: '경기도', Name: '광명농구단', Leader: '김희중', Date: '2021.07.20'}
      ]
    }
  },
  methods: {
    handleClick(value) {
      this.viewDetails(value);
    }
  }
}
</script>

<style scoped>

</style>