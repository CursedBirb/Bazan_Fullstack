import axios from 'axios';

const backendUrl = 'http://localhost:8081'; // Twoje własne URL backendu

const api = {
  getScores: () => {
    return axios.get(`${backendUrl}/api/v1/getScores`)
      .then(response => response.data)
      .catch(error => {
        console.error('Błąd zapytania:', error);
        throw error; // Możesz dostosować obsługę błędów w zależności od potrzeb
      });
  },
};

export default api;