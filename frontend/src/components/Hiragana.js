import axios from 'axios';
import 'bootstrap/dist/css/bootstrap.min.css';
import React, { useEffect, useState } from "react";

export default function GetLatestScores() {

  const backendUrl = 'http://localhost:8081';
  const [targetNumberOfLetter, setTargetNumberOfLetter] = useState("Ka");
  const [status, setStatus] = useState("OK");
  const [image, setImage] = useState("Brak Zdjęcia");
  const [romaji, setRomaji] = useState("Brak Litery");

    async function getRecordById() {

        await axios.post(`${backendUrl}/api/v1/gethiraganarecord/`)
            .then(response => {
                console.log(response.data);
                let idFound = false;


                response.data.forEach((e) => {
                    let lid = e.id;
                    let lhiraganaRomaji = e.hiraganaRomaji;
                    let lhiraganaImage = e.hiraganaImage;

                    let firstPartText = lhiraganaRomaji.substring(0, "ERROR:".length);


                    if (firstPartText !== "ERROR:") {
                        setStatus("OK");
                        setRomaji(`${lhiraganaRomaji}`);
                        setImage(`${lhiraganaImage}`);
                        idFound = true;
                    }
                    else {
                        let secondPartText = lhiraganaRomaji.substring("ERROR:".length, lhiraganaRomaji.length);
                        setStatus(secondPartText);
                        setRomaji(secondPartText);
                        idFound = true;
                    }
                })

            }).catch(err => {

                let myerror = "Błąd połaczenia sieciowego." + err;
                setStatus(myerror);
            });

    }

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
