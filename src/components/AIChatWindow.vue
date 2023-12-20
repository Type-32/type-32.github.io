<script setup lang="ts">
import { ref, reactive, onMounted } from 'vue'
import {OpenAI} from "openai";
import {darkTheme, NButton, NCard, NConfigProvider, NInput, NInputGroup, NScrollbar, NSpin, useMessage} from "naive-ui";
import VueMarkdown from "vue-markdown-render/src/VueMarkdown";
import * as process from "process";

interface ChatMessage {
    role: 'user' | 'assistant' | 'system';
    content: string;
}
// I don't like my mother. She likes micromanaging me and she always demand too much of me. Sometimes she even PUA's me by saying how I should be responsible and everything else, basically claiming that every thing, every error or wrongdoing, is my fault.
const message = useMessage();
const userInput = ref<string>('');
const chatMessages = ref<ChatMessage[]>([]);
const jwtMessages = reactive<ChatMessage[]>([{ role: "system", content: `You are a psychology therapist that helps patients who has distress in maintaining a well and stable mental health. You are to provide proper advice to your patient, whom you're talking to in this conversation, and give extra resources to help the patient. You can respond in markdown format. However, you are limited to only 800 characters per response, so limit your responses under that count. If the user asks for more details and explanations, you can respond to under 1200 characters.` }]);
const apiKey = import.meta.env.VITE_OPENAI_API_KEY; // Ensure the key name starts with VITE_ to be exposed to your app
const loading = ref(false)
const allowActions = ref(false)

onMounted(() => {
    if (!apiKey) {
        allowActions.value = true;
        console.error('OpenAI API key is not set in the environment variables');
        message.error('OpenAI API key is missing. Please set it in the environment variables.');
    }
})
// console.log(apiKey)
let $openai: any = null;
try {
    $openai = new OpenAI({apiKey, dangerouslyAllowBrowser: true});
} catch (e) {
    allowActions.value = false
}
async function askQuestion(questionContent: string): Promise<void> {
    loading.value = true;
    const questionMessage: ChatMessage  = { role: 'user', content: questionContent };
    sendMessage(questionMessage);
    jwtMessages.push(questionMessage);

    try {
        const data = await $openai.chat.completions.create({
            model: "gpt-4-1106-preview",
            messages: jwtMessages,
            max_tokens: 800,
            temperature: 0.7,
            frequency_penalty: 0.4,
            presence_penalty: 0.2,
        });

        const aiMessage: ChatMessage  = { role: 'assistant', content: data.choices[0].message.content ?? 'No response' };
        sendMessage(aiMessage);
        jwtMessages.push(aiMessage);
    } catch (error) {
        if (error instanceof Error) {
            message.error(`An error occurred while fetching request: ${error.message}`);
            console.error('Error:', error);
        }
        jwtMessages.pop(); // Remove the last user message since there was an error
    }
    loading.value = false;
}

function sendMessage(msg: ChatMessage) {
    chatMessages.value.push(msg);
}

function handleFormSubmit() {
    if(userInput.value.trim() && userInput.value.length > 0) {
        askQuestion(userInput.value);
        userInput.value = '';
    }
}
</script>

<template>
    <div class="h-fit bg-transparent rounded-lg backdrop-blur ring-[1px] ring-zinc-200/60 p-3">
        <NConfigProvider :theme="darkTheme" class="gap-3">
            <NSpin :show="loading">
                <template #description>
                    The AI is responding to your issues... Hang in there! You got this!
                </template>
                <NInputGroup class="flex flex-row">
                    <NInput :disabled="allowActions" v-model:value="userInput" class="flex flex-grow text-left" placeholder="Tell me your issues... I'll try to give you an answer as soon as possible!" type="textarea"/>
                    <div class="flex-grow flex-row">
                        <NButton :disabled="allowActions" @click="handleFormSubmit" class="flex-row h-full" strong>Ask</NButton>
                    </div>
                </NInputGroup>
                <NScrollbar class="max-h-96 w-full">
                    <div v-for="(message, index) in chatMessages" :key="index" :class="message.role == 'user' ? 'user-message' : 'ai-message'" class="gap-y-5">
                        <NCard v-if="message.role == 'user'" title="User" class="mt-4 text-left">
                            {{ message.content }}
                        </NCard>
                        <NCard v-if="message.role == 'assistant'" title="AI" class="mt-4 text-left">
                            <vue-markdown :source="message.content"/>
                        </NCard>
                    </div>
                </NScrollbar>
            </NSpin>
        </NConfigProvider>
    </div>
</template>

<style scoped>

</style>