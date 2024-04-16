import {createBrowserRouter, RouterProvider} from "react-router-dom";
import AuthScreen from "./pages/auth/auth.jsx";
import Home from "./pages/home/home.jsx";
import ProjectScreen from "./pages/project/project.screen.jsx";


export function AppRouter() {
	const router = createBrowserRouter([
		{
			path: "/",
			element: <Home/>,
		},
		{
			path: "/auth", element: <AuthScreen/>
		},
		{
			path: "/projects/:uuid", element: <ProjectScreen/>
		}

	]);

	return <RouterProvider router={router}/>
}