<template>
    <div class="relative h-screen w-screen overflow-hidden bg-black bg-opacity-50">
        <div
            v-for="(row, index) in rowsComputed"
            :key="index"
            :class="`animate-marquee ${index % 2 === 0 ? 'direction-positive' : 'direction-negative'}`"
            class="flex w-max space-x-3 overflow-hidden"
        >
            <Card
                v-for="(card, i) in row"
                :card="card"
                :key="`${card}-${i}`"
            />
        </div>
    </div>
</template>

<script setup lang="ts">
import { ref, defineProps, onMounted, watchEffect, computed } from 'vue'
import Card from '@/components/items/Card.vue'

const props = defineProps({
    listOfStrings: {
        type: Array as () => string[],
        required: true,
    },
})

const rows = ref<string[][]>([])
const numberOfCards = ref<number>(0)

onMounted(() => {
    numberOfCards.value = Math.ceil(window.innerHeight / 100)
    createRows()
})

watchEffect(() => {
    window.addEventListener('resize', () => {
        numberOfCards.value = Math.ceil(window.innerHeight / 100)
        createRows()
    })
})

function createRows() {
    const copyOfList = [...props.listOfStrings]
    const newRows: string[][] = []

    while(copyOfList.length) {
        newRows.push(copyOfList.splice(0, numberOfCards.value))
    }

    rows.value = newRows
}

const rowsComputed = computed(() => rows.value)
</script>

<style>
@keyframes marquee {
    0% { transform: translateX(100%); }
    100% { transform: translateX(-100%); }
}

.direction-positive {
    animation: marquee 30s linear infinite normal;
}

.direction-negative {
    animation: marquee 30s linear infinite reverse;
}
</style>