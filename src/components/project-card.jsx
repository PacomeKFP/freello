/* eslint-disable no-mixed-spaces-and-tabs */

export const ProjectCard = () => {
	return (
		<div className="col-xl-3 col-md-6 mb-5" style={{width: '28%', minWidth: "280px", cursor: "pointer"}}>
			<div className="card border-left-primary shadow h-100 py-0 px-2">
				<div className="card-body">
					<div className="row no-gutters align-items-center">
						<div className="col mr-2">
							<div className="text-xs h5 text-start font-weight-bold text-primary text-uppercase mb-1">
								Projet Taxi
							</div>
							<div className=" mb-0 font-weight-bold text-gray-800 text-start">34 tâches</div>
						</div>
						<div className="col-auto mb-5">
							{/*<i className="fas fa-calendar fa-2x text-gray-300"></i>*/}
						</div>


						<div className="row no-gutters align-items-center mt-1 p-0">
							<div className="col-md-2">
								<div className="h6 mb-0 font-weight-bold text-gray-800">12%</div>
							</div>
							<div className="col col-md-9">
								<div className="progress progress-sm">
									<div className="progress-bar bg-primary" style={{width: "13%"}} role="progressbar"
									     aria-valuenow="12" aria-valuemin="0" aria-valuemax="100"></div>
								</div>
							</div>
							<i className="fas fa-check-circle fa-xx col-md-1"></i>
						</div>


					</div>
				</div>
			</div>
		</div>

	)
}
