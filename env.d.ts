/// <reference types="vite/client" />
declare module 'markdown-it';
interface ImportMetaEnv{
    readonly VITE_OPENAI_API_KEY: string
}
interface ImportMeta{
    readonly env: ImportMetaEnv
}