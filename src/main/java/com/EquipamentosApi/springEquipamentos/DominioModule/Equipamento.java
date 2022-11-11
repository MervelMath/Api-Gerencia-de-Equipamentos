package com.EquipamentosApi.springEquipamentos.DominioModule;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Equipamento implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    private String nome;
    private String tipo;
    private Integer quantidadeTotal;
    private Integer quantidadeDisponivel;
    
   

    public Equipamento(Integer id, String nome, String tipo, Integer quantidadeTotal, Integer quantidadeDisponivel) {
        this.setId(id);
        this.nome = nome;
        this.tipo = tipo;
        this.quantidadeTotal = quantidadeTotal;
        this.quantidadeDisponivel = quantidadeDisponivel;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Equipamento other = (Equipamento) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
    
    //region gets e sets
        public Equipamento(){
            super();
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public String getTipo() {
            return tipo;
        }

        public void setTipo(String tipo) {
            this.tipo = tipo;
        }

        public Integer getQuantidadeTotal() {
            return quantidadeTotal;
        }

        public void setQuantidadeTotal(Integer quantidadeTotal) {
            this.quantidadeTotal = quantidadeTotal;
        }
        public Integer getQuantidadeDisponivel() {
            return quantidadeDisponivel;
        }

        public void setQuantidadeDisponivel(Integer quantidadeDisponivel) {
            this.quantidadeDisponivel = quantidadeDisponivel;
        }
    //endregion
    
}
