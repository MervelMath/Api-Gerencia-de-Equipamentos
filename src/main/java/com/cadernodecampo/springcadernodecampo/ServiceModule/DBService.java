package com.cadernodecampo.springcadernodecampo.ServiceModule;

import java.util.Arrays;

import com.cadernodecampo.springcadernodecampo.DominioModule.Equipamento;
import com.cadernodecampo.springcadernodecampo.RepositoryModule.EquipamentoRepository;

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
