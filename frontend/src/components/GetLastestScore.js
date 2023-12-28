import axios from 'axios';
import 'bootstrap/dist/css/bootstrap.min.css';
import React, { useState } from "react";
import Button from 'react-bootstrap/Button';
import Container from 'react-bootstrap/Container';
import Form from 'react-bootstrap/Form';

export default function GetLatestScores() {

    const backendUrl = 'http://localhost:8081';
    const [status, setStatus] = useState("OK");
    const [textArea, setTextArea] = useState("Tu powinna być zawartość bazy danych, ale jak nie to mi wciąż nie działa");

    async function getScore() {

        await axios.post(`${backendUrl}/api/v1/getlatestscore/`)
            .then(response => {
                console.log(response.data);
                let idFound = false;

                let scoresListText = ""

                response.data.forEach((e) => {
                    let lid = e.id;
                    let lusername = e.username;
                    let lhiraganaScore1 = e.hiraganaScore1;
                    let lhiraganaScore2 = e.hiraganaScore2;
                    let lhiraganaScore3 = e.hiraganaScore3;
                    let lkatakanaScore1 = e.katakanaScore1;
                    let lkatakanaScore2 = e.katakanaScore2;
                    let lkatakanaScore3 = e.katakanaScore3;

                    let firstPartText = lusername.substring(0, ("ERROR:").length);


                    if (firstPartText !== "ERROR:") {
                        scoresListText = `${lid}, ${lusername}, ${lhiraganaScore1}, ${lhiraganaScore2}, ${lhiraganaScore3}, ${lkatakanaScore1}, ${lkatakanaScore2}, ${lkatakanaScore3}\n`;
                        setTextArea(scoresListText);
                        setStatus("OK");
                    }
                    else {
                        let secondPartText = lusername.substring(("ERROR:").length, lusername.length);
                        scoresListText = lusername + "\n";
                        setTextArea(scoresListText);
                        setStatus(secondPartText);
                    }
                })

            }).catch(err => {

                let myerror = "Błąd połaczenia sieciowego." + err;
                setStatus(myerror);
            });

    }

    return (

        <Container>

            <Button variant="primary" onClick={getScore}>  Odczytaj aktualną listę przelewów  </Button>

            <p></p>

            <Form.Control as="textarea" rows={8} type="text" value={textArea} placeholder="" onChange={(e) => setTextArea(e.target.value)} spellCheck="false" />

            <p></p>

        </Container>

    );

}
