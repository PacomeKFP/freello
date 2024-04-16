import {Navbar} from "../../components/navbar.jsx";
import {ProjectCard} from "../../components/project-card.jsx";
import {FloatingActionButton} from "../../components/floating-action-button.jsx";
import {launchProjectForm} from "./launch-project-form.js";

export default function Home() {
	const clickHandler = () => {
		launchProjectForm()
	}

	return (
		<>
			<Navbar/>

			<main className="container py-lg-5 px-lg-3">
				<div className="row wrap gap-5">
					<ProjectCard/>
					<ProjectCard/>
					<ProjectCard/>
					<ProjectCard/>
				</div>
				<FloatingActionButton clickHandler={clickHandler}/>
			</main>
		</>
	)
}
