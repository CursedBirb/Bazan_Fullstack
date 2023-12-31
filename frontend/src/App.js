import logo from './logo.svg';
import './App.css';
import React, {Component, useState, useEffect} from 'react';
import HiraganaList from './components/Hiragana';
import HiraganaRecord from './components/Hiragana2';
import LatestScores from './components/LatestScores';

const backendUrl = 'http://localhost:8001';

class App extends Component {
  state = {
    message1: 'Wolololo',
    message2: '',
    dataToSend: 'Hello from React!',
    getRecord: '',
  };
  

// componentDidMount() {
//   fetch(`http://localhost:8081/api/v1/getData`) // Wykonujemy żądanie do backendu
//       .then(response => response.text())
//       .then(data1 => {
//           this.setState({ message1: data1 });
//           console.log('Dane z backendu:', data1);
//       });
// }

componentDidMount() {
  fetch(`http://localhost:8081/api/v1/getHiraganaRecord`) // Wykonujemy żądanie do backendu
      .then(response => response.text())
      .then(data1 => {
          this.setState({ message2: data1 });
          console.log('Dane z backendu:', data1);
      });
}

// componentDidMount() {
//   fetch(`${backendUrl}/api/v1/getHiraganaRecord`) // Wykonujemy żądanie do backendu
//       .then(response => response.json())
//       .then(data1 => {
//           this.setState({ hiraganaList: data1 });
//       });
// }

getOneScoreRecord = () => {
    fetch(`${backendUrl}/api/v1/getScoreRecord}`, {
        method: 'GET',
        headers: {'Content-Type': 'application/json'},
        // body: JSON.stringify(this.state.getRecord)
    })
    .then(response => response.json())
    .then(getRecord => {
        this.setState({ record : getRecord})
    })

}

sendDataToBackend = () => {
  fetch(`${backendUrl}/api/v1/sendData`, {
      method: 'POST',
      headers: {
          'Content-Type': 'application/json'
      },
      body: JSON.stringify(this.state.dataToSend)
  })
  .then(response => response.text())
  .then(data2 => {
      this.setState({ message2: data2 });
  });
}


  render() {

    return (
      <div className="App">
        <header className="App-header">
          <img src={logo} className="App-logo" alt="logo" />
          <p>
            Edit <code>src/App.js</code> and save to reload.
            Really?
          </p>
          <p>Message from the backend: {this.state.message1}</p>
          <button onClick={this.sendDataToBackend}>Send Data to Backend</button>
          <p>Back message from the backend: {this.state.message2}</p>
          <a
            className="App-link"
            href="https://reactjs.org"
            target="_blank"
            rel="noopener noreferrer"
          >
            Learn React
          </a>
          <HiraganaList />
          <LatestScores />
          <HiraganaRecord />
        </header>
      </div>  
    );
  }

}

export default App;
