// import { SalesforceObject, PicklistValues } from '@/types/salesforce-fields.type'
// import { UserToken } from '@/types/user-token.type'
import axios from 'axios'
// import { useToast } from 'vue-toastification'
// import { environment } from '@/environment'
// import { AuthenticationService } from './authentication.service'

class TestService {
	async getTest(): Promise<any> {
		return axios
			.get('http://127.0.0.1:8080/api/getAllCards')
			.then(({ data }) => {
				return data
			})
			.catch((error) => {
				console.error(error)
				// const toast = useToast()
				// toast.error(error.response.message)
				return null
			})
	}

	/**
	async getPicklistValues(fieldApiName: string, objectApiName: string): Promise<PicklistValues[]> {
		const userInfos: UserToken = await AuthenticationService.getUserInfos()

		const queryDurableId = `select+DurableId+from+EntityParticle+where+EntityDefinitionId='${objectApiName}'+and+QualifiedApiName='${fieldApiName}'`

		return axios
			.post(
				`${environment.proxyEndpoint}/Proxy/Salesforce/request`,
				{
					type: 'GET',
					url: `${userInfos.instance_url}/services/data/v55.0/query/?q=${queryDurableId}`,
				},
				{
					headers: {
						Authorization: 'Bearer ' + userInfos.access_token,
						'Content-type': 'application/json',
					},
				}
			)
			.then(({ data }) => {
				const durableId = data.records[0].DurableId

				const queryValues = `select+Value,Label+from+PicklistValueInfo+where+EntityParticleId='${durableId}'`

				return axios
					.post(
						`${environment.proxyEndpoint}/Proxy/Salesforce/request`,
						{
							type: 'GET',
							url: `${userInfos.instance_url}/services/data/v55.0/query/?q=${queryValues}`,
						},
						{
							headers: {
								Authorization: 'Bearer ' + userInfos.access_token,
								'Content-type': 'application/json',
							},
						}
					)
					.then(({ data }) => {
						return data.records
					})
					.catch((error) => {
						console.error(error)
						return null
					})
			})
			.catch((error) => {
				console.error(error)
				return null
			})
	}
*/
}

export default new TestService()
