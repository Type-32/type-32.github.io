<script setup lang="ts">
import { darkTheme } from 'naive-ui'
import {NButton, NConfigProvider, NInput, NInputGroup} from "naive-ui";
</script>

<template>
    <div class="w-fit h-fit bg-transparent rounded-lg backdrop-blur ring-[1px] ring-zinc-200/60 p-3">
        <NConfigProvider :theme="darkTheme">
            <NInputGroup class="flex flex-row">
                <NInput class="flex flex-grow" placeholder="Tell me your issues..."/>
                <NButton class="flex-row" strong>Ask</NButton>
            </NInputGroup>
        </NConfigProvider>
    </div>
</template>

<style scoped>

</style>