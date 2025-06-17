<script setup lang="ts">
import {onMounted, ref} from "vue";
import {Client} from "../API.ts";

const client = new Client();


</script>

<template>
  <div>
    <b-navbar style="background-color: #66DE80" toggleable="lg">
      <b-navbar-brand @click="$router.push(`/`)">Anchr</b-navbar-brand>

      <b-navbar-toggle target="nav-collapse"></b-navbar-toggle>

      <b-collapse id="nav-collapse" is-nav="true">
        <b-navbar-nav>
          <b-nav-item :to="`/mybuilds`">Mijn samenstellingen</b-nav-item>
          <b-nav-item :to="`/build`">Maak nieuw</b-nav-item>
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