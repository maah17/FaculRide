const db = require('../../db/cnx')

const atualizarTelefone = async function (telefone, telefone_antigo, res) {
    const client = await db.connect();
    try {
        const query = 'UPDATE cadastro_passageiro SET telefone = $1 WHERE telefone = $2';
        const values = [telefone, telefone_antigo];
        await client.query(query, values);
        console.log(`Passageiro com telefone ${telefone} att com sucesso.`);
    }
    catch (err) {
        console.error('Erro ao att telefone:', err);
    } finally {
        client.release();
    }
}

module.exports = { atualizarTelefone }
