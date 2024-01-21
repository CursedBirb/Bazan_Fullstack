import 'bootstrap/dist/css/bootstrap.min.css';
import React from "react";
import NewAccount from './NewAccount';

const NewUserPage = ({ changeView }) => (

    <div>

        <NewAccount />

        <p></p>
        <button onClick={() => changeView('mainMenu')}>Back To menu</button>

    </div>

);

export default NewUserPage;