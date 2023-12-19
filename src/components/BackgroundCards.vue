<script setup lang="ts">

import {NCard, NConfigProvider, NGrid, NGridItem, darkTheme} from "naive-ui";
const props = defineProps({
    stringList: Array<string>
})
</script>

<template>
    <div class="flex w-fit">
        <NGrid :x-gap="10" :y-gap="10" :cols="5" class="w-fit">
            <NGridItem v-for="(item, index) in stringList" class="flex" :key="index">
                <NConfigProvider :theme="darkTheme">
                    <NCard class="bg-emerald-800" embedded><div class="flex text-emerald-100 font-bold">{{item}}</div></NCard>
                </NConfigProvider>
            </NGridItem>
        </NGrid>
    </div>
</template>

<style scoped>

</style>