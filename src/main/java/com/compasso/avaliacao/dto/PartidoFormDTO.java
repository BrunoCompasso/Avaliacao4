package com.compasso.avaliacao.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
import javax.validation.constraints.Pattern;

@Data
public class PartidoFormDTO {

    private String nome;

    private String sigla;

    @Pattern(regexp = "Direita|Centro|Esquerda")
    private String ideologia;

    @JsonFormat (shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy", timezone = "GMT-03")
    private Date dataFundacao;

}
