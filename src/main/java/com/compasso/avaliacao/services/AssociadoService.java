package com.compasso.avaliacao.services;

import com.compasso.avaliacao.dto.AssociadoDTO;
import com.compasso.avaliacao.dto.AssociadoFormDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AssociadoService {

    AssociadoDTO salvar(AssociadoFormDTO body);

    AssociadoDTO vincularPartido(long id,long ida);

    List<AssociadoDTO> listar(String cargo);

    AssociadoDTO procurar(Long id);

    AssociadoDTO atualizar(Long id, AssociadoFormDTO body);

    void remover(Long id);

}
