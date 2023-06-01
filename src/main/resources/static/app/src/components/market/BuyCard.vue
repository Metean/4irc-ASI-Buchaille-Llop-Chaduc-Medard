<template>
	<div class="buy">
		<table class="table">
			<thead>
				<tr>
					<th v-for="f in fields" :key="f">
						{{ f }}
					</th>
				</tr>
			</thead>
			<tbody>
				<tr v-for="c in allCards" :key="c.id" @click="buyCard(c.id)">
					<td style="width: 60px">
						<div style="display: flex; justify-content: center; align-items: center">
							<img class="table__img" :src="c.imageUrl" />
						</div>
					</td>
					<td style="width: 80px">
						{{ c.name }}
					</td>
					<td style="width: 250px">
						{{ c.description }}
					</td>
					<td style="width: 40px">{{ c.price }} €</td>
					<td>
						{{ c.type1 }}
						{{ c.type2 ? '- ' + c.type2 : '' }}
					</td>
					<td style="width: 200px">
						<li>Expérience : {{ c.hp }}</li>
						<li>Points d'attaque : {{ c.attack }}</li>
						<li>Points de défence : {{ c.defense }}</li>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
</template>

<script lang="ts">
import { Vue } from 'vue-class-component'
import CardService from '@/services/card.service'
import { Card } from '@/types/card.type'
import { useToast } from 'vue-toastification'
import { User } from '@/types/user.type'

export default class BuyCard extends Vue {
	toast = useToast()
	allCards = [] as Card[]
	fields = ['', 'Nom', 'Description', 'Prix', 'Type(s)', 'Points']
	user!: User

	mounted() {
		this.getAllCards()

		const storageUser = localStorage.getItem('user')
		try {
			if (storageUser) this.user = JSON.parse(storageUser)
			else this.$router.push('/login')
		} catch (error) {
			this.$router.push('/login')
		}
	}

	async getAllCards() {
		CardService.getCards()
			.then((response: Card[]) => {
				console.log(response)
				this.allCards = response
			})
			.catch((error) => {
				this.toast.error('Impossible de récupérer les cartes en magasin')
			})
	}

	buyCard(id: number) {
		CardService.buyCard(id, this.user.username)
			.then((response: any) => {
				console.log(response)
				this.toast.success(this.user.username + ' a acheté la carte ' + id)
			})
			.catch((error) => {
				this.toast.error("Impossible d'acheter cette carte")
			})
	}
}
</script>

<style scoped lang="scss">
.buy {
	width: 100%;
	display: flex;
}

.table {
	border-collapse: collapse;
	margin: 25px 0;
	font-size: 0.9em;
	font-family: sans-serif;
	min-width: 400px;
	box-shadow: 0 0 20px rgba(0, 0, 0, 0.15);
	width: 900px;
	i thead tr {
		background-color: #009879;
		color: #ffffff;
		text-align: left;
	}

	th,
	td {
		padding: 12px 15px;
	}
	tbody tr {
		border-bottom: 1px solid #dddddd;
	}
	tbody tr:nth-of-type(even) {
		background-color: #f3f3f3;
	}
	tbody tr:last-of-type {
		border-bottom: 2px solid #009879;
	}
	tbody tr:hover {
		cursor: pointer;
		background-color: #e0e0e0;
	}
	tbody tr.active-row {
		font-weight: bold;
		color: #009879;
	}

	&__img {
		width: 50px;
		margin-right: 10px;
	}
}
</style>
