<script setup lang="ts">
import {onMounted, ref} from "vue";
import { Client } from "../API";
import {useRoute} from "vue-router";
import router from "../router.ts";

const route = useRoute()
const client = new Client()
const result = ref([])
const isLoading = ref(false)
const error = ref(null)

const fetchNewBuild = async () => {
  isLoading.value = true
  error.value = null
}

const saveBuildAsync = async () => {
  try {
    await client.createBuild(result.value)
  } catch (err) {
    error.value = err
    console.error('Error saving answers:', err)
  } finally {
    isLoading.value = false
    router.push(`/SelectedTeam/${route.params.teamId}/${route.params.senderId}`)
  }
}
</script>

<template>

</template>

<style scoped>

</style>