package com.example.demo.controller

import com.example.demo.model.Confirmacao
import com.example.demo.model.ConfirmacaoRequest
import com.example.demo.model.Empresa
import com.example.demo.model.Motorista
import com.example.demo.model.Passageiro
import com.example.demo.model.Veiculos
import com.example.demo.model.Rotas
import com.example.demo.model.Contratos
import com.example.demo.model.Feedback
import com.example.demo.model.Mensagens
import com.example.demo.service.MensagensService
import com.example.demo.service.FeedbackService
import com.example.demo.service.ContratoService
import com.example.demo.service.RotaService
import com.example.demo.service.VeiculoService
import com.example.demo.service.ConfirmacaoService
import com.example.demo.service.EmpresaService
import com.example.demo.service.MotoristaService
import com.example.demo.service.PassageiroService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/empresas")
class EmpresaController(private val empresaService: EmpresaService) {

    @PostMapping
    fun registerEmpresa(@Valid @RequestBody empresa: Empresa): ResponseEntity<Void> {
        return try {
            empresaService.registerEmpresa(
                nome = empresa.nome_empresa,
                cnpj = empresa.cnpj_empresa,
                inscricaoestadual = empresa.inscricao_estadual,
                cidade = empresa.cidade_empresa,
                uf = empresa.uf_empresa,
                rua = empresa.rua_empresa,
                email = empresa.email_empresa,
                razaosocial = empresa.razao_social,
                telefone = empresa.telefone
            )
            ResponseEntity.status(HttpStatus.CREATED).build()
        } catch (e: Exception) {
            e.printStackTrace()
            ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build()
        }
    }

    @GetMapping
    fun getAllEmpresas(): ResponseEntity<List<Empresa>> {
        return ResponseEntity.ok(empresaService.findAllEmpresas())
    }

    @GetMapping("/{id}")
    fun findByIdEmpresas(@PathVariable id: Long): ResponseEntity<Empresa> {
        return empresaService.findByIdEmpresas(id)?.let {
            ResponseEntity.ok(it)
        } ?: ResponseEntity.notFound().build()
    }

    @DeleteMapping("/{id}")
    fun deleteByIdEmpresas(@PathVariable id: Long): ResponseEntity<Void> {
        return try {
            empresaService.deleteEmpresa(id)
            ResponseEntity.noContent().build()
        } catch (e: NoSuchElementException) {
            ResponseEntity.notFound().build()
        }
    }

    @PatchMapping("/{id}")
    fun updateByIdempresa(@PathVariable id: Long, @RequestBody empresa: Empresa): ResponseEntity<Empresa> {
        val existingEmpresa = empresaService.findByIdEmpresas(id)

        return if (existingEmpresa != null) {
            val updatedEmpresa = empresa.copy(id_empresa = id)
            val savedEmpresa = empresaService.updateByIdempresa(id, updatedEmpresa)
            ResponseEntity.ok(savedEmpresa)
        } else {
            ResponseEntity.notFound().build()
        }
    }


}

@RestController
@RequestMapping("/api/passageiros")
class PassageiroController(
    private val passageiroService: PassageiroService
) {
    @PostMapping
    fun registerPassageiro(@RequestBody passageiro: Passageiro): ResponseEntity<Passageiro> {
        passageiroService.registerPassageiro(
            nome = passageiro.nome_passageiro,
            cpf = passageiro.cpf_passageiro,
            email = passageiro.email_passageiro,
            rua = passageiro.rua_passageiro,
            cidade = passageiro.cidade_passageiro,
            bairro = passageiro.bairro_passageiro,
            uf = passageiro.uf_passageiro,
            senha = passageiro.senha_passageiro,
            telefone = passageiro.telefone_passageiro
        )
        return ResponseEntity.status(HttpStatus.CREATED).build()
    }

    @GetMapping
    fun findAllPassageiros(): ResponseEntity<List<Passageiro>> {
        return ResponseEntity.ok(passageiroService.findAllPassageiros())
    }

    @GetMapping("/{id}")
    fun findByIdPassageiro(@PathVariable id: Long): ResponseEntity<Passageiro> {
        val passageiro = passageiroService.findByIdPassageiro(id)
        return if (passageiro != null) {
            ResponseEntity.ok(passageiro)
        } else {
            ResponseEntity.notFound().build()
        }
    }

    @PatchMapping("/{id}")
    fun updateByIdPassageiro(@PathVariable id: Long, @RequestBody passageiro: Passageiro): ResponseEntity<Passageiro> {
        return passageiroService.updateByIdPassageiro(id, passageiro)?.let {
            ResponseEntity.ok(it)
        } ?: ResponseEntity.notFound().build()
    }

    @DeleteMapping("/{id}")
    fun deletePassageiro(@PathVariable id: Long): ResponseEntity<Void> {
        return try {
            passageiroService.deletePassageiro(id)
            ResponseEntity.noContent().build()
        } catch (e: NoSuchElementException) {
            ResponseEntity.notFound().build()
        }
    }
}

