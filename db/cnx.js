const { Pool } = require('pg')

const poll = new Pool({
    user: 'postgres',
    password: 'postgres',
    host: 'localhost',
    port: 5432,
    database: 'dbFaculRideCerto'
})

module.exports = poll