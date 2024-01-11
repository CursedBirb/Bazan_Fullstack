import axios from 'axios';
import 'bootstrap/dist/css/bootstrap.min.css';
import React, { useEffect, useState } from "react";

export default function GetHiraganaRomajiAndImage() {

    const backendUrl = 'http://localhost:8081';
    const [targetNumberOfLetter, setTargetNumberOfLetter] = useState(1);
    const [status, setStatus] = useState("OK");
    const [image, setImage] = useState("Brak Zdjęcia");
    const [romaji, setRomaji] = useState("Brak Litery");
    const [score, setScore] = useState(0);
    const [wolololo] = useState("Wolololo");
    const buttons = ["Wolololo", "No Wolololo", "Would Wolololo", "Will Wolololo"];
    const [correctAnswer, setCorrectAnswer] = useState(0);
    const [answer, setAnswer] = useState("");
    const [wasClicked, setWasClicked] = useState(false);

    async function getRecordById() {

        try {

            const response = await axios.post(`${backendUrl}/api/v1/gethiraganarecord/`);
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
    
    // Wywołanie funkcji z konkretnym username (np. 'john_doe')

    const incrementTarget = () => {

        setTargetNumberOfLetter((prevTarget) => {
            
            getRecordById();
            return prevTarget + 1;

        });

        setWasClicked(false);

        // buttons[0] = "W";
        console.log(buttons);

    };

    const checkIfCorrectAnswer = () => {
        
        setWasClicked(true);
        console.log(correctAnswer);
        console.log(wasClicked);

        if (buttons.index === correctAnswer && wasClicked === true) {

            setAnswer("Prawidłowa odpowiedź");

        } else if (buttons.index !== correctAnswer && wasClicked === true) {
        
            setAnswer("Nieprawidłowa odpowiedź");

        }

    };

    

    useEffect(() => {

        getRecordById();

    }, [targetNumberOfLetter, answer]);

    const collectScore = () => {

    }

    return (

        <div>

            <button onClick={incrementTarget}>Pobierz Wynik</button>

            <p>{targetNumberOfLetter}</p>
            <p>{status}</p>
            <p>{romaji}</p>
            <p>{image}</p>

            {buttons.map((button, index) => (
                <button key={index} onClick={checkIfCorrectAnswer}>
                    {button}
                </button>
            ))}

            <p>{answer}</p>

        </div>

    );
    
}