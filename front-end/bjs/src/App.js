import logo from './logo.svg';
import './App.css';
import React, {Component} from 'react';

const backendUrl = 'http://localhost:8001';

class App extends Component {
  state = {
    message1: 'Wolololo',
    message2: '',
    dataToSend: 'Hello from React!',
    hiraganaList: [],
  };

// componentDidMount() {
//   fetch(`http://localhost:8081/api/v1/getData`) // Wykonujemy żądanie do backendu
//       .then(response => response.text())
//       .then(data1 => {
//           this.setState({ message1: data1 });
//           console.log('Dane z backendu:', data1);
//       });
// }

// componentDidMount() {
//   fetch(`http://localhost:8081/api/v1/getHiraganaRecord`) // Wykonujemy żądanie do backendu
//       .then(response => response.text())
//       .then(data1 => {
//           this.setState({ message1: data1 });
//           console.log('Dane z backendu:', data1);
//       });
// }

componentDidMount() {
  fetch(`${backendUrl}/api/v1/getHiraganaRecord`) // Wykonujemy żądanie do backendu
      .then(response => response.json())
      .then(data1 => {
          this.setState({ hiraganaList: data1 });
      });
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
    const {items} = this.state
    return (
      <div className="App">
        {/* <header className="App-header">
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
          </a> */}

        <h1>Lista znaków hiragany</h1>
        <ul>{this.state.hiraganaList.map((hiragana) => (
          <li key={hiragana.id}>
            <p>{hiragana.hiraganaName}</p>
            {/* <img src={hiragana.hiraganaImage} alt={hiragana.hiraganaName} /> */}
          </li>
        ))}
        </ul>

        <button onClick={this.sendDataToBackend}>Send Data to Backend</button>
        <p>Back message from the backend: {this.state.message2}</p>

        {/* </header> */}
      </div>  
    );
  }

}

export default App;
