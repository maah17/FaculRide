const express = require('express')
const app = express()

app.get('/', function (req, res) {
  res.send('max steel x polly pocket')
})

app.listen(3000)