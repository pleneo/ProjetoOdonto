package com.unifor.web.projetoodontologia.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "disciplinas")
public class Disciplina implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private String id;
    private String nome;
    private String id_turma;
    @DBRef // Relação N-N com Aluno
    private List<Aluno> alunos = new ArrayList<>();

    @DBRef // Relação N-N com Professor (Adicionado)
    private List<Professor> professores = new ArrayList<>();

    public Disciplina(String id, String nome, String id_turma) {
        this.id = id;
        this.nome = nome;
        this.id_turma = id_turma;
    }

    // Getters e Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getId_turma() { return id_turma; }
    public void setId_turma(String id_turma) { this.id_turma = id_turma; }
    public List<Aluno> getAlunos() { return alunos; }
    public void setAlunos(List<Aluno> alunos) { this.alunos = alunos; }
    public List<Professor> getProfessores() { return professores; }
    public void setProfessores(List<Professor> professores) { this.professores = professores; }

}
