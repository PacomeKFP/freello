/**
 * @Param clickHandler () => void
 * */
export const FloatingActionButton = ({clickHandler, subButtons}) => {
	return (
		<>
			<div className="fab-container" onClick={(e) => clickHandler()}>
				<div className="fab shadow">
					<div className="fab-content">
						<span className="material-icons">
							<i className="fa-solid fa-plus"></i>
						</span>
					</div>

					{
						subButtons && subButtons.map((button, index) =>
							<div className="sub-button shadow" key={index}>
									<span className="material-icons">
										<i className={`fa-solid fa-${button.icon}`}></i>
									</span>
							</div>
						)
					}


				</div>
			</div>
		</>
	)
}


