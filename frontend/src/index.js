import React from 'react';
import ReactDOM from 'react-dom/client';

// import BankTransNoAuthHook from "./components/BankTransNoAuthHook";
import AddHiraganaScore from './components/AddHiraganaScore';
import GetHiraganaRomajiAndImage from './components/GetHiraganaRomajiAndImage';
import GetLatestScores from './components/GetLastestScore';
import Login from './components/Login';


const root = ReactDOM.createRoot(document.getElementById('root'));

root.render(
    <React.StrictMode>

        <Login />

        {/* <BankTransNoAuthHook/> */}
        <GetLatestScores />
        <GetHiraganaRomajiAndImage />
        {/* <Hiraga/> */}

    <AddHiraganaScore />

  </React.StrictMode>
);



