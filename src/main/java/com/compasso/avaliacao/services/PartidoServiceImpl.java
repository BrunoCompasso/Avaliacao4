package com.compasso.avaliacao.services;

import com.compasso.avaliacao.dto.PartidoDTO;
import com.compasso.avaliacao.dto.PartidoFormDTO;
import com.compasso.avaliacao.entity.Partido;
import com.compasso.avaliacao.repository.PartidoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class PartidoServiceImpl implements PartidoService{

    @Autowired
    private PartidoRepository repository;

    @Autowired
    private ModelMapper mapper;


    @Override
    public PartidoDTO salvar(PartidoFormDTO body) {
        Partido partido = mapper.map(body, Partido.class);
        Partido partidosResponse = this.repository.save(partido);
        return mapper.map(partidosResponse, PartidoDTO.class);
    }

    @Override
    public List<PartidoDTO> listar(String ideologia) {
        List<PartidoDTO> partido = new ArrayList<>();
        if (ideologia != null){
            partido = this.repository.findByIdeologia(ideologia).stream().map(st -> mapper.map(st, PartidoDTO.class)).collect(Collectors.toList());
        }else
            partido = this.repository.findAll().stream().map(st -> mapper.map(st, PartidoDTO.class)).collect(Collectors.toList());
        return partido;
    }

    @Override
    public PartidoDTO procurar(Long id) {
        Optional<Partido> state = this.repository.findById(id);
        if (state.isPresent() == true) {
            return mapper.map(state.get(), PartidoDTO.class);
        }
        throw new RuntimeException("Partido não encontrado");
    }

    @Override
    public PartidoDTO atualizar(Long id, PartidoFormDTO body) {
        Optional<Partido> state = this.repository.findById(id);
        if (state.isPresent() == true) {
            state.get().setNome(body.getNome());
            Partido st = this.repository.save(state.get());
            return mapper.map(st, PartidoDTO.class);
        }
        throw new RuntimeException("Partido não encontrado");
    }

    @Override
    public void remover(Long id) {
        Partido partido = this.repository.findById(id).get();
        this.repository.delete(partido);
    }

    @Override
    public PartidoDTO listarAssociados(Long id) {
        Optional<Partido> partido = this.repository.findById(id);
        if (partido.isPresent() == true) {
            return mapper.map(partido.get().getAssociados(), PartidoDTO.class);
        }
        throw new RuntimeException("Partido não encontrado");
    }

}