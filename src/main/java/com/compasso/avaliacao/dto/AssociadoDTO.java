package com.compasso.avaliacao.dto;

import com.compasso.avaliacao.entity.Partido;
import lombok.Data;

import java.util.Date;

@Data
public class AssociadoDTO {
    private Long id;

    private String nome;

    private String cargoPolitico;

    private Date dataNascimento;

    private String sexo;

    private PartidoDTO partido;

}
