import React, { Component } from 'react';
import api from './ScoresApi.js';
import Container from 'react-bootstrap/Container';
import Form from 'react-bootstrap/Form';
import Alert from 'react-bootstrap/Alert';

class LatestScores extends Component {
  constructor(props) {
    super(props);

    this.state = {

      status: 'OK', 
      textArea: "Tu powinna być zawartość bazy danych, ale jak nie to mi wciąż nie działa" 

    };      
  }

  async componentDidMount() {
    
    try {
        const scoresList = await api.getScores();
  
        let scoresListText = "";
  
        scoresList.forEach((e) => {

            let lid = e.id; 
            let lusername = e.username; 
            let lhiragana_score_1 = e.hiragana_score_1; 
            let lhiragana_score_2 = e.hiragana_score_2; 
            let lhiragana_score_3 = e.hiragana_score_3; 
            let lkatakana_score_1 = e.katakana_score_1; 
            let lkatakana_score_2 = e.katakana_score_2; 
            let lkatakana_score_3 = e.katakana_score_3;

            let firstPartText = lusername.substring(0, ("ERROR:").length);


        if (firstPartText !== "ERROR:") {

            scoresListText = `${lid}, ${lusername}, ${lhiragana_score_1}, ${lhiragana_score_2}, ${lhiragana_score_3}, ${lkatakana_score_1}, ${lkatakana_score_2}, ${lkatakana_score_3}\n`;
            this.setState({ textArea: scoresListText, status: "OK" });

        } else {

            let secondPartText = lusername.substring(("ERROR:").length, lusername.length);
            scoresListText = lusername + "\n";
            this.setState({ textArea: scoresListText, status: secondPartText });

          }
        }); 

      } catch(error) {

        let myerror = `Błąd połaczenia sieciowego. ` + error;
        this.setState({ status: myerror });
      }
    }

  render() {
    return (

      <Container>

        <Alert variant="info">
          <Alert.Heading><strong>Klient dostępu do przelewów w banku z użyciem REST (bez autoryzacji, CLASS) </strong></Alert.Heading>
          Lokalizacja bazy: http://localhost:8081/
        </Alert>

        <p></p>

        <h3>Status: {this.state.status}</h3>

        <p></p>

        <Form.Control as="textarea" rows={8} type="text" value={this.state.textArea} spellCheck="false" />

        </Container>

    );
  }

}

export default LatestScores;

