package com.example.demo.repository

import com.example.demo.model.Confirmacao
import com.example.demo.model.Motorista
import com.example.demo.model.Empresa
import com.example.demo.model.Passageiro
import com.example.demo.model.Veiculos
import com.example.demo.model.Rotas
import com.example.demo.model.Contratos
import com.example.demo.model.Feedback
import com.example.demo.model.Mensagens
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface EmpresaRepository : JpaRepository<Empresa, Long>
interface PassageiroRepository: JpaRepository<Passageiro, Long>
interface MotoristaRepository: JpaRepository<Motorista, Long>
interface ConfirmacaoRepository: JpaRepository<Confirmacao, Long>
interface RotasRepository: JpaRepository<Rotas, Long>
interface FeedbackRepository: JpaRepository<Feedback, Long>
interface ContratosRepository: JpaRepository<Contratos, Long>
interface VeiculoRepository: JpaRepository<Veiculos, Long>
interface MensagensRepository: JpaRepository<Mensagens, Long>

