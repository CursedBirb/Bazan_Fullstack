import React from 'react';
import ReactDOM from 'react-dom/client';

import BankTransNoAuthHook from "./components/BankTransNoAuthHook";
import GetHiraganaRomajiAndImage from './components/GetHiraganaRomajiAndImage';
import GetLatestScores from './components/GetLastestScore';


const root = ReactDOM.createRoot(document.getElementById('root'));

root.render(
  <React.StrictMode>

    <BankTransNoAuthHook/>
    <GetLatestScores />
    <GetHiraganaRomajiAndImage />

  </React.StrictMode>
);



