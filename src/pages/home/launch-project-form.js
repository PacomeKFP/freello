import swal from "sweetalert";
import HttpClient from "../../adapter/HttpClient.js";


/**
 * @param admin string l'id du
 * */
export const launchProjectForm = (admin) => {

	swal({
		text: 'Entrer le nom du projet',
		content: "input",
		button: {
			text: "Sauvegarder",
			closeModal: false,
		},
	})
		.then(name => {
			if (!name) throw null;

			return fetch(`https://itunes.apple.com/search?term=${name}&entity=movie`)
		})
		.then(results => results.json())
		.then(json => {
			const movie = json.results[0];

			if (!movie) {
				return swal("404 !", `There is no such movie.`, "warning");
			}

			const name = movie.trackName;
			const imageURL = movie.artworkUrl100;

			swal("", "Le projet a été enregistré correctement", "success");
		})
		.catch(err => {
			if (err) {
				swal("Oops !", "Une erreur est survenue lors de la sauvegarde du projet", "error");
			} else {
				swal.stopLoading();
				swal.close();
			}
		});

}