package com.compasso.avaliacao.dto;

import com.compasso.avaliacao.entity.Associado;
import lombok.*;

import java.util.Date;
import java.util.List;



public class PartidoDTO {

    private String id;

    private String nome;

    private String sigla;

    private String ideologia;

    private Date dataFundacao;

    private List<AssociadoDTO> associados;
}
