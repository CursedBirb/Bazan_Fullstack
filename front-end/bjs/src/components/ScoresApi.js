import axios from 'axios';

const backendUrl = 'http://localhost:8001'; // Twoje własne URL backendu

const api = {
  getScores: () => {
    return axios.get(`${backendUrl}/api/v1/getScores`)
      .then(response => response.data)
      .catch(error => {
        throw error; // Możesz dostosować obsługę błędów w zależności od potrzeb
      });
  },
};

export default api;