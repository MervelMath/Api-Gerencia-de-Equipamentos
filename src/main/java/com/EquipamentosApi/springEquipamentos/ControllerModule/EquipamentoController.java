package com.EquipamentosApi.springEquipamentos.ControllerModule;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.EquipamentosApi.springEquipamentos.DTOmodule.EquipamentoDTO;
import com.EquipamentosApi.springEquipamentos.DominioModule.Equipamento;
import com.EquipamentosApi.springEquipamentos.ServiceModule.EquipamentoService;

@CrossOrigin
@RestController
@RequestMapping(value = "/equipamento")
public class EquipamentoController {

    @Autowired
    private EquipamentoService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Equipamento> findById(@PathVariable Integer id){
        Equipamento obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping
    public ResponseEntity<List<EquipamentoDTO>> findAll() {

        List<Equipamento> listaEquipamento = service.findAll();
        List<EquipamentoDTO> listaEquipamentoDTO = listaEquipamento.stream().map(obj -> new EquipamentoDTO(obj))
                .collect(Collectors.toList());
                
        return ResponseEntity.ok().body(listaEquipamentoDTO);
    }

    @PostMapping
    public ResponseEntity<Equipamento> create(@Valid @RequestBody Equipamento obj) {
        obj = service.create(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<EquipamentoDTO> update(@Valid @PathVariable Integer id, @RequestBody EquipamentoDTO objDTO) {
        Equipamento newObj = service.update(id, objDTO);

        return ResponseEntity.ok().body(new EquipamentoDTO(newObj));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete (@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
