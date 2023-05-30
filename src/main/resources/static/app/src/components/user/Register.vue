<template>
	<div class="register">
		<div>INSCRIPTION</div>

		<div class="register__form border-secondary ">
			<b-form @submit="onSubmit" @reset="onReset" v-if="show">
				<b-form-group id="input-group-1" label="Email address:" label-for="input-1" description="We'll never share your email with anyone else.">
					<b-form-input id="input-1" v-model="form.email" type="email" placeholder="Enter email" required></b-form-input>
				</b-form-group>

				<b-form-group id="input-group-2" label="Your Name:" label-for="input-2">
					<b-form-input id="input-2" v-model="form.name" placeholder="Enter name" required></b-form-input>
				</b-form-group>

				<b-form-group id="input-group-3" label="Food:" label-for="input-3">
					<b-form-select id="input-3" v-model="form.food" :options="foods" required></b-form-select>
				</b-form-group>

				<b-form-group id="input-group-4" v-slot="{ ariaDescribedby }">
					<b-form-checkbox-group v-model="form.checked" id="checkboxes-4" :aria-describedby="ariaDescribedby">
						<b-form-checkbox value="me">Check me out</b-form-checkbox>
						<b-form-checkbox value="that">Check that out</b-form-checkbox>
					</b-form-checkbox-group>
				</b-form-group>

				<b-button type="submit" variant="primary">Submit</b-button>
				<b-button type="reset" variant="danger">Reset</b-button>
			</b-form>
		</div>

		<b-card class="mt-3" header="Form Data Result">
			<pre class="m-0">{{ form }}</pre>
		</b-card>
	</div>
</template>

<script lang="ts">
import { Options, Vue } from 'vue-class-component'

@Options({
	props: {
		msg: String,
	},
})
export default class Register extends Vue {
	msg!: string
	form = {
		email: '',
		name: '',
		food: null,
		checked: [],
	}
	foods = [{ text: 'Select One', value: null }, 'Carrots', 'Beans', 'Tomatoes', 'Corn']
	show = true

	onSubmit(event: any) {
		event.preventDefault()
		alert(JSON.stringify(this.form))
	}

	onReset(event: any) {
		event.preventDefault()
		// Reset our form values
		this.form.email = ''
		this.form.name = ''
		this.form.food = null
		this.form.checked = []
		// Trick to reset/clear native browser form validation state
		this.show = false
		this.$nextTick(() => {
			this.show = true
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

	&__form {
		width: 80%;
	}
}
</style>
