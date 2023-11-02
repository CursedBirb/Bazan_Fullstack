import logo from './logo.svg';
import './App.css';
import React, {Component} from 'react';

class App extends Component {
  state = {
    message: ''
  };

  componentDidMount() {
    fetch('/api/hello') // Wykonujemy żądanie do backendu
        .then(response => response.text())
        .then(data => {
            this.setState({ message: data });
        })
        .catch(error => {
            console.error('Błąd:', error);
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
