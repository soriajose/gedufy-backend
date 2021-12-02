package com.undec.gedufy.controller;

import com.undec.gedufy.dto.InscripcionDTO;
import com.undec.gedufy.dto.PersonaCursoDTO;
import com.undec.gedufy.dto.Response;
import com.undec.gedufy.service.PersonaCursoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author etorrielli
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/personas-cursos")
@Tag(name = "PersonaCurso", description = "Toda la info de la relacion PersonaCurso")
public class PersonaCursoController {

    @Autowired
    private PersonaCursoService personaCursoService;

    @GetMapping()
    public ResponseEntity<Response> list() {
        Response response = personaCursoService.findAll();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response> get(@PathVariable String id) {
        Response response = personaCursoService.findOneById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Response> put(@RequestBody Object input) {
        Response response = personaCursoService.update(input);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Response> post(@RequestBody PersonaCursoDTO input) {
        Response response = personaCursoService.save(input);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/inscripcion")
    public ResponseEntity<Response> saveInscripcion(@RequestBody InscripcionDTO input) {
        Response response = personaCursoService.saveInscripcion(input);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response> delete(@PathVariable String id) {
        Response response = personaCursoService.delete(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/inscripciones/{email}")
    public ResponseEntity<Response> getInscripciones(@PathVariable String email) {
        Response response = personaCursoService.findInscripciones(email);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}