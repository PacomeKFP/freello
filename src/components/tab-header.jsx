export function TabHeader({title, target, active}) {


	return <button className={`nav-link ${active ? "active" : ""}`} id={`v-pills-${target}-tab`} data-bs-toggle="pill"
	               data-bs-target={`#v-pills-${target}`} type="button" role="tab" aria-controls={`v-pills-${target}`}
	               aria-selected="true">{title}
	</button>
}