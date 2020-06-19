package br.com.avaliacaolais.itspay.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Getter
@Setter
@Entity
@Table(name="TB_CLIENTE")
public class ClienteEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COD_CLIENTE")
    private Long codigoCliente;

    @Column(name = "TX_NOME", nullable = false)
    private String nome;

    @Column(name = "TX_CPF", nullable = false, unique = true, length = 11)
    private String cpf;

    @Column(name = "TX_CNPJ", unique = true, length = 14)
    private String cnpj;

}