export const TabContent = ({target, children}) => {
	return (
		<>
			<div className="tab-pane fade d-flex w-100 flex-wrap gap-3" id={`v-pills-${target}`} role="tabpanel"
			     aria-labelledby={`v-pills-${target}-tab`}>
				{children}
			</div>
		</>
	)
}
