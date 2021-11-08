package com.compasso.avaliacao.entity;

import lombok.Data;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "associado")
public class Associado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String cargoPolitico;

    private Date dataNascimento;

    private String sexo;

    @ManyToOne
    private Partido partido;

}
