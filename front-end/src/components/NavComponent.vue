<script setup lang="ts">
import {onMounted, ref} from "vue";
import {Client} from "../API.ts";

const client = new Client();


</script>

<template>
  <div>
    <b-navbar style="background-color: #ADD8E6" toggleable="lg">
      <b-navbar-brand @click="$router.push(`/`)">PCBuilder</b-navbar-brand>
      <b-collapse id="nav-collapse" is-nav="true">
        <b-navbar-nav style="margin-right: auto;">
          <b-nav-item :to="`/mybuilds`">Mijn samenstellingen</b-nav-item>
          <b-nav-item :to="`/builder`">Maak nieuw</b-nav-item>
        </b-navbar-nav>

      </b-collapse>
    </b-navbar>
  </div>
</template>

<style scoped>
b-navbar {
  width: 100%;
}
</style>