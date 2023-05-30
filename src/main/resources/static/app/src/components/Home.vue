<template>
	<div>HOME</div>
	{{ msg }}

	<button @click="$router.push('/buy')">Acheter</button>
	<button @click="$router.push('/sell')">Vendre</button>
	<button @click="$router.push('/play')">Jouer</button>
</template>

<script lang="ts">
import { Options, Vue } from 'vue-class-component'
import Register from './user/Register.vue'
import testService from '@/services/test.service'

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

	mounted() {
		this.test()
	}

	public async test(): Promise<void> {
		await testService
			.getTest()
			.then((response: any) => {
				console.log(response)
			})
			.catch((error) => {
				console.error(error)
			})
	}
}
</script>

<style scoped lang="scss"></style>
