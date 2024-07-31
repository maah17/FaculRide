const express = require('express')
const app = express()

app.get('/', function (req, res) {
  res.send('bob o construtor')
})

app.listen(3000)