@RestController
@RequestMapping("/api/motoristas")
class MotoristaController(
    private val motoristaService: MotoristaService
) {
    @PostMapping
    fun registerMotoristas(@RequestBody motorista: Motorista): ResponseEntity<Motorista>{
        motoristaService.registerMotorista(
            nome = motorista.nome_motorista,
            cpf = motorista.cpf_motorista,
            numeroregistro = motorista.numero_registro,
            categoriahabilitacao = motorista.categoria_habilitacao,
            email = motorista.email_motorista,
            telefone = motorista.telefone_motorista,
            rua = motorista.rua_motorista,
            cidade = motorista.cidade_motorista,
            bairro = motorista.bairro_motorista,
            uf = motorista.uf_motorista
        )
        return ResponseEntity.status(HttpStatus.CREATED).build()
    }


    @GetMapping
    fun findAllMotoristas(): ResponseEntity<List<Motorista>> {
        return ResponseEntity.ok(motoristaService.findAllMotoristas())
    }

    @GetMapping("/{id}")
    fun findByIdMotoristas(@PathVariable id: Long): ResponseEntity<Motorista> {
        val motorista = motoristaService.findByIdMotoristas(id)
        return if (motorista != null) {
            ResponseEntity.ok(motorista)
        } else {
            ResponseEntity.notFound().build()
        }
    }

    @PatchMapping("/{id}")
    fun updateByIdMotoristas(@PathVariable id: Long, @RequestBody motorista: Motorista): ResponseEntity<Motorista> {
        return motoristaService.updateByIdMotoristas(id, motorista)?.let {
            ResponseEntity.ok(it)
        } ?: ResponseEntity.notFound().build()
    }

    @DeleteMapping("/{id}")
    fun deleteMotoristas(@PathVariable id: Long): ResponseEntity<Void> {
        return try {
            motoristaService.deleteMotoristas(id)
            ResponseEntity.noContent().build()
        } catch (e: NoSuchElementException) {
            ResponseEntity.notFound().build()
        }
    }
}

@RestController
@RequestMapping("/api/confirmacoes")
class ConfirmacaoController(
    private val confirmacaoService: ConfirmacaoService,
    private val passageiroService: PassageiroService
) {

    @PostMapping
    fun createConfirmacao(@RequestBody @Valid confirmacaoRequest: ConfirmacaoRequest): ResponseEntity<Confirmacao> {
        val passageiro = passageiroService.findByIdPassageiro(confirmacaoRequest.passageiro)
            ?: return ResponseEntity.notFound().build()

        val confirmacao = Confirmacao(
            passageiro = passageiro,
            ativo = confirmacaoRequest.ativo,
            data_confirmacao = confirmacaoRequest.dataConfirmacao,
            data_cancelamento = confirmacaoRequest.dataCancelamento
        )

        val createdConfirmacao = confirmacaoService.createConfirmacao(confirmacao)
        return ResponseEntity(createdConfirmacao, HttpStatus.CREATED)
    }

    @GetMapping
    fun getAllConfirmacoes(): ResponseEntity<List<Confirmacao>> {
        return ResponseEntity.ok(confirmacaoService.findAllConfirmacoes())
    }

    @GetMapping("/{id}")
    fun getConfirmacaoById(@PathVariable id: Long): ResponseEntity<Confirmacao> {
        val confirmacao = confirmacaoService.findByIdConfirmacao(id)
        return if (confirmacao != null) {
            ResponseEntity.ok(confirmacao)
        } else {
            ResponseEntity.notFound().build()
        }
    }

    @PatchMapping("/{id}")
    fun updateConfirmacao(
        @PathVariable id: Long,
        @RequestBody @Valid confirmacaoRequest: ConfirmacaoRequest
    ): ResponseEntity<Confirmacao> {
        val passageiro = passageiroService.findByIdPassageiro(confirmacaoRequest.passageiro)
            ?: return ResponseEntity.notFound().build()

        val confirmacao = Confirmacao(
            id_confirmacao = id,
            passageiro = passageiro,
            ativo = confirmacaoRequest.ativo,
            data_confirmacao = confirmacaoRequest.dataConfirmacao,
            data_cancelamento = confirmacaoRequest.dataCancelamento
        )

        val updatedConfirmacao = confirmacaoService.updateConfirmacao(id, confirmacao)
        return ResponseEntity.ok(updatedConfirmacao)
    }
}

