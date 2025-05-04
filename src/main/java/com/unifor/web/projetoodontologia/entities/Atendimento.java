package com.unifor.web.projetoodontologia.entities;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "atendimentos")
public class Atendimento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private String id;
    @DBRef
    private Paciente paciente;      // Relacionamento com Paciente
    private String procedimento;  // Descrição do procedimento
    @DBRef // Relação N-N com Professor
    private List<Professor> professores = new ArrayList<>();
    @DBRef // Relação N-N com Aluno (Adicionado)
    private List<Aluno> alunos = new ArrayList<>();

    @DBRef // Relação 1-1 com Feedback
    private Feedback feedback;

    public Atendimento(String id, Paciente paciente, String procedimento, Feedback feedback) {
        this.id = id;
        this.paciente = paciente;
        this.procedimento = procedimento;
        this.feedback = feedback;
    }

    // Getters e Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public Paciente getPaciente() { return paciente; }
    public void setPaciente(Paciente paciente) { this.paciente = paciente; }
    public String getProcedimento() { return procedimento; }
    public void setProcedimento(String procedimento) { this.procedimento = procedimento; }
    public List<Professor> getProfessores() { return professores; }
    public void setProfessores(List<Professor> professores) { this.professores = professores; }
    public List<Aluno> getAlunos() { return alunos; }
    public void setAlunos(List<Aluno> alunos) { this.alunos = alunos; }
    public Feedback getFeedback() { return feedback; }
    public void setFeedback(Feedback feedback) { this.feedback = feedback; }



}
