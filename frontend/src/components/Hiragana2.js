import React, { Component } from 'react';

const backendUrl = 'http://localhost:8001';

class Hiragana2 extends Component {
  constructor(props) {
    super(props);
    this.state = {
      recordData: {}
    };
  }

  componentDidMount() {
    fetch(`${backendUrl}/api/v1/getHiraganaRecord`)
    .then(response => {
        if (!response.ok) {
          throw new Error(`Failed to fetch: ${response.statusText}`);
        }
        return response.json();
      })
      .then(data => {
        this.setState({ recordData: data });
        console.log('Data from backend:', data);
      })
      .catch(error => {
        console.error('Error fetching data:', error);
      });
  }

  render() {
    const { id, hiragana_romaji, hiragana_image } = this.state.recordData;

    return (
      <div>
          <p>Id: {id}</p>
          <p>Hiragana letter name: {hiragana_romaji}</p>
          <p>Hiragana letter image: {hiragana_image}</p>
      </div>
    );
  }
}

export default Hiragana2;