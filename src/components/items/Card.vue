<template>
    <div class="bg-white h-24 w-38 p-3 rounded-lg shadow-md flex items-center justify-center">
        <p class="text-sm">{{ card }}</p>
    </div>
</template>

<script setup lang="ts">
import { defineProps } from 'vue'

const props = defineProps({
    card: String,
})
</script>

<style scoped>
</style>