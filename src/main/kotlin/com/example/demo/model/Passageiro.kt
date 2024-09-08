package com.example.demo.model

import jakarta.persistence.*
import jakarta.validation.constraints.*

@Entity
@Table(name = "passageiro")
data class Passageiro(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id_passageiro: Long = 0,

    @Column(nullable = false)
    @field:NotBlank(message = "O nome não pode estar vazio")
    val nome_passageiro: String = "",

    @Column(nullable = false, unique = true)
    @field:NotBlank(message = "O campo CPF não pode ser vazio")
    @field:Pattern(regexp = "\\d{11}", message = "O CPF deve ter 11 dígitos")
    val cpf_passageiro: String = "",

    @Column(nullable = false, unique = true)
    @field:Email(message = "O e-mail deve ser válido")
    val email_passageiro: String = "",

    @Column(nullable = false)
    @field:NotBlank(message = "O campo rua não pode estar vazio")
    val rua_passageiro: String = "",

    @Column(nullable = false)
    @field:NotBlank(message = "O campo cidade não pode estar vazio")
    val cidade_passageiro: String = "",

    @Column(nullable = false)
    @field:NotBlank(message = "O campo bairro não pode estar vazio")
    val bairro_passageiro: String = "",

    @Column(nullable = false)
    @field:NotBlank(message = "O campo unidade federativa não pode estar vazio")
    val uf_passageiro: String = "",

    @Column(nullable = false)
    @field:NotBlank(message = "O campo senha não pode estar vazio")
    val senha_passageiro: String = "",

    @Column(nullable = false)
    @field:NotBlank(message = "O campo telefone não pode estar vazio")
    val telefone_passageiro: String = ""
) {
    constructor() : this(0,
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "")
}