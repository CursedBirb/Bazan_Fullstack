import axios from 'axios';
import 'bootstrap/dist/css/bootstrap.min.css';
import React, { useEffect, useState } from "react";

export default function GetHiraganaRomajiAndImage() {

    const backendUrl = 'http://localhost:8081';
    const [targetNumberOfLetter, setTargetNumberOfLetter] = useState(1);
    const [status, setStatus] = useState("OK");
    const [image, setImage] = useState("Brak Zdjęcia");
    const [romaji, setRomaji] = useState("Brak Litery");

    async function getRecordById() {

        try {

            const response = await axios.post(`${backendUrl}/api/v1/gethiraganarecord/`);
            let idFound = false;
    
            //response.data.forEach((e) => {
            for (let i = 1; i < (47); i++) {

                let lid = i.id;
                let lhiraganaRomaji = i.hiraganaRomaji;
                let lhiraganaImage = i.hiraganaImage;
        
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
            //});
            }
    
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

        setTargetNumberOfLetter(targetNumberOfLetter + 1);
        getRecordById();

    };

    useEffect(() => {

        getRecordById();

    }, []);

    return (

        <div>

            <button onClick={incrementTarget}>Pobierz Wynik</button>

            <p>{targetNumberOfLetter}</p>
            <p>{status}</p>
            <p>{romaji}</p>
            <p>{image}</p>

        </div>

    );
    
}