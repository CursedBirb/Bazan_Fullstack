//const backendAdress = 'http://localhost:8080';
const backendAdress = 'process.env.REACT_APP_BACKEND_ADDRESS' || 'http://localhost:8080';

export default backendAdress;
