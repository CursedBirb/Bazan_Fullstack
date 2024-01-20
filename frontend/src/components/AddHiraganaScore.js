import axios from 'axios';
import 'bootstrap/dist/css/bootstrap.min.css';
import React, { useState } from "react";
import Alert from 'react-bootstrap/Alert';
import Button from 'react-bootstrap/Button';
import Container from 'react-bootstrap/Container';
import Form from 'react-bootstrap/Form';

export default function AddHiraganaScore() {

    const backendUrl = 'http://localhost:8081';
    const [status, setStatus] = useState("OK");
    const [textArea, setTextArea] = useState("Brak danych");
    const [newUsername, setNewUsername] = useState("Wolololo");
    const [newHiraganaScore, setNewHiraganaScore] = useState("46");

    let userName = localStorage.getItem('userName');
    let password = localStorage.getItem('password');


    //Dodanie przelewu na serwer
    async function addHiraganaScore() {

        let username = userName;
        let hiraganaScore = newHiraganaScore;


        if ((username.length > 0) && (hiraganaScore.length > 0)) {
            await axios.post(`${backendUrl}/api/v1/addhiraganascore/`,
                { username, hiraganaScore },
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

            <Alert variant="info">
                <Alert.Heading><strong>Klient dostępu do przelewów w banku z użyciem REST (bez autoryzacji, HOOK) </strong></Alert.Heading>
                Lokalizacja bazy: http://localhost:8081/
            </Alert>

            <p></p>

            <h3>Status: {status}</h3>

            <p></p>

            <Form.Label> Dane nowego przelewu: </Form.Label>

            <Form onSubmit={handleSubmit}>
                <Form.Group className="auto" onSubmit={handleSubmit}>
                    <Form.Label> Klient: <input type="text" name='newUsername' value={newUsername} onChange={(e) => setNewUsername(e.target.value)} /> </Form.Label>
                    {' '}
                    <Form.Label> Data przelewu: <input type="text" name='newHiraganaScore' value={newHiraganaScore} onChange={(e) => setNewHiraganaScore(e.target.value)} /> </Form.Label>
                    {' '}
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