<script setup lang="ts">
import {onMounted, ref} from "vue";
import { Client } from "../API";
import {useRoute} from "vue-router";
import router from "../router.ts";
import SelectPartComponent from "./SelectPartComponent.vue";

const route = useRoute()
const client = new Client()
const result = ref()
const isLoading = ref(false)
const error = ref()

const fetchNewBuild = async () => {
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
  }
}

const addPartsdToBuild = async () => {
  try {
    await client.addPartsToBuild()
  } catch (err) {
    error.value = err
    console.error('Error adding part:', err)
  } finally {
    isLoading.value = false
  }
}

const saveBuildAsync = async () => {
  try {
    // await client.updateBuild(result.value)
  } catch (err) {
    error.value = err
    console.error('Error saving answers:', err)
  } finally {
    isLoading.value = false
    router.push(`/mybuilds`)
  }
}

onMounted(() => {fetchNewBuild()})
</script>

<template>
  <div v-if="isLoading">Loading parts...</div>
  <div v-else-if="error">Error: {{ error.message }}</div>
  <SelectPartComponent/>
</template>

<style scoped>

</style>