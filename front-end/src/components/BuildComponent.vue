<script setup lang="ts">
import {onMounted, ref} from "vue";
import { Client } from "../API";

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
    console.log(result)
  }
}

// const saveBuildAsync = async () => {
//   try {
//     // await client.updateBuild(result.value)
//   } catch (err) {
//     error.value = err
//     console.error('Error saving answers:', err)
//   } finally {
//     isLoading.value = false
//     router.push(`/mybuilds`)
//   }
// }

onMounted(() => {fetchNewBuild()})
</script>

<template>
  <div v-if="isLoading">Loading parts...</div>
  <div v-else-if="error">Error: {{ error.message }}</div>
    <div v-else v-for="(items) in result?.allParts" :key="items?.id" class="dropdown">
      <button class="btn btn-secondary dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">
        Kies {{ items?.type.label }}
      </button>
      <ul class="dropdown-menu">
        <li v-for="item in items" :key="item?.id"><a class="dropdown-item" href="#">{{ item?.name }}</a></li>
      </ul>
    </div>
<!--    <label class="form-label">{{ type }}</label>-->
<!--    <select class="form-select" v-model="result.AllParts[type]">-->
<!--      <option :value="null" disabled>Kies een {{ type }}</option>-->
<!--      <option v-for="item in items" :key="item.id" :value="item.id">{{ item.naam }}</option>-->
<!--    </select>-->

</template>

<style scoped>

</style>