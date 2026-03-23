package com.bn.projetoscs.repositories;

import com.bn.projetoscs.models.ProjetoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjetoRepository extends JpaRepository<ProjetoModel, Long> {
}
