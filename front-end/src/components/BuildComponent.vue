<script setup lang="ts">
import {computed, onMounted, ref} from "vue";
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

const groupedByType = computed(() => {
  const groups = ref<{ [key: string]: any[] }>({});
  for (const part of result?.allParts) {
    const label = part.type.label;
    if (!groups[label]) {
      groups[label] = [];
    }
    groups[label].push(part);
  }
  return groups;
});

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
    <div v-for="(item, type) in result?.AllParts" :key="item.id">
<!--      <button class="btn btn-secondary dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">-->
<!--        Kies {{ item?.label }}-->
<!--      </button>-->
<!--      <ul class="dropdown-menu">-->
<!--&lt;!&ndash;        <li v-for="item in items" :key="item?.id"><a class="dropdown-item" href="#">{{ item?.name }}</a></li>&ndash;&gt;-->
<!--        <li class="dropdown-item">{{ item?.label }}</li>-->
<!--      </ul>-->
      <label class="form-label">{{ type }}</label>
      <select class="form-select" v-model="result.AllParts[type]">
        <option :value="null" disabled>Kies een {{ type }}</option>
        <option v-for="item in items" :key="item.id" :value="item.id">{{ item.naam }}</option>
      </select>
    </div>

<!--  Kijk of je met een Listbox de onderdelen samen met het type neer kan zetten-->
</template>

<style scoped>

</style>