<script setup lang="ts">
import {onMounted, ref} from "vue";
import { Client } from "../API";
import router from "../router.ts";

const client = new Client()
const result = ref()
const isLoading = ref(false)
const error = ref()

const fetchBuild = async () => {
  isLoading.value = true
  error.value = null
  try {
    result.value = await client.getNewBuild()
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

const saveBuildAsync = async () => {
  try {
    await client.updateBuild(result.value)
  } catch (err) {
    error.value = err
    console.error('Error saving answers:', err)
  } finally {
    isLoading.value = false
    router.push(`/builder/${result.value.id}`)
  }
}

onMounted(() => {fetchBuild()})
</script>

<template>
  <div v-if="isLoading">Loading parts...</div>
  <div v-else-if="error">Error: {{ error.message }}</div>
  <div v-else class="container">
    <select class="form-select">
      <option v-for="item in result?.allParts" :key="item.id">
        {{ item.name }} - {{ item.typeName }}
      </option>
    </select>
    <b-button @click="saveBuildAsync">Opslaan</b-button>
  </div>
</template>

<style scoped>

</style>