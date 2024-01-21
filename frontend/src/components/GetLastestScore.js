import axios from 'axios';
import 'bootstrap/dist/css/bootstrap.min.css';
import React, { useEffect, useState } from "react";

export default function GetLatestScore() {

    const backendUrl = 'http://localhost:8081';
    const [status, setStatus] = useState("OK");
    const [textArea, setTextArea] = useState("Tu powinna być zawartość bazy danych, ale jak nie to mi wciąż nie działa");
    const [wynik, setWynik] = useState("");
    const [, forceUpdate] = useState();
    const [score, setScore] = useState();

    var username = localStorage.getItem('userName');
    var password = localStorage.getItem('password');

    async function getScore() {

        // await axios.post(`${backendUrl}/api/v1/getlatestscore/`
        // await axios.post(`${backendUrl}/api/v1/getlatestscore/`,
        await axios.post(`${backendUrl}/api/getscore`,
        { username, password } )
            .then(response => {
                // console.log(response.data);

                let rd = response.data;

                let scoresListText = "";

                scoresListText = `${response.data.username}, ${response.data.hiraganaScore1}, ${response.data.hiraganaScore2}, ${response.data.hiraganaScore3}, ${response.data.katakanaScore1}, ${response.data.katakanaScore2}, ${response.data.katakanaScore3}\n`;

                if(rd.hiraganaScore1 === -32) {

                    setScore("Finish test at least once to see your % score of the last three tries");

                }

                if(rd.hiraganaScore1 > -32) {

                    setScore("Your score is: " + (((rd.hiraganaScore1) / 46) * 100) + "%.");

                }

                if(rd.hiraganaScore2 > -32) {

                    setScore("Your score is: " + ((((rd.hiraganaScore1 + rd.hiraganaScore2) / 2) / 46) * 100) + "%.");

                }

                if(rd.hiraganaScore3 > -32) {

                    setScore("Your score is: " + ((((rd.hiraganaScore1 + rd.hiraganaScore2 + rd.hiraganaScore3) / 3) / 46) * 100) + "%.");

                }
                
                // setTextArea(scoresListText);
                // setStatus("OK");
                // setWynik(scoresListText);
                // console.log(wynik);

                

            }).catch(err => {

                let myerror = "Błąd połaczenia sieciowego." + err;
                setStatus(myerror);
            });

    }

    useEffect(() => {
        // Tu możesz dodać inne efekty uboczne, jeśli są potrzebne
    }, [wynik]);

    return (

        <div >

            <p></p>
            <p></p>
            <button onClick={getScore}>Get your all scores</button>
            <p>{score}</p>
            <p></p>

            

        </div>

        // <Container>

        //     <Button variant="primary" onClick={getScore}>  Odczytaj aktualną listę przelewów  </Button>

        //     <p></p>

        //     <Form.Control as="textarea" rows={8} type="text" value={textArea} placeholder="" onChange={(e) => setTextArea(e.target.value)} spellCheck="false" />

        //     <p></p>

        // </Container>

    );

}
