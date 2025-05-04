package com.unifor.web.projetoodontologia.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document(collection = "feedbacks")
public class Feedback implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private String id;
    private String descricao;

    //TODO associacao feedback-paciente


    public Feedback(String id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    // Getters e Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }



}