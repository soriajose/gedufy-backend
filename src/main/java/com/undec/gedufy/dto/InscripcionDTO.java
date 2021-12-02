package com.undec.gedufy.dto;

import com.undec.gedufy.model.Curso;
import com.undec.gedufy.model.Persona;
import com.undec.gedufy.model.PersonaCurso;

import java.sql.Timestamp;

public class InscripcionDTO {
    private Integer cursoId;
    private String email;

    public Integer getCursoId() {
        return cursoId;
    }

    public void setCursoId(Integer cursoId) {
        this.cursoId = cursoId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public PersonaCurso getPersonaCurso(InscripcionDTO inscripcionDTO, Curso curso, Persona persona) {
        PersonaCurso personaCurso = new PersonaCurso();
        personaCurso.setCurso(curso);
        personaCurso.setPersona(persona);
        personaCurso.setCreatedBy(persona.getEmail());
        personaCurso.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        personaCurso.setUpdatedBy(persona.getEmail());
        personaCurso.setUpdatedAt(new Timestamp(System.currentTimeMillis()));

        return personaCurso;
    }
}
