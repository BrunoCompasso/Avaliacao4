package com.compasso.avaliacao.entity;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "partido")
public class Partido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String sigla;

    private String ideologia;

    private Date dataFundacao;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Associado> associados;
}
