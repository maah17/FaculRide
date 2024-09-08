package com.example.demo.service

import com.example.demo.model.Confirmacao
import com.example.demo.model.Empresa
import com.example.demo.model.Motorista
import com.example.demo.model.Passageiro
import com.example.demo.model.Veiculos
import com.example.demo.model.Rotas
import com.example.demo.model.Contratos
import com.example.demo.model.Feedback
import com.example.demo.model.Mensagens
import com.example.demo.repository.MensagensRepository
import com.example.demo.repository.FeedbackRepository
import com.example.demo.repository.ContratosRepository
import com.example.demo.repository.VeiculoRepository
import com.example.demo.repository.RotasRepository
import com.example.demo.repository.ConfirmacaoRepository
import com.example.demo.repository.PassageiroRepository
import com.example.demo.repository.EmpresaRepository
import com.example.demo.repository.MotoristaRepository
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import jakarta.transaction.Transactional
import java.time.LocalDate

@Service
@Transactional
class EmpresaService(

private val EmpresaRepository:EmpresaRepository){
	fun registerEmpresa(nome:String, cnpj: String, email: String, rua: String, cidade: String, uf: String, telefone: String, inscricaoestadual:String, razaosocial:String): Empresa {
		val empresa = Empresa(
			nome_empresa = nome,
			cnpj_empresa = cnpj,
			inscricao_estadual = inscricaoestadual,
			cidade_empresa = cidade,
			uf_empresa = uf,
			rua_empresa = rua,
			email_empresa = email,
			razao_social = razaosocial,
			telefone = telefone
		)
		return EmpresaRepository.save(empresa)
	}
	fun findAllEmpresas(): List<Empresa> = EmpresaRepository.findAll()

	fun findByIdEmpresas(id:Long): Empresa? = EmpresaRepository.findById(id).orElse(null)

	fun deleteEmpresa(id: Long) {
		if (EmpresaRepository.existsById(id)) {
			EmpresaRepository.deleteById(id)
		} else {
			throw NoSuchElementException("Empresa com ID $id não encontrada")
		}
	}

	fun updateByIdempresa(id: Long, updatedEmpresa: Empresa): Empresa? {
		return if (EmpresaRepository.existsById(id)) {
			val empresaToUpdate = updatedEmpresa.copy(id_empresa = id)

			EmpresaRepository.save(empresaToUpdate)
		} else {
			null
		}
	}}

@Service
@Transactional
class PassageiroService(
	private val PassageiroRepository: PassageiroRepository,
	private val PasswordEncoder: PasswordEncoder
) {
	fun registerPassageiro(nome: String, cpf: String, email: String, rua: String, cidade: String, bairro: String, uf: String, senha: String, telefone: String) {
		val encodedPassword = PasswordEncoder.encode(senha)
		val passageiro = Passageiro(
			nome_passageiro = nome,
			cpf_passageiro = cpf,
			email_passageiro = email,
			rua_passageiro = rua,
			cidade_passageiro = cidade,
			bairro_passageiro = bairro,
			uf_passageiro= uf,
			senha_passageiro = encodedPassword,
			telefone_passageiro = telefone
		)
		PassageiroRepository.save(passageiro)
	}

	fun findAllPassageiros(): List<Passageiro> = PassageiroRepository.findAll()

	fun findByIdPassageiro(id: Long): Passageiro? = PassageiroRepository.findById(id).orElse(null)


	fun updateByIdPassageiro(id: Long, updatedPassageiro: Passageiro): Passageiro? {
		return if (PassageiroRepository.existsById(id)) {
			val existingPassageiro = PassageiroRepository.findById(id).orElse(null) ?: return null

			val passageiroToUpdate = existingPassageiro.copy(
				nome_passageiro = updatedPassageiro.nome_passageiro ?: existingPassageiro.nome_passageiro,
				cpf_passageiro = updatedPassageiro.cpf_passageiro ?: existingPassageiro.cpf_passageiro,
				email_passageiro = updatedPassageiro.email_passageiro ?: existingPassageiro.email_passageiro,
				rua_passageiro = updatedPassageiro.rua_passageiro ?: existingPassageiro.rua_passageiro,
				cidade_passageiro = updatedPassageiro.cidade_passageiro ?: existingPassageiro.cidade_passageiro,
				bairro_passageiro = updatedPassageiro.bairro_passageiro ?: existingPassageiro.bairro_passageiro,
				uf_passageiro = updatedPassageiro.uf_passageiro ?: existingPassageiro.uf_passageiro,
				telefone_passageiro = updatedPassageiro.telefone_passageiro ?: existingPassageiro.telefone_passageiro,
				senha_passageiro = updatedPassageiro.senha_passageiro?.let { PasswordEncoder.encode(it) } ?: existingPassageiro.senha_passageiro
			)

			PassageiroRepository.save(passageiroToUpdate)
		} else {
			null
		}
	}

	fun deletePassageiro(id: Long) {
		if (PassageiroRepository.existsById(id)) {
			PassageiroRepository.deleteById(id)
		} else {
			throw NoSuchElementException("Passageiro com ID $id não encontrado")
		}
	}
}

