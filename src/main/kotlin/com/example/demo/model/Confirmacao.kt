package com.example.demo.model

import jakarta.persistence.*
import java.time.LocalDate

@Entity
@Table(name = "confirmacao")
data class Confirmacao(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id_confirmacao: Long? = null,

    @ManyToOne
    @JoinColumn(name = "id_passageiro", nullable = false)
    val passageiro: Passageiro,

    @Column(nullable = false)
    val ativo: Boolean,

    @Column(nullable = false)
    val data_confirmacao: LocalDate,

    @Column(nullable = true)
    val data_cancelamento: LocalDate?
){
    constructor() : this(
        id_confirmacao = null,
        passageiro = Passageiro(),
        ativo = true,
        data_confirmacao = LocalDate.now(),
        data_cancelamento = LocalDate.now())
}

data class ConfirmacaoRequest(
    val passageiro: Long,
    val ativo: Boolean,
    val dataConfirmacao: LocalDate,
    val dataCancelamento: LocalDate
)