@RestController
@RequestMapping("/api/veiculos")
class VeiculoController(private val veiculoService: VeiculoService) {

    @PostMapping
    fun registerVeiculo(@RequestBody veiculo: Veiculos): ResponseEntity<Veiculos> {
        return try {
            val savedVeiculo = veiculoService.registerVeiculo(
                marca = veiculo.marca,
                modelo = veiculo.modelo,
                placa = veiculo.placa,
                ano = veiculo.ano,
                capacidade = veiculo.capacidade,
                cor = veiculo.cor,
                data_registro = veiculo.data_registro,
                empresa = veiculo.empresa
            )
            ResponseEntity.status(HttpStatus.CREATED).body(savedVeiculo)
        } catch (e: Exception) {
            ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build()
        }
    }

    @GetMapping
    fun getAllVeiculos(): ResponseEntity<List<Veiculos>> {
        return ResponseEntity.ok(veiculoService.findAllVeiculos())
    }

    @GetMapping("/{id}")
    fun findByIdVeiculo(@PathVariable id: Long): ResponseEntity<Veiculos> {
        return veiculoService.findByIdVeiculo(id)?.let {
            ResponseEntity.ok(it)
        } ?: ResponseEntity.notFound().build()
    }

    @PatchMapping("/{id}")
    fun updateByIdVeiculo(@PathVariable id: Long, @RequestBody veiculo: Veiculos): ResponseEntity<Veiculos> {
        return veiculoService.updateByIdVeiculo(id, veiculo)?.let {
            ResponseEntity.ok(it)
        } ?: ResponseEntity.notFound().build()
    }

    @DeleteMapping("/{id}")
    fun deleteByIdVeiculo(@PathVariable id: Long): ResponseEntity<Void> {
        return try {
            veiculoService.deleteVeiculo(id)
            ResponseEntity.noContent().build()
        } catch (e: NoSuchElementException) {
            ResponseEntity.notFound().build()
        }
    }
}
@RestController
@RequestMapping("/api/rotas")
class RotaController(private val rotaService: RotaService) {

    @PostMapping
    fun createRota(@RequestBody rota: Rotas): ResponseEntity<Rotas> {
        val novaRota = rotaService.createRota(rota)
        return ResponseEntity.ok(novaRota)
    }

    @GetMapping
    fun getAllRotas(): ResponseEntity<List<Rotas>> {
        val rotas = rotaService.getAllRotas()
        return ResponseEntity.ok(rotas)
    }

    @GetMapping("/{id}")
    fun getRotaById(@PathVariable id: Long): ResponseEntity<Rotas> {
        val rota = rotaService.getRotaById(id)
        return if (rota != null) {
            ResponseEntity.ok(rota)
        } else {
            ResponseEntity.notFound().build()
        }
    }

    @PutMapping("/{id}")
    fun updateRota(
        @PathVariable id: Long,
        @RequestBody rotaDetails: Rotas
    ): ResponseEntity<Rotas> {
        val updatedRota = rotaService.updateRota(id, rotaDetails)
        return if (updatedRota != null) {
            ResponseEntity.ok(updatedRota)
        } else {
            ResponseEntity.notFound().build()
        }
    }

    @DeleteMapping("/{id}")
    fun deleteRota(@PathVariable id: Long): ResponseEntity<Void> {
        rotaService.deleteRota(id)
        return ResponseEntity.noContent().build()
    }
}
@RestController
@RequestMapping("/api/contratos")
class ContratoController(private val contratoService: ContratoService) {

    @PostMapping
    fun createContrato(@RequestBody contrato: Contratos): ResponseEntity<Contratos> {
        val novoContrato = contratoService.createContrato(contrato)
        return ResponseEntity.ok(novoContrato)
    }

