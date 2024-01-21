import axios from 'axios';
import 'bootstrap/dist/css/bootstrap.min.css';
import React, { useState } from "react";
import Button from 'react-bootstrap/Button';
import Container from 'react-bootstrap/Container';
import Form from 'react-bootstrap/Form';

export default function AddHiraganaScore() {

    const backendUrl = 'http://localhost:8081';
    const [status, setStatus] = useState("OK");
    const [textArea, setTextArea] = useState("Brak danych");
    const [newUsername, setNewUsername] = useState("Wolololo");
    const [newHiraganaScore, setNewHiraganaScore] = useState("46");

    let username = localStorage.getItem('userName');
    let password = localStorage.getItem('password');
    let score = localStorage.getItem('score');


    //Dodanie przelewu na serwer
    async function addHiraganaScore() {

        let username = username;
        let hiraganaScore = score;


        if ((username.length > 0) && (hiraganaScore.length > 0)) {
            await axios.post(`${backendUrl}/apis/addhiraganascore/`,
                { username, password, hiraganaScore }
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
            setStatus("Żadna z danych wstawianego przelewu nie może być pusta");
        }
    }

    const handleSubmit = (event) => {
        addHiraganaScore();
        event.preventDefault();
    }


    return (

        <Container>


            <Form onSubmit={handleSubmit}>
                <Form.Group className="auto" onSubmit={handleSubmit}>
                    <Button variant="primary" type="submit">  Dodaj  </Button>
                </Form.Group>
                <p></p>
            </Form >

            <p></p>

            <Form.Control as="textarea" rows={8} type="text" value={textArea} placeholder="" onChange={(e) => setTextArea(e.target.value)} spellCheck="false" />

            <p></p>


        </Container>

    );

}