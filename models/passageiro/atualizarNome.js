const db = require('../../db/cnx')

const atualizarNome = async function (nome, nome_antigo, res) {
    const client = await db.connect();
    try {
        const query = 'UPDATE cadastro_passageiro SET nome = $1 WHERE nome = $2';
        const values = [nome, nome_antigo];
        await client.query(query, values);
        console.log(`Passageiro com nome ${nome} att com sucesso.`);
    } catch (err) {
        console.error('Erro ao att nome:', err);
    } finally {
        client.release();
    }
}

module.exports = { atualizarNome }
