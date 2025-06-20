import {createRouter, createWebHistory} from "vue-router";
import HelloWorld from "./components/HelloWorld.vue";
import BuildComponent from "./components/BuildComponent.vue";
import BuildPartComponent from "./components/BuildPartComponent.vue";

const links = [
    {
        path:"/",
        name:"Home",
        component: HelloWorld,
    },
    {
        path:"/builder",
        name:"Builder",
        component: BuildComponent,
    },
    {
        path:"/builder/:buildId",
        name:"Build",
        component: BuildComponent,
    },
    {
        path:"/selectedbuild/:buildId",
        name:"SelectedBuild",
        component: SelectedBuildComponent,
    },
    {
        path:"/mybuilds",
        name:"MyBuilds",
        component:BuildPartComponent
    }
]

const router = createRouter({
    history: createWebHistory(),
    routes: links,
})

export default router;