@Service
@Transactional
class MotoristaService(
	private val motoristaRepository: MotoristaRepository
) {

	fun registerMotorista(nome: String, cpf: String, numeroregistro: String, categoriahabilitacao: String, email: String, telefone: String, rua: String, cidade: String, bairro: String, uf: String
	) {
		val motorista = Motorista(
			nome_motorista = nome,
			cpf_motorista = cpf,
			numero_registro = numeroregistro,
			categoria_habilitacao = categoriahabilitacao,
			email_motorista = email,
			telefone_motorista = telefone,
			rua_motorista = rua,
			cidade_motorista = cidade,
			bairro_motorista = bairro,
			uf_motorista = uf
		)
		motoristaRepository.save(motorista)
	}

	fun findAllMotoristas(): List<Motorista> = motoristaRepository.findAll()

	fun findByIdMotoristas(id: Long): Motorista? = motoristaRepository.findById(id).orElse(null)

	fun updateByIdMotoristas(id: Long, updatedMotorista: Motorista): Motorista? {
		return if (motoristaRepository.existsById(id)) {
			val existingMotorista = motoristaRepository.findById(id).orElse(null) ?: return null

			val motoristaToUpdate = existingMotorista.copy(
				nome_motorista = updatedMotorista.nome_motorista ?: existingMotorista.nome_motorista,
				cpf_motorista = updatedMotorista.cpf_motorista ?: existingMotorista.cpf_motorista,
				numero_registro = updatedMotorista.numero_registro ?: existingMotorista.numero_registro,
				categoria_habilitacao = updatedMotorista.categoria_habilitacao ?: existingMotorista.categoria_habilitacao,
				email_motorista = updatedMotorista.email_motorista ?: existingMotorista.email_motorista,
				telefone_motorista = updatedMotorista.telefone_motorista ?: existingMotorista.telefone_motorista,
				rua_motorista = updatedMotorista.rua_motorista ?: existingMotorista.rua_motorista,
				cidade_motorista = updatedMotorista.cidade_motorista ?: existingMotorista.cidade_motorista,
				bairro_motorista = updatedMotorista.bairro_motorista ?: existingMotorista.bairro_motorista,
				uf_motorista = updatedMotorista.uf_motorista ?: existingMotorista.uf_motorista
			)

			motoristaRepository.save(motoristaToUpdate)
		} else {
			null
		}
	}

	fun deleteMotoristas(id: Long) {
		if (motoristaRepository.existsById(id)) {
			motoristaRepository.deleteById(id)
		} else {
			throw NoSuchElementException("Motorista com ID $id não encontrado")
		}
	}
}

@Service
@Transactional
class ConfirmacaoService(
	private val confirmacaoRepository: ConfirmacaoRepository
) {

	fun createConfirmacao(confirmacao: Confirmacao): Confirmacao {
		return confirmacaoRepository.save(confirmacao)
	}

	fun findAllConfirmacoes(): List<Confirmacao> {
		return confirmacaoRepository.findAll()
	}

	fun findByIdConfirmacao(id: Long): Confirmacao? {
		return confirmacaoRepository.findById(id).orElse(null)
	}

	fun updateConfirmacao(id: Long, confirmacao: Confirmacao): Confirmacao {
		if (!confirmacaoRepository.existsById(id)) {
			throw NoSuchElementException("Confirmacao not found")
		}
		return confirmacaoRepository.save(confirmacao)
	}

	fun deleteConfirmacao(id: Long) {
		if (!confirmacaoRepository.existsById(id)) {
			throw NoSuchElementException("Confirmacao not found")
		}
		confirmacaoRepository.deleteById(id)
	}
}


@Service
@Transactional
class VeiculoService(private val veiculoRepository: VeiculoRepository) {

	fun registerVeiculo(
		marca: String,
		modelo: String,
		placa: String,
		ano: String,
		capacidade: Int,
		cor: String,
		data_registro: LocalDate,
		empresa: Empresa
	): Veiculos {
		val veiculo = Veiculos(
			marca = marca,
			modelo = modelo,
			placa = placa,
			ano = ano,
			capacidade = capacidade,
			cor = cor,
			data_registro = data_registro,
			empresa = empresa
		)
		return veiculoRepository.save(veiculo)
	}

	fun findAllVeiculos(): List<Veiculos> = veiculoRepository.findAll()

