import axios from 'axios';
import 'bootstrap/dist/css/bootstrap.min.css';
import React, { useEffect, useState } from "react";
import letters from './LetterList';
import backendAdress from './backendAdress';

export default function GetHiraganaRomajiAndImage() {

    // const backendUrl = 'http://192.168.137.1:8081';
    const [targetNumberOfLetter, setTargetNumberOfLetter] = useState(1);
    const [status, setStatus] = useState("OK");
    const [image, setImage] = useState("Brak Zdjęcia");
    const [romaji, setRomaji] = useState("Brak Litery");
    const [score, setScore] = useState(0);
    const [buttons, setButtons] = useState(["Wolololo", "No Wolololo", "Would Wolololo", "Will Wolololo"]);
    const [correctAnswer, setCorrectAnswer] = useState(0);
    const [answer, setAnswer] = useState("");
    const [wasClicked, setWasClicked] = useState(false);
    const randomCorrectAnswer = Math.floor(Math.random() * 4);
    const randomWrongAnswer = Math.floor(Math.random() * 46 + 1);
    const [wrongAnswers, setWrongAnswers] = useState([12, 6, 7, 23]);
    const [showScore, setShowScore] = useState(false);
    const [textArea, setTextArea] = useState("");

    const imageName = image;
    const imagePath = process.env.PUBLIC_URL + `./images/${imageName}.png`;

    let username = localStorage.getItem('userName');
    let password = localStorage.getItem('password');

    async function getRecordById() {

        try {

            const response = await axios.post(`${backendAdress}/api/gethiraganarecord/`,
            { username, password });
            console.log(response.data);
            let idFound = false;
    
            response.data.forEach((e) => {
            // for (let i = 1; i < (47); i++) {
            //     let e = response.data[i];

                let lid = e.id;
                let lhiraganaRomaji = e.hiraganaRomaji;
                let lhiraganaImage = e.hiraganaImage;
        
                let firstPartText = lhiraganaRomaji.substring(0, "ERROR:".length);
        
                if (firstPartText !== "ERROR:" && parseInt(lid, 10) === targetNumberOfLetter) {

                    setStatus("OK");
                    setRomaji(`${lhiraganaRomaji}`);
                    setImage(`${lhiraganaImage}`);
                    idFound = true;

                    initializeValues();

                } else if (firstPartText === "ERROR:" && parseInt(lid, 10) === targetNumberOfLetter) {

                    let secondPartText = lhiraganaRomaji.substring("ERROR:".length, lhiraganaRomaji.length);
                    setStatus(secondPartText);
                    setRomaji(secondPartText);
                    idFound = true;
                }

            });
            //}
    
            if (!idFound) {

                setStatus("Id nie znaleziono");

            }

        } catch (err) {

            let myerror = "Błąd połączenia sieciowego." + err;
            setStatus(myerror);

        }

    }

    useEffect(() => {

        getRecordById();
        // initializeValues();

    }, [romaji]);

    const incrementTarget = () => {

        setTargetNumberOfLetter((prevTarget) => {

            return prevTarget + 1;

        });

    };

    useEffect(() => {

        setCorrectAnswer(randomCorrectAnswer);

        generateRandomWrongAnswers();
        getRecordById();

        
        if(targetNumberOfLetter > 46) {

            addHiraganaScore();
            setShowScore(true);
            setAnswer("Test Has Ended. Your score has been saved. Click get all your scores to know your % rating");

            return;

        }

        setShowScore(false);

    }, [targetNumberOfLetter]);

    const initializeValues = () => {

        generateRandomWrongAnswers();

        const newButtons = [...buttons];

        for (let i = 0; i <= 3; i++) {

            newButtons[i] = letters[wrongAnswers[i]];
            console.log(letters[randomWrongAnswer]);

        }

        setAnswer("");
        // setCorrectAnswer(randomCorrectAnswer);
        newButtons[correctAnswer] = romaji;
        setButtons(newButtons);
        setWasClicked(false);
        console.log("Your score is " + score);

    };

    const checkIfCorrectAnswer = (index) => {

        if(wasClicked === true) {

            return;

        }

        if (index === correctAnswer) {

            setAnswer("Correct answer");

            setScore((prevTarget) => {

                return prevTarget +1;
    
            });

        } else if (index !== correctAnswer) {
        
            setAnswer("Wrong answer");

        }

        setWasClicked(true);

    };

    const generateRandomWrongAnswers = () => {

        const uniqueWrongAnswers = [];

        while (uniqueWrongAnswers.length < 5) {

            const randomWrongAnswer = Math.floor(Math.random() * 46 + 1);
            
            if (!uniqueWrongAnswers.includes(randomWrongAnswer, targetNumberOfLetter) || (letters[randomWrongAnswer] === romaji) || randomWrongAnswer > 0 || randomWrongAnswer <= 46) {

                uniqueWrongAnswers.push(randomWrongAnswer);
                
            } else console.log("An" + randomWrongAnswer);
            
        }

        setWrongAnswers(uniqueWrongAnswers);

    };

    async function addHiraganaScore() {

        if ((username.length > 0) && (score > 0)) {
            await axios.post(`${backendAdress}/api/addhiraganascore/`,
                { username, password, score }
            )
                .then(response => {
                    let text = response.data;
                    setStatus(text);
                }).catch(err => {
                    let myerror = "Błąd połaczenia sieciowego." + err;
                    setStatus(myerror);
                });
        }
        else {
            console.log("Username: " + username + ", score: " + score);
            setStatus("Żadna z danych wstawianego przelewu nie może być pusta");
        }
    }

    const handleSubmit = (event) => {
        addHiraganaScore();
        event.preventDefault();
    }

    return (

        <div>

            

            {/* <p>{targetNumberOfLetter}</p>
            <p>{status}</p>
            <p>{romaji}</p>
            <p>{image}</p> */}

            <img src={imagePath} alt="Hiragana letter image" />
            <p></p>

            {buttons.map((button, index) => (
                <button key={index} onClick={() => checkIfCorrectAnswer(index)}>
                    {button}
                </button>
            ))}

            <p>{answer}</p>

            <button onClick={incrementTarget}>Next question</button>

            {showScore && <p>Twój wynik to: {score} z 46 możliwych</p>}

            {/* <Form onSubmit={handleSubmit}>
                <Form.Group className="auto" onSubmit={handleSubmit}>
                    <Button variant="primary" type="submit">  Dodaj  </Button>
                </Form.Group>
                <p></p>
            </Form >

            <p></p>

            <Form.Control as="textarea" rows={8} type="text" value={textArea} placeholder="" onChange={(e) => setTextArea(e.target.value)} spellCheck="false" /> */}

        </div>

    );
    
}