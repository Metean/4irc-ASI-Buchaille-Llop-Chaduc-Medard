<template>
	<div class="register">
		<div class="register__form">
			<b-form @submit="onSubmit">
				<b-form-group id="username" label="Nom d'utilisateur :">
					<b-form-input id="username" v-model="newUser.username" type="text" placeholder="" required></b-form-input>
				</b-form-group>

				<b-form-group id="mail" label="Adresse mail :">
					<b-form-input id="mail" v-model="newUser.email" type="email" placeholder="" required></b-form-input>
				</b-form-group>

				<b-form-group id="password" label="Mot de passe :">
					<b-form-input id="password" v-model="newUser.password" type="password" placeholder="" required></b-form-input>
				</b-form-group>

				<b-button type="submit" variant="primary">Inscription</b-button>
			</b-form>
		</div>

		<b-card class="mt-3" header="Form Data Result">
			<pre class="m-0">{{ newUser }}</pre>
		</b-card>
	</div>
</template>

<script lang="ts">
import { Options, Vue } from 'vue-class-component'
import userService from '@/services/user.service'
import { User, UserRegister } from '@/types/user.type'
import { useToast } from 'vue-toastification'

@Options({
	props: {
		msg: String,
	},
})
export default class Register extends Vue {
	msg!: string
	newUser!: UserRegister
	toast = useToast()

	onSubmit(event: any) {
		userService
			.registerUser(this.newUser)
			.then((response: User) => {
				this.toast.success('Utilisateur inscrit!')
				console.log(response)
			})
			.catch((error) => {
				this.toast.error("Impossible d'inscrire l'utilisateur")
			})
	}
}
</script>

<style scoped lang="scss">
.register {
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
