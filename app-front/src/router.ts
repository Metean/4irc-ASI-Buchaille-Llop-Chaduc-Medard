import { createRouter, createWebHistory, RouteRecordRaw } from 'vue-router'
import Home from './components/Home.vue'
import Register from './components/user/Register.vue'
import Login from './components/user/Login.vue'
import CardInfos from './components/cards/CardInfos.vue'
import CardsList from './components/cards/CardsList.vue'
import Play from './components/game/Play.vue'
import BuyCard from './components/market/BuyCard.vue'
import SellCard from './components/market/SellCard.vue'

const routes: Array<RouteRecordRaw> = [
	{
		path: '/',
		name: 'home',
		component: Home,
	},
	{
		path: '/register',
		name: 'register',
		component: Register,
	},
	{
		path: '/login',
		name: 'login',
		component: Login,
	},
	{
		path: '/cards/:id',
		name: 'card-info',
		component: CardInfos,
	},
	{
		path: '/cards',
		name: 'cards-list',
		component: CardsList,
	},
	{
		path: '/play',
		name: 'play',
		component: Play,
	},
	{
		path: '/buy',
		name: 'buy',
		component: BuyCard,
	},
	{
		path: '/sell',
		name: 'sell',
		component: SellCard,
	},
]

const router = createRouter({
	history: createWebHistory(process.env.BASE_URL),
	routes,
})

export default router
