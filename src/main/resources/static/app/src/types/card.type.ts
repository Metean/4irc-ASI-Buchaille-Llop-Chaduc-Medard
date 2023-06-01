import { User } from '@/types/user.type'

export interface Card {
	id: number
	price: number
	name: string
	description: string
	imageUrl: string
	type1: string
	type2: string
	hp: number
	attack: number
	defense: number
	user: User
}
