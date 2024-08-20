const db = require('./cnx')

async function listar() {
    await db.connect()
    resultado = await db.query('SELECT * FROM clientes;')
    console.log(resultado.rows)
    resultado2 = await db.query('SELECT * FROM companhia;')
    console.log(resultado2.rows)
    await db.end()
}


listar()