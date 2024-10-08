const db = require('../../db/cnx')

const deletarPassageiro = async function (idPassageiro) {
    const client = await db.connect()
    try {
        const dados = "DELETE FROM passageiro WHERE id_passageiros = $1;"
        await client.query(dados, [idPassageiro]);
        console.log(`Passageiro com ID ${idPassageiro} deletado com sucesso.`);
    } catch (err) {
        console.error('Erro ao deletar passageiro:', err);
        throw err;
    } finally {
        client.release();
    }
}

module.exports = { deletarPassageiro }