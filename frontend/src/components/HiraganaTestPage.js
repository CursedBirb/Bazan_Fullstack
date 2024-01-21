import 'bootstrap/dist/css/bootstrap.min.css';
import React from "react";
import GetHiraganaRomajiAndImage from './GetHiraganaRomajiAndImage';

const HiraganaTestPage = ({ changeView }) => (

    <div>
        
        <GetHiraganaRomajiAndImage />

        <p></p>
        <button onClick={() => changeView('mainMenu')}>Back To menu</button>

    </div>

    );


export default HiraganaTestPage;