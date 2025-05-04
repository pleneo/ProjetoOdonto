package com.unifor.web.projetoodontologia.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Document(collection = "professores")
public class Professor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private String id;
    private String nome;
    private String especializacao; // Campo duplicado (ajuste conforme necessidade)

    @DBRef(lazy = true) // Relação inversa (opcional)
    private List<Atendimento> atendimentos = new ArrayList<>();

    @DBRef(lazy = true) // Relação N-N com Disciplina (Adicionado)
    private List<Disciplina> disciplinas = new ArrayList<>();
    //TODO fazer DTO's para esses casos de JSONIgnore


    public Professor(String id, String nome, String especializacao) {
        this.id = id;
        this.nome = nome;
        this.especializacao = especializacao;
    }

    // Getters e Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getEspecializacao() { return especializacao; }
    public void setEspecializacao(String especializacao) { this.especializacao = especializacao; }

    @JsonIgnore
    public List<Atendimento> getAtendimentos() { return atendimentos; }
    public void setAtendimentos(List<Atendimento> atendimentos) { this.atendimentos = atendimentos; }

    @JsonIgnore
    public List<Disciplina> getDisciplinas() { return disciplinas; }
    public void setDisciplinas(List<Disciplina> disciplinas) { this.disciplinas = disciplinas; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Professor professor = (Professor) o;
        return Objects.equals(id, professor.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
