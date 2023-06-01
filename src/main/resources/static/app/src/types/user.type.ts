export interface User {
	id: number
	email: string
	username: string
	money: number
	password: string
}

export class UserRegister {
	email!: string
	username!: string
	password!: string

	UserRegister() {
		this.email = ''
		this.username = ''
		this.password = ''
	}
}


export interface UserLogin {
	username: string
	password: string
}
export class UserLogin {
	username!: string
	password!: string

	UserRegister() {
		this.username = ''
		this.password = ''
	}
}
