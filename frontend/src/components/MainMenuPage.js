import React, { useState } from 'react';
// import AccountCreationScreen from './AcountCreationScreen';
// import LatestScoresScreen from './LatestScoresScreen';
// import LoginScreen from './LoginScreen';
// import LogOut from './Logout';
// import MainPage from './MainPage';
import HiraganaTestPage from './HiraganaTestPage';
import LoginPage from './LoginPage';
import ModeSelectionPage from './ModeSelectionPage';
import NewUserPage from './NewUserPage';

const MainMenu = () => {

    const [currentScreen, setCurrentScreen] = useState(null);

    const changeView = (view) => {

        setCurrentScreen(view);

    }

    return (
    
        <div>
            <div>

                <p onClick={() => setCurrentScreen('loginPage')}>Log In</p>
                <p onClick={() => {

                    localStorage.setItem('userName', "");
                    localStorage.setItem('password', "");
                    setCurrentScreen('mainMenu');

                }}>Log Out</p>
                <p onClick={() => setCurrentScreen('register')}>Create account</p>
                <p onClick={() => setCurrentScreen('selection')}>Mode Selection</p>

            </div>

            <div>

                {currentScreen === null && <p>Welcome</p>}
                {currentScreen === 'mainMenu' && <p>Welcome</p>}
                {currentScreen === 'loginPage' && <LoginPage changeView={changeView}/>}
                {currentScreen === 'selection' && <ModeSelectionPage changeView={changeView}/>}
                {currentScreen === 'hiragana' && <HiraganaTestPage changeView={changeView}/>}
                {currentScreen === 'register' && <NewUserPage changeView={changeView}/>}

                {/* {currentScreen === 'component3' && <LoginScreen />}
                {currentScreen === 'component4' && <AccountCreationScreen />}
                {currentScreen === 'component5' && <LatestScoresScreen />}
                {currentScreen === 'component5' && <LogOut />} */}

            </div>
        </div>
    );

}

export default MainMenu;