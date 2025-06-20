<script setup lang="ts">
import {onMounted, ref} from "vue";
import { Client } from "../API";
import router from "../router.ts";

const client = new Client()
const result = ref()
const isLoading = ref(false)
const error = ref()
const selectedPart = ref()

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
    result.value.partToAdd = selectedPart.value
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
  <div v-else-if="result" class="container">
    <div class="mb-3">
      <label for="buildName" class="form-label">Naam van build</label>
      <input
          type="text"
          class="form-control"
          id="buildName"
          v-model="result.name"
          placeholder="Voer naam in"
      />
    </div>
    <select class="form-select" v-model="selectedPart">
      <option v-for="item in result?.allParts" :key="item.id" :value="item">
        {{ item.name }} - {{ item.typeName }}
      </option>
    </select>
    <button @click="saveBuildAsync">Opslaan</button>
  </div>
</template>

<style scoped>

</style>