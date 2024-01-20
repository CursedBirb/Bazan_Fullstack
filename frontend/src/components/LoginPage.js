import 'bootstrap/dist/css/bootstrap.min.css';
import React from "react";
import Login from './Login';


const LoginPage = ({ changeView }) => (

    <div>

        <Login />

        <p></p>
        <button onClick={() => changeView('mainMenu')}>Back To menu</button>

    </div>

    );

export default LoginPage;