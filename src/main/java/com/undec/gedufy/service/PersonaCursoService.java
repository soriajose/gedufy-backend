package com.undec.gedufy.service;

import com.undec.gedufy.dto.CursoDTO;
import com.undec.gedufy.dto.InscripcionDTO;
import com.undec.gedufy.dto.PersonaCursoDTO;
import com.undec.gedufy.dto.Response;
import com.undec.gedufy.model.Curso;
import com.undec.gedufy.model.Persona;
import com.undec.gedufy.model.PersonaCurso;
import com.undec.gedufy.repository.CursoRepository;
import com.undec.gedufy.repository.PersonaCursoRepository;
import com.undec.gedufy.repository.PersonaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * @author etorrielli
 */
@Service
public class PersonaCursoService {

    static final Logger LOGGER = LoggerFactory.getLogger(PersonaCursoService.class);

    @Autowired
    private PersonaCursoRepository personaCursoRepository;
    @Autowired
    private PersonaRepository personaRepository;
    @Autowired
    private CursoRepository cursoRepository;

    public Response findAll() {
        Response response = new Response();
        try {
            List<PersonaCursoDTO> personaCursoDTOList = new PersonaCursoDTO().getPersonaCursoDTOList(personaCursoRepository.findAll());
            response.setData(personaCursoDTOList);
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            e.printStackTrace();
            throw e;
        }
        return response;
    }

    public Response findOneById(String id) {
        Response response = new Response();
        try {
            PersonaCurso personaCurso = personaCursoRepository.findById(Integer.parseInt(id)).get();
            response.setData(personaCurso);

        } catch (NoSuchElementException e) {
            LOGGER.error("No existe.");
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            e.printStackTrace();
            throw e;
        }
        return response;
    }

    public Response update(Object input) {
        Response response = new Response();
        try {

            response.setData(input);

        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            e.printStackTrace();
            throw e;
        }
        return response;
    }

    public Response save(PersonaCursoDTO input) {
        Response response = new Response();
        try {
            // TODO: 9/10/2021: verificar que exista el curso (por id). Si no existe devolver status/message indicandolo en el response
            Curso curso = cursoRepository.findById(input.getCursoDTO().getId()).get();
            if (curso != null) {
                // TODO: 9/10/2021: verificar que exista la persona (por email). Si no existe devolver status/message indicandolo en el response
                Persona persona = personaRepository.findById(input.getPersonaDTO().getId()).get();
                if (persona != null) {
                    // TODO: 9/10/2021: castear de PersonaCursoDTO a PersonaCurso
                    PersonaCurso personaCurso = new PersonaCursoDTO().getPersonaCurso(input, curso, persona);
                    // TODO: 9/10/2021: save
                    personaCurso = personaCursoRepository.save(personaCurso);
                    // TODO: 9/10/2021: en el response.data devolver el objeto guardado
                    response.setData(personaCurso);
                } else {
                    response.setStatus(2);
                    response.setMessage("La Persona indicada no existe");
                }
            } else {
                response.setStatus(2);
                response.setMessage("El Curso indicado no existe");
            }

        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            e.printStackTrace();
            throw e;
        }
        return response;
    }

    public Response saveInscripcion(InscripcionDTO input) {
        Response response = new Response();
        try {
            Curso curso = cursoRepository.findById(input.getCursoId()).get();
            if (curso != null) {
                Persona persona = personaRepository.findOneByEmail(input.getEmail());
                if (persona != null) {
                    List<PersonaCurso> personaCursoExist = personaCursoRepository.findByPersonaAndCurso(persona, curso);
                    if (personaCursoExist == null || personaCursoExist.size() == 0) {
                        PersonaCurso personaCurso = new InscripcionDTO().getPersonaCurso(input, curso, persona);
                        personaCurso = personaCursoRepository.save(personaCurso);
                        response.setData(personaCurso);
                    } else {
                        response.setStatus(3);
                        response.setMessage("Ya se encuentra inscripto en el curso");
                    }
                } else {
                    response.setStatus(2);
                    response.setMessage("La Persona indicada no existe");
                }
            } else {
                response.setStatus(2);
                response.setMessage("El Curso indicado no existe");
            }

        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            e.printStackTrace();
            throw e;
        }
        return response;
    }

    public Response delete(String id) {
        Response response = new Response();
        try {
            PersonaCurso personaCurso = personaCursoRepository.findById(Integer.parseInt(id)).get();
            personaCursoRepository.save(personaCurso);

            response.setMessage("Eliminado correctamente.");

        } catch (NoSuchElementException e) {
            LOGGER.error("No existe.");
        } catch (Exception e) {
            LOGGER.error("Error general.");
            throw e;
        }
        return response;
    }

    public Response findInscripciones(String email) {
        Response response = new Response();
        try {
            Persona persona = personaRepository.findOneByEmail(email);
            if (persona != null) {
                List<PersonaCurso> personaCursoList = personaCursoRepository.findByPersona(persona);
                List<CursoDTO> cursoDTOList = new ArrayList<>();
                for (PersonaCurso personaCurso : personaCursoList) {
                    CursoDTO cursoDTO = new CursoDTO().getCursoDTO(personaCurso.getCurso());
                    cursoDTOList.add(cursoDTO);
                }
                response.setData(cursoDTOList);
            } else {
                response.setStatus(2);
                response.setMessage("La Persona indicada no existe");
            }
        } catch (NoSuchElementException e) {
            LOGGER.error("No existe.");
        } catch (Exception e) {
            LOGGER.error("Error general.");
            throw e;
        }
        return response;
    }

}