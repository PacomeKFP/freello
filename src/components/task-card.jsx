export const TaskCard = ({title, status, description}) => {


	const color = getColor(status);
	return (
		<div className={`card border border-${color} text-start shadow-1-soft mx-0 my-2 mb-1`}
		     style={{width: "380px", padding: "0", cursor: "pointer"}}>
			<div className="card-header d-flex justify-content-between align-items-center">
				<h5 className="card-title">{title}</h5>
				<span className={`badge  badge-${color}`}>{status}</span>

			</div>
			<div className="card-body">
				<p className="card-text">
					{description}
				</p>
			</div>
			{
				getButton(status) && <div className="card-footer">
					{getButton(status)}
				</div>
			}

		</div>
	)
}


const getColor = (status) => {
	switch (status) {
		case 'Terminée':
			return 'success';
		case 'En Cours':
			return 'warning';
		default:
			return 'info';

	}
}

const getButton = (status) => {
	if (getColor(status) === 'success')
		return null;
	const text = getColor(status) === 'warning' ? 'Cloturer' : 'Demarrer la tache';
	return <button className={`btn btn-outline-${getColor(status)}`}> {text}</button>
}