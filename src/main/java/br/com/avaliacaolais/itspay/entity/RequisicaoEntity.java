package br.com.avaliacaolais.itspay.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Getter
@Setter
@Entity
@Table(name="TB_REQUISICAO")
public class RequisicaoEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COD_REQUISICAO")
    private Long codigoRequisicao;

    @Column(name = "DT_DATA", nullable = false)
    private Date data;

    @ManyToOne
    @JoinColumn(name = "COD_CLIENTE")
    private ClienteEntity clienteEntity;
}