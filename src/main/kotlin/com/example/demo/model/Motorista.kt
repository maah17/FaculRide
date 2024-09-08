package com.example.demo.model


import jakarta.persistence.*
import jakarta.validation.constraints.*

@Entity
@Table(name = "motorista")
data class Motorista(

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    val id_motorista: Long? = null,

    @Column (nullable = false)
    @field:NotBlank(message = "O campo nome não pode ser vazio")
    val nome_motorista: String,

    @Column (nullable = false)
    @field:NotBlank(message = "O campo CPF não pode ser vazio")
    val cpf_motorista: String,

    @Column(nullable = false)
    @field:NotBlank(message = "O campo Registro veicular não pode ser vazio")
    val numero_registro:String,

    @Column(nullable = false)
    @field:NotBlank(message = "Informe a sua categoria de habilitação")
    val categoria_habilitacao:String,

    @Column(nullable = false)
    @field:NotBlank(message = "O campo email não pode ser vazio")
    @field:Email(message = "O campo email deve conter @")
    val email_motorista:String,

    @Column(nullable = false)
    @field:NotBlank(message = "o campo telefone não pode estar vazio")
    val telefone_motorista: String,

    @Column(nullable = false)
    @field:NotBlank(message = "o campo rua não pode estar vazio")
    val rua_motorista: String,

    @Column(nullable = false)
    @field:NotBlank(message = "o campo cidade não pode estar vazio")
    val cidade_motorista: String,

    @Column(nullable = false)
    @field:NotBlank(message = "o campo bairro não pode estar vazio")
    val bairro_motorista: String,

    @Column(nullable = false)
    @field:NotBlank(message = "o campo uf não pode estar vazio")
    val uf_motorista: String
    ){
    constructor() : this(0, "", "", "", "", "", "", "", "","","")

}