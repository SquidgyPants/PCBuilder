<template>
  <div class="container mt-4">
    <div v-for="(items, type) in onderdelenPerType" :key="type" class="mb-3">
      <label :for="`dropdown-${type}`" class="form-label">{{ type }}</label>
      <select :id="`dropdown-${type}`" class="form-select">
        <option disabled selected>Kies een {{ type }}</option>
        <option v-for="item in items" :key="item.id">{{ item.naam }}</option>
      </select>
    </div>
  </div>
</template>

<script>
import { ref } from 'vue';
import { Client } from '../API.ts';

const result = ref([])

result.value = await client.getAllParts();

export default {
  data() {
    return {
      onderdelen: result.value,
      client: new Client()
    };
  },
  computed: {
    onderdelenPerType() {
      return this.onderdelen.reduce((groepen, onderdeel) => {
        if (!groepen[onderdeel.type]) {
          groepen[onderdeel.type] = [];
        }
        groepen[onderdeel.type].push(onderdeel);
        return groepen;
      }, {});
    }
  }
};
</script>


<style scoped>

</style>