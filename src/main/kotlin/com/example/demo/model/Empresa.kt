package com.example.demo.model

import jakarta.persistence.*
import jakarta.validation.constraints.*

@Entity
@Table(name = "empresa")
data class Empresa(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id_empresa: Long = 0,

    @Column(nullable = false)
    @field:NotBlank(message = "O nome da empresa não pode ser vazio")
    val nome_empresa: String = "",

    @Column(nullable = false)
    @field:NotBlank(message = "O CNPJ da empresa não pode ser vazio")
    @field:Pattern(regexp = "\\d{14}", message = "O CNPJ deve ter 14 dígitos")
    val cnpj_empresa: String = "",

    @Column(nullable = false)
    @field:NotBlank(message = "A inscrição estadual não pode ser vazia")
    val inscricao_estadual: String = "",

    @Column(nullable = false)
    @field:NotBlank(message = "A cidade da empresa não pode ser vazia")
    val cidade_empresa: String = "",

    @Column(nullable = false)
    @field:NotBlank(message = "O UF da empresa não pode ser vazio")
    val uf_empresa: String = "",

    @Column(nullable = false)
    @field:NotBlank(message = "A rua da empresa não pode ser vazia")
    val rua_empresa: String = "",

    @Column(nullable = false)
    @field:Email(message = "O e-mail da empresa deve ser válido")
    val email_empresa: String = "",

    @Column(nullable = false)
    @field:NotBlank(message = "A razão social não pode ser vazia")
    val razao_social: String = "",

    @Column(nullable = false)
    @field:NotBlank(message = "O telefone não pode ser vazio")
    val telefone: String = ""
) {
    constructor() : this(0, "", "", "", "", "", "", "", "")
}
