import {Navbar} from "../../components/navbar.jsx";
import {TaskCard} from "../../components/task-card.jsx";
import {TabHeader} from "../../components/tab-header.jsx";
import {TabContent} from "../../components/tab-content.jsx";
import {Nav, Tab, Tabs} from "react-bootstrap";
import {Link, NavLink} from "react-router-dom";
import {FloatingActionButton} from "../../components/floating-action-button.jsx";


export default function ProjectScreen() {
	const status = ["En Cours", "En attente", "Terminée"]
	const tasks = [
		{
			title: "tache 1",
			description: "Lorem ipsum",
			status: status[1]
		},
		{
			title: "tache 1",
			description: "Lorem ipsum",
			status: status[0]
		}, {
			title: "tache 1",
			description: "Lorem ipsum",
			status: status[2]
		}, {
			title: "tache 1",
			description: "Lorem ipsum",
			status: status[1]
		}, {
			title: "tache 1",
			description: "Lorem ipsum",
			status: status[0]
		}
	]

	return <>
		<Navbar/>

		<main className="main mt-5 container border-1">


			<Tabs
				defaultActiveKey="all"
				transition={false}
				id="noanim-tab-example"
				className="mb-3"
			>
				<Tab eventKey="all" title="Toutes les taches">
					<div className="content mt-5 d-flex flex-wrap gap-5">
						{
							tasks.map(
								task => <TaskCard status={task.status} key={task.id} title={task.title}
								                  description={task.description}/>
							)
						}

					</div>
				</Tab>
				<Tab eventKey="pending" title="Taches en attente">
					<div className="content mt-5 d-flex flex-wrap gap-5">
						{
							tasks.filter(task => task.status === status[0])
								.map(
									task => <TaskCard status={task.status} key={task.id} title={task.title}
									                  description={task.description}/>
								)
						}
					</div>
				</Tab>
				<Tab eventKey="going" title="Taches en cours">
					<div className="content mt-5 d-flex flex-wrap gap-5">
						{
							tasks.filter(task => task.status === status[1])
								.map(
									task => <TaskCard status={task.status} key={task.id} title={task.title}
									                  description={task.description}/>
								)
						}
					</div>
				</Tab>
				<Tab eventKey="completed" title="Taches en terminées">
					<div className="content mt-5 d-flex flex-wrap gap-5">
						{
							tasks.filter(task => task.status === status[2])
								.map(
									task => <TaskCard status={task.status} key={task.id} title={task.title}
									                  description={task.description}/>
								)
						}
					</div>
				</Tab>
			</Tabs>

			<FloatingActionButton subButtons={[{icon: "plus", onClick: }]} />


		</main>
	</>
}

const buttons = [
	{// nouvelle tache
		icon: "plus"
		clickHandler: ""
	}
]