package com.cadernodecampo.springcadernodecampo.RepositoryModule;

import com.cadernodecampo.springcadernodecampo.DominioModule.Equipamento;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipamentoRepository extends JpaRepository<Equipamento,Integer>{
    
}
