
express = require('express')
app = express()
router = require('./routes/passageiroRoutes')
app.use(express.json());

const cors = require('cors');

app.use(cors());

const port = 3000
app.use(router)

console.log('o server esta online na porta ' + port)
app.listen(port)