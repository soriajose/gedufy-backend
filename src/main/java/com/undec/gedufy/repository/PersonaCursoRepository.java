package com.undec.gedufy.repository;

import com.undec.gedufy.model.Curso;
import com.undec.gedufy.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import com.undec.gedufy.model.PersonaCurso;

import java.util.List;

public interface PersonaCursoRepository extends JpaRepository<PersonaCurso, Integer> {
    List<PersonaCurso> findByPersonaAndCurso(Persona persona, Curso curso);

    List<PersonaCurso> findByPersona(Persona persona);
}