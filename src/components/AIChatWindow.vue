<script setup lang="ts">

import {NButton, NInput, NInputGroup} from "naive-ui";
</script>

<template>
    <div class="w-fit h-fit bg-emerald-800/50 rounded-lg backdrop-blur ring-[1px] ring-zinc-200 p-3">
        <NInputGroup class="flex flex-row">
            <NInput class="flex flex-grow"/>
            <NButton class="flex-row" strong>Ask</NButton>
        </NInputGroup>
    </div>
</template>

<style scoped>

</style>