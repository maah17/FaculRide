const db = require('../../db/cnx')

const listarPassageiros = async function () {
    const client = await db.connect();
    try {
        const dados = 'SELECT id_passageiro, nome, telefone, email FROM cadastro_passageiro  ORDER BY id_passageiro ASC;';
        const res = await client.query(dados);
        return res.rows;
    } catch (err) {
        console.error('Erro ao listar passageiros:', err);
        throw err;
    } finally {
        client.release();
    }
}

module.exports = { listarPassageiros }
