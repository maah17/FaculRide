const express = require('express')
const router = express.Router()
const passageiroController = require('../controllers/passageiroController');


router.get('/passageiros', passageiroController.listar)

router.patch('/atualizar', passageiroController.atualizar);

router.delete('/deletar/passageiro/:id', passageiroController.deletar)

router.post('/cadastro/passageiro', passageiroController.criar)


module.exports = router
