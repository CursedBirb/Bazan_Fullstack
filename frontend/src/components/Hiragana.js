import React, { useEffect, useState } from 'react';

const backendUrl = 'http://localhost:8001';
const HiraganaList = () => {
  const [hiraganaList, setHiraganaList] = useState([]);

  useEffect(() => {
    const fetchItems = async () => {
      try {
        const response = await fetch(`${backendUrl}/api/v1/getHiraganaRecord`);
        const data = await response.json();
        console.log('Fetched data:', data);
        setHiraganaList(data);
      } catch (error) {
        console.error('Error fetching data:', error);
      }
    };

    fetchItems();
  }, []);

  return (
    <div>
      <h2>Hiragana List</h2>
      <pre>{JSON.stringify(hiraganaList, null, 2)}</pre>
    </div>
  );
};

export default HiraganaList;

{/* <h1>Lista znaków hiragany</h1>
<ul>{this.state.hiraganaList.map((hiragana) => (
  <li key={hiragana.id}>
    <p>{hiragana.hiraganaName}</p>
    {/* <img src={hiragana.hiraganaImage} alt={hiragana.hiraganaName} />
  </li>
))}
</ul>

<button onClick={this.sendDataToBackend}>Send Data to Backend</button>
<p>Back message from the backend: {this.state.message2}</p> */}