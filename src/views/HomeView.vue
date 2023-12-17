<script setup lang="ts">
import {ref} from "vue"
import CardCarouselBackground from "@/components/CardCarouselBackground.vue";
import Card from "@/components/items/Card.vue";
import {NCard, NGradientText, NGrid, NGridItem, NText} from "naive-ui";
import BackgroundCards from "@/components/BackgroundCards.vue";
const stringList = ref(
    [
        "I'm feeling really anxious, can you help me calm down?",
        "I can't seem to stop worrying about everything. What should I do?",
        "I'm feeling really low and don't know why. Can you help me understand this?",
        "I'm having trouble sleeping because I can't stop thinking. Can you suggest something?",
        "I'm feeling overwhelmed with work and don't know how to cope. Can you help?",
        "I've been feeling really lonely lately. Can you suggest ways to feel better?",
        "I'm constantly feeling sad and don't know how to handle it. Can you help?",
        "I'm having trouble concentrating on my work. What should I do?",
        "I'm feeling really stressed out. Can you suggest some relaxation techniques?",
        "I'm having a lot of mood swings lately. Can you help me understand why?",
        "I've been feeling very irritable and angry lately. Can you suggest ways to manage this?",
        "I'm feeling really scared for no reason. Can you help me?",
        "I've been having a lot of negative thoughts. Can you suggest ways to deal with them?",
        "I'm feeling really hopeless and don't see a way out. Can you help?",
        "I'm constantly worrying about my health. Can you suggest ways to cope?",
        "I'm feeling detached from reality. Can you help me understand this?",
        "I'm having a lot of intrusive thoughts. Can you suggest ways to manage them?",
        "I'm feeling really guilty about something I did. Can you help me cope?",
        "I'm having trouble making decisions. Can you suggest ways to improve this?",
        "I'm constantly feeling tired even though I get enough sleep. Can you help?",
        "I'm feeling really restless and can't sit still. Can you suggest ways to manage this?",
        "I'm having a lot of irrational fears. Can you help me understand why?",
        "I'm feeling really insecure about myself. Can you suggest ways to improve my self-esteem?",
        "I'm constantly comparing myself to others and feel inadequate. Can you help?",
        "I'm having trouble with my memory. Can you suggest ways to improve it?",
        "I'm feeling really pessimistic about the future. Can you help me see things differently?",
        "I'm having a lot of nightmares. Can you suggest ways to cope?",
        "I'm feeling really empty inside. Can you help me understand why?",
        "I'm constantly feeling nervous. Can you suggest ways to calm down?",
        "I'm having a lot of panic attacks. Can you help me manage them?",
        "I'm feeling really paranoid about people around me. Can you help me understand this?",
        "I'm having trouble with my appetite. Can you suggest ways to manage this?",
        "I'm feeling really confused all the time. Can you help me?",
        "I'm having a lot of flashbacks about a traumatic event. Can you suggest ways to cope?",
        "I'm feeling really numb and don't feel anything. Can you help me understand why?",
        "I'm having a lot of suicidal thoughts. Can you suggest immediate help?",
        "I'm feeling really jealous of others. Can you suggest ways to manage this?",
        "I'm having trouble with my body image. Can you help me improve this?",
        "I'm feeling really self-conscious all the time. Can you suggest ways to cope?",
        "I'm having a lot of obsessive thoughts. Can you help me manage them?",
        "I'm feeling really unmotivated. Can you suggest ways to improve this?",
        "I'm having a lot of phobias. Can you help me understand why?",
        "I'm feeling really shy and have trouble socializing. Can you suggest ways to improve this?",
        "I'm having a lot of performance anxiety. Can you help me manage this?",
        "I'm feeling really indecisive. Can you suggest ways to improve decision making?",
        "I'm having a lot of relationship problems. Can you help me understand them?",
        "I'm feeling really unloved. Can you suggest ways to improve self-love?",
        "I'm having a lot of grief over a loss. Can you suggest ways to cope?",
        "I'm feeling really misunderstood. Can you suggest ways to communicate better?",
        "I'm having a lot of trust issues. Can you help me understand why?"
    ]
)

