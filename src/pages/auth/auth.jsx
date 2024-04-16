/* eslint-disable no-mixed-spaces-and-tabs */
import {Link} from "react-router-dom";
import {useState} from "react";
import Button from "bootstrap/js/src/button.js";
import {handleAuthenticationSubmit} from "./auth.logic.jsx";

export default function AuthScreen() {
	// 0 - inscription; 1-- connextion
	const [authMode, setAuthMode] = useState(true);


	return <>
		<section className="text-center">
			<div className="p-5 bg-image" style={{
				backgroundImage: `url('https://mdbootstrap.com/img/new/textures/full/171.jpg')`,
				height: "300px"
			}}
			></div>

			<div className="card mx-4 mx-md-5 shadow-5-strong" style={{
				marginTop: "-100px",
				background: "hsla(0, 0%, 100%, 0.8)",
				backdropFilter: "blur(30px)",
			}}>
				<div className="card-body py-5 px-md-5">

					<div className="row d-flex justify-content-center">
						<div className="col-lg-10 mx-auto">
							<h2 className="fw-bold mb-5">{authMode ? "Inscrivez" : "Connectez"} vous maintenant !</h2>
							<form onSubmit={(e) => handleAuthenticationSubmit(e, authMode)}>
								{
									authMode && <div className="col-md-8 mb-4">
										<div data-mdb-input-init className="form-outline">
											<input name={"name"} type="text" id="form3Example1" className="form-control"/>
											<label className="form-label" form="form3Example1">Nom</label>
										</div>
									</div>
								}


								<div className="row">
									<div className="col-md-8 ">
										<div data-mdb-input-init className="form-outline mb-4">
											<input name={"email"} type="email" id="form3Example3"
											       className="form-control"/>
											<label className="form-label" form="form3Example3">Email address</label>
										</div>
									</div>

									<div className="col-md-8 ">
										<div data-mdb-input-init className="form-outline mb-4">
											<input name={"password"} type="password" id="form3Example4"
											       className="form-control"/>
											<label className="form-label" form="form3Example4">Mot de passe</label>
										</div>
									</div>
								</div>


								{
									authMode && <div data-mdb-input-init className="form-outline mb-4">
										<input name={"password-confirm"} type="password" id="form3Example4"
										       className="form-control"/>
										<label className="form-label" form="form3Example4">Confirmation de mot de
											passe</label>
									</div>
								}


								<button type="submit"
								        className="btn btn-primary w-100 btn-block mb-4">
									{authMode ? "Je me connecte " : " Je m'inscrit"}
								</button>
								<div className="text-center">
									<p>
										{authMode ? " Vous avez deja un compte ? " : "Pas encore de compte ? "}

										<Link to={authMode ? "?login" : "?register"}
										      onClick={() => setAuthMode(!authMode)}>
											{authMode ? "Conectez vous !" : " Inscrivez vous !"}
										</Link>
									</p>

								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</section>
	</>
}