    @GetMapping
    fun getAllContratos(): ResponseEntity<List<Contratos>> {
        val contratos = contratoService.getAllContratos()
        return ResponseEntity.ok(contratos)
    }

    @GetMapping("/{id}")
    fun getContratoById(@PathVariable id: Long): ResponseEntity<Contratos> {
        val contrato = contratoService.getContratoById(id)
        return if (contrato != null) {
            ResponseEntity.ok(contrato)
        } else {
            ResponseEntity.notFound().build()
        }
    }

    @PutMapping("/{id}")
    fun updateContrato(
        @PathVariable id: Long,
        @RequestBody contratoDetails: Contratos
    ): ResponseEntity<Contratos> {
        val updatedContrato = contratoService.updateContrato(id, contratoDetails)
        return if (updatedContrato != null) {
            ResponseEntity.ok(updatedContrato)
        } else {
            ResponseEntity.notFound().build()
        }
    }

    @DeleteMapping("/{id}")
    fun deleteContrato(@PathVariable id: Long): ResponseEntity<Void> {
        contratoService.deleteContrato(id)
        return ResponseEntity.noContent().build()
    }
}
@RestController
@RequestMapping("/api/feedback")
class FeedbackController(private val feedbackService: FeedbackService) {

    @PostMapping
    fun createFeedback(@RequestBody feedback: Feedback): ResponseEntity<Feedback> {
        val novoFeedback = feedbackService.createFeedback(feedback)
        return ResponseEntity.ok(novoFeedback)
    }

    @GetMapping
    fun getAllFeedbacks(): ResponseEntity<List<Feedback>> {
        val feedbacks = feedbackService.getAllFeedbacks()
        return ResponseEntity.ok(feedbacks)
    }

    @GetMapping("/{id}")
    fun getFeedbackById(@PathVariable id: Long): ResponseEntity<Feedback> {
        val feedback = feedbackService.getFeedbackById(id)
        return if (feedback != null) {
            ResponseEntity.ok(feedback)
        } else {
            ResponseEntity.notFound().build()
        }
    }

    @PutMapping("/{id}")
    fun updateFeedback(
        @PathVariable id: Long,
        @RequestBody feedbackDetails: Feedback
    ): ResponseEntity<Feedback> {
        val updatedFeedback = feedbackService.updateFeedback(id, feedbackDetails)
        return if (updatedFeedback != null) {
            ResponseEntity.ok(updatedFeedback)
        } else {
            ResponseEntity.notFound().build()
        }
    }

    @DeleteMapping("/{id}")
    fun deleteFeedback(@PathVariable id: Long): ResponseEntity<Void> {
        feedbackService.deleteFeedback(id)
        return ResponseEntity.noContent().build()
    }
}
@RestController
@RequestMapping("/api/mensagens")
class MensagensController(private val mensagensService: MensagensService) {

    @PostMapping
    fun createMensagem(@RequestBody mensagem: Mensagens): ResponseEntity<Mensagens> {
        val novaMensagem = mensagensService.createMensagem(mensagem)
        return ResponseEntity.ok(novaMensagem)
    }

    @GetMapping
    fun getAllMensagens(): ResponseEntity<List<Mensagens>> {
        val mensagens = mensagensService.getAllMensagens()
        return ResponseEntity.ok(mensagens)
    }

    @GetMapping("/{id}")
    fun getMensagemById(@PathVariable id: Long): ResponseEntity<Mensagens> {
        val mensagem = mensagensService.getMensagemById(id)
        return if (mensagem != null) {
            ResponseEntity.ok(mensagem)
        } else {
            ResponseEntity.notFound().build()
        }
    }

    @PutMapping("/{id}")
    fun updateMensagem(
        @PathVariable id: Long,
        @RequestBody mensagemDetails: Mensagens
    ): ResponseEntity<Mensagens> {
        val updatedMensagem = mensagensService.updateMensagem(id, mensagemDetails)
        return if (updatedMensagem != null) {
            ResponseEntity.ok(updatedMensagem)
        } else {
            ResponseEntity.notFound().build()
        }
    }

    @DeleteMapping("/{id}")
    fun deleteMensagem(@PathVariable id: Long): ResponseEntity<Void> {
        mensagensService.deleteMensagem(id)
        return ResponseEntity.noContent().build()
    }
}