import pin1 from '@/assets/th1.jpg'
import pin2 from '@/assets/th2.jpg'
import pin3 from '@/assets/th3.jpg'
import pin4 from '@/assets/th4.jpg'
import pin5 from '@/assets/th5.jpg'
import pin6 from '@/assets/th6.jpg'
import pin7 from '@/assets/th.jpg'
import pin8 from '@/assets/R.jpg'
import AIChatWindow from "@/components/AIChatWindow.vue";

const infoCardList = [
    {pin: pin1, title: "Early Detection and Accurate Diagnosis", content: "AI can analyze patterns in behavior and language to help therapists and doctors identify mental health conditions earlier. This early detection is vital because it can reduce the risk of depression and substance-abuse problems. Studies have shown that AI is more than 90% accurate in detecting early-onset anxiety using sensors to detect behaviors such as nail-biting, tapping the fingers, and cracking knuckles."},
    {pin: pin2, title: "Improved Accessibility", content: "AI-based mental health care services, such as AI Chatbots, allow people to have access to therapeutic help anytime, anywhere. This is particularly beneficial for individuals who may not have easy access to in-person therapy due to geographical constraints or time limitations. AI can bridge gaps that exist in accessing therapy."},
    {pin: pin3, title: "Affordability", content: "Unlike traditional counseling where you need to schedule and travel for appointments, AI-based mental health apps allow users to access therapeutic help at a fraction of the cost. This makes mental health care more affordable and accessible to a larger population."},
    {pin: pin4, title: "Quality Control and Training", content: "AI is helping with the quality control of treatment and the training of therapists. Some mental health clinics are investigating automated ways to monitor quality control among therapists. AI can analyze the language used in therapy sessions through natural-language processing (NLP) to provide therapists with better insight into their work and ensure the delivery of high standards of care."},
    {pin: pin8, title: "Personalized Treatment Plans", content: "AI is helping doctors to make more accurate choices in treatment plans. Researchers believe they can use insights from data for more successful therapy sessions. AI can match prospective clients with the right therapists and figure out which type of therapy would work best for an individual."},
    {pin: pin6, title: "Support for Therapists", content: "AI can automate administrative tasks, which can help reduce the workload of therapists. This allows therapists to focus more on providing care to their patients. AI can also provide support in diagnosing mental illnesses and choosing treatment plans."},
    {pin: pin7, title: "Privacy and Ease to Open Up", content: "AI offers greater privacy for the patients. People may feel more comfortable opening up about their mental health to an AI, which can lead to more effective treatment. AI Chatbots are associated with less stigma and people are more willing to open up to an AI than they would with just an online form at a self-help website."},
    {pin: pin8, title: "Efficiency", content: "AI can increase the efficiency and productivity of mental health services. This can help health professionals such as nurses to accomplish work effectively in practice settings such as mental health settings. AI can aid in the delivery of mental health services and significantly increase the efficiency and productivity of workplaces."}
]

</script>

<template>
    <div class="flex flex-col min-h-screen p-4 bg-emerald-900">
        <div class="relative">
            <BackgroundCards :string-list="stringList"/>
        </div>
        <div class="flex-col absolute inset-0">
            <div class="min-h-screen flex flex-col items-center justify-center text-center bg-zinc-900/80">
                <div class="font-bold text-emerald-300 from-emerald-700 to-emerald-500 text-6xl">AI x Mental Health</div>
                <AIChatWindow class="mt-5 w-1/3"/>
            </div>
            <div class="flex flex-col bg-emerald-600 p-8">
                <NGrid :x-gap="20" :y-gap="20" :cols="2">
                    <NGridItem v-for="card in infoCardList">
                        <NCard class="w-full h-full rounded-lg">
                            <template class="flex gap-5">
                                <div class="w-11/12 h-48 overflow-hidden rounded-lg">
                                    <img class="w-full h-full object-cover" :src="card.pin" />
                                </div>
                                <div>
                                    <div class="text-emerald-900 font-bold text-left text-3xl">{{card.title}}</div>
                                    <p class="text-emerald-800 text-left mr-10 ml-2 text-md">{{card.content}}</p>
                                </div>
                            </template>
                        </NCard>
                    </NGridItem>
                </NGrid>
            </div>
        </div>

    </div>
</template>
