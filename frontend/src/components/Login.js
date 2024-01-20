import 'bootstrap/dist/css/bootstrap.min.css';
import React, { useState } from "react";
import Button from 'react-bootstrap/Button';
import Container from 'react-bootstrap/Container';
import Form from 'react-bootstrap/Form';
import Modal from 'react-bootstrap/Modal';


export default function Login() {

    const [modalShow, setModalShow] = useState(false);
    const [modalNewUsername, setModalNewUsername] = useState("");
    const [modalNewPassword, setModalNewPassword] = useState("");

    var userName = localStorage.getItem('userName');
    var password = localStorage.getItem('password');

    // async function handleLogin() {
    //     let token = userName + ":" + password;
    //     var etoken = window.btoa(token);
    //     var basicAuth = 'Basic ' + etoken;

    //     await axios.post('http://localhost:8080/login',
    //         {}, { headers: { authorization: basicAuth } }
    //     )
    //     .then(response => {
    //         // Obsługa sukcesu logowania
    //         console.log("Zalogowano pomyślnie!");
    //     })
    //     .catch(error => {
    //         // Obsługa błędu logowania
    //         console.error("Błąd logowania:", error);
    //     });
    // }

    function handleClose(event) {

        let currentButton = event.currentTarget.textContent;

        setModalShow(false);

        if (currentButton === "OK") {

            localStorage.setItem('userName', modalNewUsername);
            localStorage.setItem('password', modalNewPassword);
        }
        else {
            localStorage.setItem('userName', modalNewUsername);
            localStorage.setItem('password', modalNewPassword);
        }
    }

    function handleCloseHeader() {

        setModalShow(false);
        localStorage.setItem('userName', modalNewUsername);
        localStorage.setItem('password', modalNewPassword);
    }

    function handleChangeUser(e) {
        setModalNewUsername(e.target.value)
    }

    function handleChangePassword(e) {
        setModalNewPassword(e.target.value)
    }

    function handleShow() {
        setModalShow(true);
    }

    return (

        <Container>

            <p>Aktualnie podany użytkownik i hasło: {userName}, {password}</p>

            <Button variant="primary" onClick={handleShow}> Aktualizuj dane do autoryzacji </Button>

            <p></p>

            <Modal show={modalShow} onHide={handleCloseHeader}>
                <Modal.Header closeButton>
                    <Modal.Title>Logowanie</Modal.Title>
                </Modal.Header>
                <Modal.Body>
                    <Form>
                        <Form.Group className="auto">
                            <Form.Label>Użytkownik:</Form.Label>
                            <Form.Control type="text" value={modalNewUsername} placeholder="" onChange={(e) => setModalNewUsername(e.target.value)} />
                        </Form.Group>
                        <Form.Group className="auto">
                            <Form.Label>Hasło:</Form.Label>
                            <Form.Control type="text" value={modalNewPassword} placeholder="" onChange={(e) => setModalNewPassword(e.target.value)} />
                        </Form.Group>
                    </Form >

                </Modal.Body>
                <Modal.Footer>
                    <Button variant="primary" onClick={handleClose}>
                        OK
                    </Button>
                    <Button variant="secondary" onClick={handleClose}>
                        Anuluj
                    </Button>
                </Modal.Footer>
            </Modal>
            

        </Container>

    );

}