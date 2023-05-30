import axios from 'axios'
import { useToast } from 'vue-toastification'
import { User, UserRegister, UserLogin } from '@/types/user.type'

class UserService {
	toast = useToast()

	async registerUser(newUser: UserRegister): Promise<User> {
		return axios
			.post('127.0.0.1:8080/api/register', newUser)
			.then(({ data }) => {
				console.log(data)
				return data
			})
			.catch((error) => {
				console.error(error)
				this.toast.error(error.response.message)
				return null
			})
	}

	async loginUser(newUser: UserLogin): Promise<User> {
		return axios
			.post('127.0.0.1:8080/api/login', newUser)
			.then(({ data }) => {
				console.log(data)
				return data
			})
			.catch((error) => {
				console.error(error)
				this.toast.error(error.response.message)
				return null
			})
	}
}

export default new UserService()
