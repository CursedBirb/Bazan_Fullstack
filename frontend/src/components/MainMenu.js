import React, { useState } from 'react';
import MainPage from './MainPage';
import ModeSelection from './ModeSelection';
import LoginScreen from './LoginScreen';
import AccountCreationScreen from './AcountCreationScreen';
import LatestScoresScreen from './LatestScoresScreen';
import LogOut from './Logout';

const MainMenu = () => {

    const [currentScreen, setCurrentScreen] = useState ('component1');

    const handleClick = (screenName) => {

        setCurrentScreen(screenName);

    }

    return (
    
        <div>
            <div>

                <p onClick={() => handleClick('component1')}>Main Menu</p>
                <p onClick={() => handleClick('component2')}>Mode Selection</p>

            </div>

            <div>
                {currentScreen === 'component1' && <MainPage />}
                {currentScreen === 'component2' && <ModeSelection />}
                {currentScreen === 'component3' && <LoginScreen />}
                {currentScreen === 'component4' && <AccountCreationScreen />}
                {currentScreen === 'component5' && <LatestScoresScreen />}
                {currentScreen === 'component5' && <LogOut />}

            </div>
        </div>
    );

}

export default MainMenu;