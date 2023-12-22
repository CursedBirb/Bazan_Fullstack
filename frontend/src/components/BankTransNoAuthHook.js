//Klient dostępu do przelewów w banku na serwerze z użyciem usług REST bez autoryzacji (HOOK)
//Lokalizacja bazy: http://localhost:8081/
//W celu przetestowania klienta należy uruchomić serwer wykonany za pomoca Sprint Boot w języku Java (WEBSERVICE BANK NO AUTH)


import axios from 'axios';
import 'bootstrap/dist/css/bootstrap.min.css';
import React, { useState } from "react";
import Alert from 'react-bootstrap/Alert';
import Button from 'react-bootstrap/Button';
import Container from 'react-bootstrap/Container';
import Form from 'react-bootstrap/Form';


export default function BankTransNoAuthHook() {


    const [status, setStatus] = useState("OK");
    const [textArea, setTextArea] = useState("Brak danych");
    const [newClientname, setNewClientname] = useState("nowak");
    const [newDate, setNewDate] = useState("2022-10-30");
    const [newDescription, setNewDescription] = useState("Zakup USD");
    const [newAmount, setNewAmount] = useState("345.1");
    const [transferIDToDelete, setTransferIDToDelete] = useState("1");


    //Dodanie przelewu na serwer
    async function addTransfer() {

        let clientname = newClientname;
        let date = newDate;
        let description = newDescription;
        let amount = newAmount;


        if ((clientname.length > 0) && (date.length > 0) && (description.length > 0) && (amount.length > 0)) {
            await axios.post('http://localhost:8081/addtransfer/',
                { clientname, date, description, amount }, //Podajemy parametry
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


    //Pobranie listy przelewow z serwera
    async function getTransfers() {

        await axios.post('http://localhost:8081/gettransfers/')
            .then(response => {

                let transferListText = ""

                response.data.forEach((e) => {
                    let lid = e.id;
                    let lclientname = e.clientname; let ldate = e.date; let ldescription = e.description; let lamount = e.amount;

                    let firstPartText = lclientname.substring(0, ("ERROR:").length);


                    if (firstPartText !== "ERROR:") {
                        transferListText = transferListText + lid + ", " + lclientname + ", " + ldate + ", " + ldescription + ", " + lamount + "\n";
                        setTextArea(transferListText);
                        setStatus("OK");                        
                    }
                    else {
                        let secondPartText = lclientname.substring(("ERROR:").length, lclientname.length);
                        transferListText = lclientname + "\n";
                        setTextArea(transferListText);
                        setStatus(secondPartText);                                                
                    }
                })

            }).catch(err => {

                let myerror = "Błąd połaczenia sieciowego." + err;
                setStatus(myerror);                                                                
            });

    }


    async function deleteTransfer() {

        let transferidtodelete = transferIDToDelete;

        if (transferidtodelete.length > 0) {

            await axios.post('http://localhost:8081/deletetransfer/',
                { transferidtodelete }, //Podajemy parametr
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
            setStatus("ID przelewu nie może być puste");                                                                            
        }
    }

    const handleSubmit = (event) => {
        addTransfer();
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
                    <Form.Label> Klient: <input type="text" name='newClientname' value={newClientname} onChange={(e) => setNewClientname(e.target.value)} /> </Form.Label>
                    {' '}
                    <Form.Label> Data przelewu: <input type="text" name='newDate' value={newDate} onChange={(e) => setNewDate(e.target.value)} /> </Form.Label>
                    {' '}
                    <Form.Label> Opis przelewu:: <input type="text" name='newDescription' value={newDescription} onChange={(e) => setNewDescription(e.target.value)} /> </Form.Label>
                    {' '}
                    <Form.Label> Kwota: <input type="text" name='newAmount' value={newAmount} onChange={(e) => setNewAmount(e.target.value)} /> </Form.Label>
                    {' '}
                    <Button variant="primary" type="submit">  Dodaj  </Button>
                </Form.Group>
                <p></p>
            </Form >

            <Form.Group className="auto" onSubmit={handleSubmit}>
                <Form.Label> Podaj id przelewu do usunięcia: <input type="text" name='transferIDToDelete' value={transferIDToDelete} onChange={(e) => setTransferIDToDelete(e.target.value)} /> </Form.Label>
                {' '}
                <Button variant="primary" onClick={deleteTransfer}>  Usuń  </Button>
            </Form.Group>

            <p></p>


            <Button variant="primary" onClick={getTransfers}>  Odczytaj aktualną listę przelewów  </Button>

            <p></p>

            <Form.Control as="textarea" rows={8} type="text" value={textArea} placeholder="" onChange={(e) => setTextArea(e.target.value)} spellCheck="false" />

            <p></p>


        </Container>

    );
}

