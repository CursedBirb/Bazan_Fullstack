import React from 'react';
import ReactDOM from 'react-dom/client';

import BankTransNoAuthHook from "./components/BankTransNoAuthHook";
import GetLatestScores from './components/GetLastestScore';


const root = ReactDOM.createRoot(document.getElementById('root'));

root.render(
  <React.StrictMode>

    <BankTransNoAuthHook/>
    <GetLatestScores />

  </React.StrictMode>
);



