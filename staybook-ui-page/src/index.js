import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App';
import {
  createBrowserRouter,
  RouterProvider,
} from "react-router-dom";
import Home from './Pages/Home';
import Login from './Pages/Login';
import Signup from './Pages/Signup';
import { Provider } from "react-redux";
import store from "./services/store";

const router = createBrowserRouter([
  {
    path: "/",
    element: <App/>
  },
  {
    path: "home",
    element: <Home/>
  },
  {
    path: "login",
    element: <Login/>
  },
  {
    path: "signup",
    element: <Signup/>
  },
]);
ReactDOM.render(
  <Provider store={store} router={router}>
    <App />
  </Provider>,
  document.getElementById("root")
);




//const root = ReactDOM.createRoot(document.getElementById('root'));
//root.render(
 // <RouterProvider router={router}/>
//);
