package com.unifor.web.projetoodontologia.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "alunos")
public class Aluno implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private String id;
    private Integer matricula;    // Campo obrigatório (ex: "20230001")
    private Integer semestreRef; // Campo para referência do semestre (ex: "2023.1")
    private String nome;        // Nome completo do aluno





    public Aluno(String id, Integer matricula, Integer semestreRef, String nome) {
        this.id = id;
        this.matricula = matricula;
        this.semestreRef = semestreRef;
        this.nome = nome;
    }

    // Getters e Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public Integer getMatricula() { return matricula; }
    public void setMatricula(Integer matricula) { this.matricula = matricula; }
    public Integer getSemestreRef() { return semestreRef; }
    public void setSemestreRef(Integer semestreRef) { this.semestreRef = semestreRef; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

}
