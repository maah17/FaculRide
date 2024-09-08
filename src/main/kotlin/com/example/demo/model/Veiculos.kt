package com.example.demo.model

import jakarta.persistence.*
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import java.time.LocalDate

@Entity
@Table(name = "veiculos")
data class Veiculos(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id_veiculo: Long? = null,

    @Column(nullable = false)
    @field:NotBlank(message = "Este campo deve ser preenchido")
    val marca: String,

    @Column(nullable = false)
    @field:NotBlank(message = "Este campo deve ser preenchido")
    val modelo: String,

    @Column(nullable = false)
    @field:NotBlank(message = "Este campo deve ser preenchido")
    val placa: String,

    @Column(nullable = false)
    @field:NotBlank(message = "Este campo deve ser preenchido")
    val ano: String,

    @Column(nullable = false)
    @field:NotBlank(message = "Este campo deve ser preenchido")
    val capacidade: Int,

    @Column(nullable = false)
    @field:NotBlank(message = "Este campo deve ser preenchido")
    val cor: String,

    @Column(nullable = false)
    @field:NotNull(message = "Este campo deve ser preenchido")
    val data_registro: LocalDate,

    @ManyToOne
    @JoinColumn(name = "id_empresa", nullable = false)
    val empresa: Empresa
) {
    constructor() : this(
        id_veiculo = null,
        marca = "",
        modelo = "",
        placa = "",
        ano = "",
        cor = "",
        data_registro = LocalDate.now(),
        capacidade = 0,
        empresa = Empresa()
    )
}
