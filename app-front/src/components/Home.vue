<template>
	<div>HOME</div>

	<button @click="$router.push('/buy')">Acheter</button>
	<button @click="$router.push('/sell')">Vendre</button>
	<button @click="$router.push('/play')">Jouer</button>
</template>

<script lang="ts">
import { Options, Vue } from 'vue-class-component'
import Register from './user/Register.vue'

@Options({
	components: {
		Register,
	},
	props: {
		msg: String,
	},
})
export default class Home extends Vue {
	msg!: string
}
</script>

<style scoped lang="scss"></style>
