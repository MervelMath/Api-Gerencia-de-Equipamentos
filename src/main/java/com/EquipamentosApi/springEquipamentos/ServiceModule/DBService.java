package com.EquipamentosApi.springEquipamentos.ServiceModule;

import java.util.Arrays;

import com.EquipamentosApi.springEquipamentos.DominioModule.Equipamento;
import com.EquipamentosApi.springEquipamentos.RepositoryModule.EquipamentoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DBService {

        @Autowired
        private EquipamentoRepository equipamentoRepository;

        
        public void InstanciaBaseDeDados() {

                Equipamento equipamento = new Equipamento(20, "teste1", "bola", 5, 2);
                
                this.equipamentoRepository.saveAll(Arrays.asList(equipamento));
        }
}
