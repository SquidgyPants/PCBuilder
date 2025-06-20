<script setup lang="ts">
import {Client} from "../API.js";
import {onMounted} from "vue";
import {ref} from "vue";


const client = new Client();
const result = ref([]);
const isLoading = ref(false)
const error = ref(null)

const fetchBuilds = async () => {
  isLoading.value = true
  error.value = null
  try {
    result.value = await client.getAllBuilds()
  }
  catch (err) {
    error.value = err
    console.log(error)
  }
  finally {
    isLoading.value = false
    console.log(result)
  }
}




onMounted(() => {fetchBuilds()})
</script>

<template>
    <div v-if="isLoading">Loading teams...</div>
    <div v-else-if="error">Error: {{ error.message }}</div>
    <div class="container" v-else-if="result">
      <h2>All Builds</h2>
    <ul id="ul">
      <li v-for="item in result" :key="item.id">
        <b-card class="mb-2 rounded-pill" id="b-card" style="padding: 0;">
          <div id="inline-flex-div" style="padding: 0;">
            <p style="margin-bottom: 0; font-size: x-large">{{ item?.name }}</p>
            <b-button class="rounded-pill" @click="$router.push(``)">Bekijk build</b-button>
          </div>
        </b-card>
      </li>
    </ul>
  </div>
</template>

<style scoped>
container {
  padding: 20px;
}
#ul {
  padding: 0;
  list-style-type: none;
}
#b-card{
  background-color: #66DE80;
  margin-bottom: 5%;
}
#inline-flex-div {
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 0;
}
</style>