import 'bootstrap/dist/css/bootstrap.min.css';
import React from "react";

const ModeSelectionPage = ({ changeView }) => (

    <div>

        <h2>Choose the Mode</h2>
    
        <button onClick={() => changeView('hiragana')}>Hiragana</button>
        <button onClick={() => changeView('katakanaScreen')}>Katakana</button>
        <p></p>
        <button onClick={() => changeView('mainMenu')}>Back To menu</button>

    </div>

    );


export default ModeSelectionPage;