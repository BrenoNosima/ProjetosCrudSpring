package com.bn.projetoscs.service;

import com.bn.projetoscs.models.ProjetoModel;
import com.bn.projetoscs.repositories.ProjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjetoService {

    @Autowired
    private ProjetoRepository projetoRepository;

    public ProjetoModel criar(ProjetoModel projetoModel) {
        return projetoRepository.save(projetoModel);
    }

    public List<ProjetoModel> listar() {
        return projetoRepository.findAll();
    }

    public ProjetoModel procurarPorId(Long id) {
        return projetoRepository.findById(id).get();
    }

    public void deletar(Long id) {
        projetoRepository.deleteById(id);
    }
}
