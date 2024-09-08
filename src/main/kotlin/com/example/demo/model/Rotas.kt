package com.example.demo.model


import jakarta.persistence.*
import jakarta.validation.constraints.NotBlank
import java.time.LocalDate
import java.time.LocalTime

@Entity
@Table(name = "rotas")
data class Rotas(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id_rota: Long? = null,

    @Column(nullable = false)
    val local_partida: String,

    @Column(nullable = false)
    val local_chegada: String,

    @Column(nullable = false)
    val data_rota: LocalDate,

    @Column(nullable = false)
    val horario: LocalTime,

    @Column(nullable = false)
    @field:NotBlank(message = "Este campo deve ser preenchido")
    val descicao: String,
    ){
    constructor(): this(
        id_rota=null,
        local_partida = "",
        local_chegada = "",
        data_rota = LocalDate.now(),
        horario = LocalTime.now(),
        descicao = ""
    )
}
