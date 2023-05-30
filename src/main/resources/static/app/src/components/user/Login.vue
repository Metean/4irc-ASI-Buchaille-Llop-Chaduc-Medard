<template>
	<div class="login">
		<div class="login__form">
			<b-form @submit="onSubmit">
				<b-form-group id="username" label="Nom d'utilisateur :">
					<b-form-input id="username" v-model="user.username" type="text" placeholder="" required></b-form-input>
				</b-form-group>

				<b-form-group id="password" label="Mot de passe :">
					<b-form-input id="password" v-model="user.password" type="password" placeholder="" required></b-form-input>
				</b-form-group>

				<b-button type="submit" variant="primary">Connexion</b-button>
			</b-form>
		</div>

		<b-card class="mt-3" header="Form Data Result">
			<pre class="m-0">{{ user }}</pre>
		</b-card>
	</div>
</template>

<script lang="ts">
import { Options, Vue } from 'vue-class-component'
import userService from '@/services/user.service'
import { User, UserLogin } from '@/types/user.type'
import { useToast } from 'vue-toastification'

@Options({
	props: {
		msg: String,
	},
})
export default class Login extends Vue {
	msg!: string
	user!: UserLogin
	toast = useToast()

	onSubmit(event: any) {
		userService
			.loginUser(this.user)
			.then((response: User) => {
				this.toast.success('Utilisateur connecté!')
				console.log(response)
			})
			.catch((error) => {
				this.toast.error("Impossible de connecter l'utilisateur")
			})
	}
}
</script>

<style scoped lang="scss">
.login {
	width: 100%;
	display: flex;
	flex-direction: column;
	justify-content: center;
	align-items: center;
	padding-top: 32px;

	&__form {
		width: 80%;
		border: 1px solid #c5c5c5;
		border-radius: 10px;
		padding: 24px 32px;
	}
}
</style>
