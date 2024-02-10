const express = require('express');
const app = express();
const port = 8080;

// Endpoint do obsługi żądań GET na głównej stronie
// app.get('/', (req, res) => {
//     res.send('Witaj, świecie!');
// });

// Serwer nasłuchuje na określonym porcie
app.listen(port, () => {
    console.log(`Serwer nasłuchuje na porcie ${port}`);
});