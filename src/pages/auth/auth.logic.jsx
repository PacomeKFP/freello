import swal from "sweetalert";
import HttpClient from "../../adapter/HttpClient.js";

/**
 * @param e FormEvent<HTMLFormElement>
 * @param authMode boolean
 * */
export async function handleAuthenticationSubmit(e, authMode) {
	e.preventDefault();
	// recucperer le contenu du formulaire
	const data = {};
	const form = new FormData(e.currentTarget)

	form.forEach((value, key) => data[key] = value)

	// inscription
	if (authMode) {
		if (data.password !== data["password-confirm"]) return swal("Erreur", "Les mots de passe ne correspondent pas !", "error")
		delete data["password-confirm"];

		console.log(data)
		// verifier d'autres conditions

		// envoyer la requette
		const promise = await HttpClient.post("/api/auth/register", data);

		console.log(promise);


	}
}