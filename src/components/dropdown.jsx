// Initialization for ES Users
import {Dropdown, Collapse, initMDB} from "mdb-ui-kit";

initMDB({Dropdown, Collapse});

export function DropdownComponent({icon, items}) {
	return (
		<>
			<div className="dropdown">
				<a
					data-mdb-dropdown-init
					className="text-reset me-3 dropdown-toggle hidden-arrow"
					href="#"
					id="navbarDropdownMenuLink"
					role="button"
					aria-expanded="false"
				>
					<i className={`fas fa-${icon}`}></i>
					<span className="badge rounded-pill badge-notification bg-danger">1</span>
				</a>
				<ul
					className="dropdown-menu dropdown-menu-end"
					aria-labelledby="navbarDropdownMenuLink"
				>
					{
						items.map((item, i) => <li key={i}>
							<a className="dropdown-item" href={"#"}> {item} </a>
						</li>)
					}

				</ul>
			</div>
		</>
	)
}
