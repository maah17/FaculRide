const db = require('../../db/cnx')

const criarPassageiro = async function (cpf, nome, telefone, email, senha) {
    const client = await db.connect()
    try {
        const dados = "INSERT INTO cadastro_passageiro (cpf, nome, telefone, email, senha) VALUES ($1, $2, $3, $4, $5);"
        await client.query(dados, [cpf, nome, telefone, email, senha]);
        console.log(`Passageiro com nome ${nome} cadastrado com sucesso.`);
    } catch (err) {
        console.error('Erro ao cadastrar passageiro:', err);
        throw err;
    } finally {
        client.release();
    }
}

module.exports = { criarPassageiro }