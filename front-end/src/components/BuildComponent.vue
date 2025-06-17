<script setup lang="ts">
import {onMounted, ref} from "vue";
import { Client } from "../API";
import {useRoute} from "vue-router";
import router from "../router.ts";

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
    console.log(result.value)
    isLoading.value = false
  }
}

const fetchAllParts = async () => {
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
    console.log(result.value)
    isLoading.value = false
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
    router.push(`/SelectedTeam/${route.params.teamId}/${route.params.senderId}`)
  }
}

onMounted(() => {fetchNewBuild(); fetchAllParts()})
</script>

<template>
  <ul class="list-group">
    <li class="list-group-item">
      <div class="form-check">
        <input class="form-check-input" type="checkbox" value="" id="flexCheckDefault">
        <label class="form-check-label" for="flexCheckDefault">

        </label>
      </div>
    </li>
<!--    <li class="list-group-item">-->
<!--      <div class="form-check">-->
<!--        <input class="form-check-input" type="checkbox" value="" id="flexCheckChecked" checked>-->
<!--        <label class="form-check-label" for="flexCheckChecked">-->
<!--          Option 2 (checked)-->
<!--        </label>-->
<!--      </div>-->
<!--    </li>-->
<!--    <li class="list-group-item">-->
<!--      <div class="form-check">-->
<!--        <input class="form-check-input" type="checkbox" value="" id="flexCheckDisabled" disabled>-->
<!--        <label class="form-check-label" for="flexCheckDisabled">-->
<!--          Option 3 (disabled)-->
<!--        </label>-->
<!--      </div>-->
<!--    </li>-->
  </ul>
</template>

<style scoped>

</style>