	fun findByIdVeiculo(id: Long): Veiculos? = veiculoRepository.findById(id).orElse(null)

	fun updateByIdVeiculo(id: Long, updatedVeiculo: Veiculos): Veiculos? {
		return if (veiculoRepository.existsById(id)) {
			val veiculoToUpdate = updatedVeiculo.copy(id_veiculo = id)
			veiculoRepository.save(veiculoToUpdate)
		} else {
			null
		}
	}

	fun deleteVeiculo(id: Long) {
		if (veiculoRepository.existsById(id)) {
			veiculoRepository.deleteById(id)
		} else {
			throw NoSuchElementException("Veículo com ID $id não encontrado")
		}
	}
}

@Service
class RotaService(private val rotaRepository: RotasRepository) {

	fun createRota(rota: Rotas): Rotas {
		return rotaRepository.save(rota)
	}

	fun getAllRotas(): List<Rotas> {
		return rotaRepository.findAll()
	}

	fun getRotaById(id: Long): Rotas? {
		return rotaRepository.findById(id).orElse(null)
	}

	fun updateRota(id: Long, rotaDetails: Rotas): Rotas? {
		val existingRota = rotaRepository.findById(id).orElse(null) ?: return null

		val updatedRota = existingRota.copy(
			local_partida = rotaDetails.local_partida,
			local_chegada = rotaDetails.local_chegada,
			data_rota = rotaDetails.data_rota,
			horario = rotaDetails.horario,
			descicao = rotaDetails.descicao
		)

		return rotaRepository.save(updatedRota)
	}

	fun deleteRota(id: Long) {
		rotaRepository.deleteById(id)
	}
}

@Service
class ContratoService(private val contratoRepository: ContratosRepository) {

	fun createContrato(contrato: Contratos): Contratos {
		return contratoRepository.save(contrato)
	}

	fun getAllContratos(): List<Contratos> {
		return contratoRepository.findAll()
	}

	fun getContratoById(id: Long): Contratos? {
		return contratoRepository.findById(id).orElse(null)
	}

	fun updateContrato(id: Long, contratoDetails: Contratos): Contratos? {
		val existingContrato = contratoRepository.findById(id).orElse(null) ?: return null

		val updatedContrato = existingContrato.copy(
			id_contratante = contratoDetails.id_contratante,
			id_rota = contratoDetails.id_rota,
			data_contrato = contratoDetails.data_contrato,
			status = contratoDetails.status
		)

		return contratoRepository.save(updatedContrato)
	}

	fun deleteContrato(id: Long) {
		contratoRepository.deleteById(id)
	}
}
@Service
class FeedbackService(private val feedbackRepository: FeedbackRepository) {

	fun createFeedback(feedback: Feedback): Feedback {
		return feedbackRepository.save(feedback)
	}

	fun getAllFeedbacks(): List<Feedback> {
		return feedbackRepository.findAll()
	}

	fun getFeedbackById(id: Long): Feedback? {
		return feedbackRepository.findById(id).orElse(null)
	}

	fun updateFeedback(id: Long, feedbackDetails: Feedback): Feedback? {
		val existingFeedback = feedbackRepository.findById(id).orElse(null) ?: return null

		val updatedFeedback = existingFeedback.copy(
			id_contrato = feedbackDetails.id_contrato,
			id_passageiro = feedbackDetails.id_passageiro,
			nota = feedbackDetails.nota,
			comentario = feedbackDetails.comentario,
			data_feedback = feedbackDetails.data_feedback,
			pulado = feedbackDetails.pulado
		)

		return feedbackRepository.save(updatedFeedback)
	}

	fun deleteFeedback(id: Long) {
		feedbackRepository.deleteById(id)
	}
}
@Service
class MensagensService(private val mensagensRepository: MensagensRepository) {

	fun createMensagem(mensagem: Mensagens): Mensagens {
		return mensagensRepository.save(mensagem)
	}

	fun getAllMensagens(): List<Mensagens> {
		return mensagensRepository.findAll()
	}

	fun getMensagemById(id: Long): Mensagens? {
		return mensagensRepository.findById(id).orElse(null)
	}

	fun updateMensagem(id: Long, mensagemDetails: Mensagens): Mensagens? {
		val existingMensagem = mensagensRepository.findById(id).orElse(null) ?: return null

		val updatedMensagem = existingMensagem.copy(
			id_contrato = mensagemDetails.id_contrato,
			id_passageiro = mensagemDetails.id_passageiro,
			texto = mensagemDetails.texto,
			data_envio = mensagemDetails.data_envio
		)

		return mensagensRepository.save(updatedMensagem)
	}

	fun deleteMensagem(id: Long) {
		mensagensRepository.deleteById(id)
	}
}