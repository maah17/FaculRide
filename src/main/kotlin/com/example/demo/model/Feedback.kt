package com.example.demo.model

import jakarta.persistence.*
import java.time.LocalDate

@Entity
@Table(name = "feedback")
data class Feedback(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id_feedback: Long? = 0,

    @ManyToOne
    @JoinColumn(name = "id_contrato", nullable = false)
    val id_contrato: Contratos,

    @ManyToOne
    @JoinColumn(name = "id_passageiro", nullable = false)
    val id_passageiro: Passageiro,

    @Column(nullable = false)
    val nota: Int,

    @Column(nullable = false)
    val comentario: String,

    @Column(nullable = false)
    val data_feedback: LocalDate,

    @Column
    val pulado:Boolean

){
    constructor():this(
        id_feedback = null,
        id_contrato = Contratos(),
        id_passageiro = Passageiro(),
        nota = 0,
        comentario = "",
        data_feedback = LocalDate.now(),
        pulado = false
    )
}