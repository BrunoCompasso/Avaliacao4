package com.compasso.avaliacao.dto;

import com.compasso.avaliacao.entity.Partido;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.validation.constraints.Pattern;
import java.util.Date;

@Data
public class AssociadoFormDTO {

    private String nome;

    @Pattern(regexp = "Vereador|Prefeito|Deputado Estadual|Dputado Federal|Senador|Governador|Presidente|Nenhum")
    private String cargoPolitico;

    @JsonFormat (shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy", timezone = "GMT-03")
    private Date dataNascimento;

    @Pattern(regexp = "Feminino|Masculino")
    private String sexo;

    private String idpartido;
}
