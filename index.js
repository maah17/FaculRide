const express = require('express')
const app = express()
router = require('./routes/routes')


app.use(router)


app.get('/', function (req, res) {
  res.send('bob o construtor')
})

app.listen(3000)