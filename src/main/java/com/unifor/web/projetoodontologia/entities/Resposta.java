package com.unifor.web.projetoodontologia.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Objects;

@Document(collection = "respostas")
public class Resposta implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private String id;
    private String id_atendimento;
    private String r1;
    private String r2;
    private String r3;

    public Resposta() {
    }

    public Resposta(String id, String r1, String r2, String r3) {
        this.id = id;
        this.r1 = r1;
        this.r2 = r2;
        this.r3 = r3;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId_atendimento() {
        return id_atendimento;
    }

    public void setId_atendimento(String id_atendimento) {
        this.id_atendimento = id_atendimento;
    }

    public String getR1() {
        return r1;
    }

    public void setR1(String r1) {
        this.r1 = r1;
    }

    public String getR2() {
        return r2;
    }

    public void setR2(String r2) {
        this.r2 = r2;
    }

    public String getR3() {
        return r3;
    }

    public void setR3(String r3) {
        this.r3 = r3;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Resposta resposta = (Resposta) o;
        return Objects.equals(id, resposta.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
