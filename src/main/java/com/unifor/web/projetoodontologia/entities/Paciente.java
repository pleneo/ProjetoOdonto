package com.unifor.web.projetoodontologia.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Document(collection = "pacientes")
public class Paciente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private String id;
    private String nome;
    private Integer idade; // Campo novo adicionado

    @DBRef(lazy = true) // Relação inversa (1-N)
    private List<Atendimento> atendimentos = new ArrayList<>();

    public Paciente(String id, String nome, Integer idade) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
    }

    // Getters e Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public Integer getIdade() { return idade; }
    public void setIdade(Integer idade) { this.idade = idade; }

    @JsonIgnore
    public List<Atendimento> getAtendimentos() { return atendimentos; }
    public void setAtendimentos(List<Atendimento> atendimentos) { this.atendimentos = atendimentos; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Paciente paciente = (Paciente) o;
        return Objects.equals(id, paciente.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
