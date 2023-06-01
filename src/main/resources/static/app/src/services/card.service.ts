import axios from 'axios'
import { Card } from '@/types/card.type'

class CardService {
	async getCards(): Promise<Card[]> {
		return axios
			.get('http://127.0.0.1:8080/api/market/getAllCards')
			.then(({ data }) => {
				return data.content
			})
			.catch((error) => {
				console.error(error)
				return null
			})
	}

	async buyCard(id: number, username: string): Promise<any> {
		return axios
			.post('http://127.0.0.1:8080/api/market/buy', null, {
				params: {
					id,
					username,
				},
			})
			.then(({ data }) => {
				console.log('achat ok :')
				console.log(data)
				return data.content
			})
			.catch((error) => {
				console.log('achat pas ok :')
				console.error(error)
				return null
			})
	}

	async sellCard(id: number, username: string): Promise<any> {
		return axios
			.post('http://127.0.0.1:8080/api/market/sell', null, {
				params: {
					id,
					username,
				},
			})
			.then(({ data }) => {
				return data.content
			})
			.catch((error) => {
				console.error(error)
				return null
			})
	}
}

export default new CardService()
