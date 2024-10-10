const { list } = require('xpress/lib/fs');
const db = require('../models');
const rotas = db.rotas;

async function inserirRotas() {
        const novoRotas = await rotas.create({
        ponto_partida: 'uva',
        ponto_chegada: 'sao paulo',
        data: "hoje",
        cordenadas: "sim"
    });
}

async function select() {
    const novalista = await rotas.findAll()
    console.log(novalista)
};

async function deletar() {
    const resultado = await rotas.destroy({
        where: 
        {id: 1,}
    });
};

async function atualizar() {
    const resultado = await rotas.update(
        { ponto_partida: 'porto vitóra' },
        {
          where: {
            id: 1,
          },
        },
      );
};


(async () => {
    
    await select();
})();0