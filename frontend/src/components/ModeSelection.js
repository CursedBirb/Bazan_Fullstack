import 'bootstrap/dist/css/bootstrap.min.css';
import React from "react";

const ModeSelection = ({ changeView }) => (

    <div>

        <h2>Choose the Mode</h2>
    
        <button onClick={() => changeView('hiraganaScreen')}>Hiragana</button>
        <button onClick={() => changeView('katakanaScreen')}>Katakana</button>
        <p></p>
        <button onClick={() => changeView('mainMenu')}>Back To menu</button>

    </div>

    );


export default ModeSelection;