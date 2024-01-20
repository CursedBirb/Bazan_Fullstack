import React, { useState } from 'react';
// import AccountCreationScreen from './AcountCreationScreen';
// import LatestScoresScreen from './LatestScoresScreen';
// import LoginScreen from './LoginScreen';
// import LogOut from './Logout';
// import MainPage from './MainPage';
import LoginPage from './LoginPage';
import ModeSelection from './ModeSelection';

const MainMenu = () => {

    const [currentScreen, setCurrentScreen] = useState(null);

    const changeView = (view) => {

        setCurrentScreen(view);

    }

    return (
    
        <div>
            <div>

                <p onClick={() => setCurrentScreen('loginPage')}>Login</p>
                <p onClick={() => setCurrentScreen('selection')}>Mode Selection</p>

            </div>

            <div>

                {currentScreen === null && <p>Welcome</p>}
                {currentScreen === 'mainMenu' && <p>Welcome</p>}
                {currentScreen === 'loginPage' && <LoginPage changeView={changeView}/>}
                {currentScreen === 'selection' && <ModeSelection changeView={changeView}/>}
                {/* {currentScreen === 'component3' && <LoginScreen />}
                {currentScreen === 'component4' && <AccountCreationScreen />}
                {currentScreen === 'component5' && <LatestScoresScreen />}
                {currentScreen === 'component5' && <LogOut />} */}

            </div>
        </div>
    );

}

export default MainMenu;