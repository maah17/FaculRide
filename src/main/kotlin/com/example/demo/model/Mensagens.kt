package com.example.demo.model

import jakarta.persistence.*
import java.time.LocalDate

@Entity
@Table(name = "mensagens")
data class Mensagens(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id_mensagens: Long? = 0,

    @ManyToOne
    @JoinColumn(name = "id_contrato", nullable = false)
    val id_contrato: Contratos,

    @ManyToOne
    @JoinColumn(name = "id_passageiro", nullable = false)
    val id_passageiro: Passageiro,

    @Column(nullable = false)
    val texto:String,

    @Column(nullable = false)
    val data_envio: LocalDate,

){
    constructor():this(
        id_mensagens = null,
        id_contrato = Contratos(),
        id_passageiro = Passageiro(),
        texto = "",
        data_envio = LocalDate.now()
    )
}