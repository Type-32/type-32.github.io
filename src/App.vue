<script setup lang="ts">
import { RouterLink, RouterView } from 'vue-router'
import {NConfigProvider, NDialogProvider, NLoadingBarProvider, NMessageProvider, NNotificationProvider} from "naive-ui";
import './style.css'
</script>

<template>
    <NConfigProvider>
        <NDialogProvider>
            <NMessageProvider>
                <NNotificationProvider>
                    <NLoadingBarProvider>
                        <div class="w-full h-full">
                            <RouterView />
                        </div>
                    </NLoadingBarProvider>
                </NNotificationProvider>
            </NMessageProvider>
        </NDialogProvider>
    </NConfigProvider>
</template>

<style scoped>
</style>
