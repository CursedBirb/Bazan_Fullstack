import axios from 'axios';
import 'bootstrap/dist/css/bootstrap.min.css';
import React, { useState } from "react";
import Button from 'react-bootstrap/Button';
import Container from 'react-bootstrap/Container';
import Form from 'react-bootstrap/Form';

export default function NewAccount() {

    const backendUrl = 'http://localhost:8081';
    const [status, setStatus] = useState("Johan");
    const [username, setUsername] = useState("Johan");
    const [password, setPassword] = useState("Johan");
    const [email, setEmail ] = useState("Johan");
    const [firstName, setFirstName] = useState("Johan");
    const [lastName, setLastName] = useState("Johan");
    const [age, setAge] = useState(53);
    const [countryOfBirth, setCountryOfBirth] = useState("Johan");

    async function addUser() {

        if ((username.length > 0) && (password.length > 0) && (email.length > 0) && (firstName.length > 0) && (lastName.length > 0) && (age > 0) && (countryOfBirth.length > 0)) {

            await axios.post(`${backendUrl}/api/adduser`,
            {username, password, email, firstName, lastName, age, countryOfBirth} )

                .then(response => {

                    console.log(username, password, email, firstName, lastName, age, countryOfBirth);

                }).catch(err => {

                    let myerror = "Błąd połaczenia sieciowego." + err;
                    setStatus(myerror);

                }

            );

        } else {

            setStatus("Żadna z danych wstawianego przelewu nie może być pusta");
        }

    }

    const handleSubmit = (event) => {
        addUser();
        event.preventDefault();
    }

    return (

        <Container>

            <Form >

                <Form.Group className="auto" >

                    {status}
                    <Form.Label> Username: <input type="text" name='username' value={username} onChange={(e) => setUsername(e.target.value)} /> </Form.Label>
                    {' '}
                    <Form.Label> Password: <input type="text" name='password' value={password} onChange={(e) => setPassword(e.target.value)} /> </Form.Label>
                    {' '}
                    <Form.Label> Email: <input type="text" name='email' value={email} onChange={(e) => setEmail(e.target.value)} /> </Form.Label>
                    {' '}
                    <Form.Label> First Name: <input type="text" name='firstName' value={firstName} onChange={(e) => setFirstName(e.target.value)} /> </Form.Label>
                    {' '}
                    <Form.Label> Last Name: <input type="text" name='lastName' value={lastName} onChange={(e) => setLastName(e.target.value)} /> </Form.Label>
                    {' '}
                    <Form.Label> Age: <input type="text" name='age' value={age} onChange={(e) => setAge(e.target.value)} /> </Form.Label>
                    {' '}
                    <Form.Label> Country of Birth: <input type="text" name='countryOfBirth' value={countryOfBirth} onChange={(e) => setCountryOfBirth(e.target.value)} /> </Form.Label>
                    {' '}
                    <Button variant="primary" onClick={handleSubmit}> Add user </Button>

                </Form.Group>

                <p></p>

            </Form >

            <p>{status}</p>

        </Container>

    );

}
