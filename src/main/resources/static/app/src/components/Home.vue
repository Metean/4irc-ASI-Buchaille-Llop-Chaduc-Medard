<template>
	<div>HOME</div>
	{{ msg }}

	<div class="home__cards">
		<b-card img-src="https://picsum.photos/600/300/?image=25" img-alt="Image" img-top tag="article" style="max-width: 20rem" class="mb-2">
			<b-button variant="primary" @click="$router.push('/buy')">Acheter une carte</b-button>
		</b-card>

		<b-card img-src="https://picsum.photos/600/300/?image=25" img-alt="Image" img-top tag="article" style="max-width: 20rem" class="mb-2">
			<b-button variant="primary" @click="$router.push('/sell')">Vendre une carte</b-button>
		</b-card>

		<b-card img-src="https://picsum.photos/600/300/?image=25" img-alt="Image" img-top tag="article" style="max-width: 20rem" class="mb-2">
			<b-button variant="primary" @click="$router.push('/play')">Lancer une partie</b-button>
		</b-card>
	</div>
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

		const user = localStorage.getItem('user')
		if (!user) this.$router.push('/login')
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

<style scoped lang="scss">
.home {
	&__cards {
		width: 100%;
		display: flex;
		column-gap: 32px;
		align-items: center;
		justify-content: center;
	}
}
</style>
