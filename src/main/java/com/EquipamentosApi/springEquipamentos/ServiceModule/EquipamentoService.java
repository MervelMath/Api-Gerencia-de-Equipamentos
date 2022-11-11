package com.EquipamentosApi.springEquipamentos.ServiceModule;

import java.util.List;
import java.util.Optional;

import com.EquipamentosApi.springEquipamentos.DTOmodule.EquipamentoDTO;
import com.EquipamentosApi.springEquipamentos.DominioModule.Equipamento;
import com.EquipamentosApi.springEquipamentos.ExceptionsModule.DataIntegrityViolation;
import com.EquipamentosApi.springEquipamentos.ExceptionsModule.ObjectNotFoundException;
import com.EquipamentosApi.springEquipamentos.RepositoryModule.EquipamentoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class EquipamentoService {
    
    @Autowired
    private EquipamentoRepository repository;

    public Equipamento findById(Integer id) {
        Optional<Equipamento> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", tipo: " + Equipamento.class.getName()));
    }

    public List<Equipamento> findAll() {
        return repository.findAll();
    }

    public Equipamento create (Equipamento obj){
        obj.setId(null);
        return repository.save(obj);
    }

    public Equipamento update(Integer id, EquipamentoDTO objDTO){

        Equipamento obj = findById(id);

        obj.setNome(objDTO.getNome());
        obj.setQuantidadeDisponivel(objDTO.getQuantidadeDisponivel());
        obj.setQuantidadeTotal(objDTO.getQuantidadeTotal());
        obj.setTipo(objDTO.getTipo());

        return repository.save(obj);
    }

    public void delete(Integer id) {
        this.findById(id);
        try {
            repository.deleteById(id); 
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolation("Equipamento não pôde ser deletado!");
        }
    }
}
