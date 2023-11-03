import logo from './logo.svg';
import './App.css';
import React, {Component} from 'react';

const backendUrl = 'http://localhost:8001';

class App extends Component {
  state = {
    message: 'Wolololo'
  };

  componentDidMount() {
    fetch(`http://localhost:8081/api/v1/hello`) // Wykonujemy żądanie do backendu
        .then(response => response.text())
        .then(data => {
            this.setState({ message: data });
            console.log('Dane z backendu:', data);
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
          <p>Message from the backend: {this.state.message}</p>
          <a
            className="App-link"
            href="https://reactjs.org"
            target="_blank"
            rel="noopener noreferrer"
          >
            Learn React
          </a>
        </header>
      </div>
    );
  }

}

export default App;
