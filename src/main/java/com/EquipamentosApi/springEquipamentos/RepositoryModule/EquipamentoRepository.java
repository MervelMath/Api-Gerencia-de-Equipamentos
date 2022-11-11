package com.EquipamentosApi.springEquipamentos.RepositoryModule;

import com.EquipamentosApi.springEquipamentos.DominioModule.Equipamento;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipamentoRepository extends JpaRepository<Equipamento,Integer>{
    
}
