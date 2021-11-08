package com.compasso.avaliacao.services;

import com.compasso.avaliacao.dto.AssociadoDTO;
import com.compasso.avaliacao.dto.AssociadoFormDTO;
import com.compasso.avaliacao.entity.Associado;
import com.compasso.avaliacao.entity.Partido;
import com.compasso.avaliacao.repository.AssociadoRepository;
import com.compasso.avaliacao.repository.PartidoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class AssociadoServiceImpl implements AssociadoService{


    @Autowired
    private AssociadoRepository repository;

    @Autowired
    private PartidoRepository partidoRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public AssociadoDTO salvar(AssociadoFormDTO body) {
        Associado associado = mapper.map(body, Associado.class);
        Associado associadoResponse =  this.repository.save(associado);
        return mapper.map(associadoResponse, AssociadoDTO.class)        ;
    }

    @Override
    public AssociadoDTO vincularPartido(long idAssociado,long idPartido) {
        Optional<Associado> associado = this.repository.findById(idAssociado);
        if (associado.isPresent() == true) {
            Optional<Partido> partidos = this.partidoRepository.findById(idPartido);
            associado.get().setPartido(partidos.get());
            Associado st = this.repository.save(associado.get());
            return mapper.map(st, AssociadoDTO.class);
        }
        throw new RuntimeException("Associado não encontrado");
    }

    @Override
    public List<AssociadoDTO> listar(String cargo) {
        List<AssociadoDTO> associadoDTOList = new ArrayList<>();
        if (cargo != null){
            associadoDTOList = this.repository.findByCargo(cargo).stream().map(st -> mapper.map(st, AssociadoDTO.class)).collect(Collectors.toList());
        }else
            associadoDTOList = this.repository.findAll().stream().map(st -> mapper.map(st, AssociadoDTO.class)).collect(Collectors.toList());
        return associadoDTOList;
    }

    @Override
    public AssociadoDTO procurar(Long id) {
        Optional<Associado> state = this.repository.findById(id);
        if (state.isPresent() == true) {
            return mapper.map(state.get(), AssociadoDTO.class);
        }
        throw new RuntimeException("Associado não localizado");
    }

    @Override
    public AssociadoDTO atualizar(Long id, AssociadoFormDTO body) {
        Optional<Associado> associado = this.repository.findById(id);
        if (associado.isPresent() == true) {
            associado.get().setCargoPolitico(body.getCargoPolitico());
            Associado st = this.repository.save(associado.get());
            return mapper.map(st, AssociadoDTO.class);
        }
        throw new RuntimeException("Associado não localizado");
    }

    @Override
    public void remover(Long id) {
        Associado associado = this.repository.findById(id).get();
        this.repository.delete(associado);
    }
}
