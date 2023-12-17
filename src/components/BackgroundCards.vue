<script setup lang="ts">

import {NCard, NGrid, NGridItem} from "naive-ui";
const props = defineProps({
    stringList: Array<string>
})
</script>

<template>
    <div class="flex w-fit">
        <NGrid :x-gap="10" :y-gap="10" :cols="5" class="w-fit">
            <NGridItem v-for="item in stringList" class="flex">
                <NCard class="bg-emerald-800" embedded><div class="flex text-emerald-100 font-bold">{{item}}</div></NCard>
            </NGridItem>
        </NGrid>
    </div>
</template>

<style scoped>

</style>