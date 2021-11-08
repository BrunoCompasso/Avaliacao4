package com.compasso.avaliacao.services;

import com.compasso.avaliacao.dto.PartidoDTO;
import com.compasso.avaliacao.dto.PartidoFormDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PartidoService {


    PartidoDTO salvar(PartidoFormDTO corpo);

    List<PartidoDTO> listar(String ideologia);

    PartidoDTO procurar(Long id);

    PartidoDTO atualizar(Long id, PartidoFormDTO body);

    void remover(Long id);

    PartidoDTO listarAssociados(Long id);

}

