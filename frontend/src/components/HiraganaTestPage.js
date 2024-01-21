import 'bootstrap/dist/css/bootstrap.min.css';
import React from "react";
import GetHiraganaRomajiAndImage from './GetHiraganaRomajiAndImage';
import GetLatestScore from './GetLastestScore';

const HiraganaTestPage = ({ changeView }) => (

    <div>
        
        <GetHiraganaRomajiAndImage />
        <GetLatestScore />

        <p></p>
        <button onClick={() => changeView('mainMenu')}>Back To menu</button>

    </div>

    );


export default HiraganaTestPage;