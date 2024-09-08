package com.example.demo.model

import jakarta.persistence.*
import jakarta.validation.constraints.NotBlank
import java.time.LocalDate

@Entity
@Table(name = "contratos")
data class Contratos(

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    val id_contrato:Long? = null,

    @ManyToOne
    @JoinColumn(name = "id_contratante", nullable = false)
    val id_contratante: Passageiro,

    @ManyToOne
    @JoinColumn(name = "id_rota", nullable = false)
    val id_rota: Rotas,

    @Column(nullable = false)
    @field:NotBlank(message = "Este campo deve ser preenchido")
    val data_contrato: LocalDate,

    @Column(nullable = false)
    val status: Boolean
){ constructor():this(
    id_contrato = null,
    id_contratante = Passageiro(),
    id_rota = Rotas(),
    data_contrato = LocalDate.now() ,
    status = true
    )
}