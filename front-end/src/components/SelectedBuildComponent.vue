<script setup lang="ts">
import {Client} from "../API.js";
import {onMounted} from "vue";
import {ref} from "vue";
import {useRoute} from "vue-router";

const route = useRoute();
const client = new Client();
const result = ref([]);
const isLoading = ref(false)
const error = ref(null)

const fetchBuild = async () => {
  isLoading.value = true
  error.value = null
  try {
    result.value = await client.getBuild(route.params.buildId.toString())
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

onMounted(() => {fetchBuild()})
</script>

<template>
  <div v-if="isLoading">Loading teams...</div>
  <div v-else-if="error">Error: {{ error.message }}</div>
  <div class="container" v-else-if="result">
    <h2>{{ result.name }} - Total price: €{{ result?.price }}</h2>
    <ul id="ul">
      <li class="list-group-item" v-for="item in result.parts" :key="item.id">{{ item.name }} - €{{ item.price }}</li>
    </ul>
  </div>
</template>

<style scoped>

</style>