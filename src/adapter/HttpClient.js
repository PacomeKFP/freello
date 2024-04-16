export default class HttpClient {
	static user;
	static baseUrl = "http://localhost:8080";

	static  header = {}

	static get(url) {
		return fetch(HttpClient.baseUrl + url, {method: "GET"})

	}

	static async post(url, data) {
		return await fetch(HttpClient.baseUrl + url, {method: "POST", body: JSON.stringify(data)})
	}

	static async patch(url) {
		return await fetch(HttpClient.baseUrl + url, {method: "PATCH"})
	}

	static async delete(url) {
		return await fetch(HttpClient.baseUrl + url, {method: "DELETE"})
	}


}