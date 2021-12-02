package com.undec.gedufy.controller;

import com.undec.gedufy.dto.Response;
import com.undec.gedufy.model.Contacto;
import com.undec.gedufy.service.ContactoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/contactos")
@CrossOrigin(origins = "*")
public class ContactoController {

    @Autowired
    private ContactoService contactoService;

    @PostMapping
    public ResponseEntity<Response> postContacto(@Valid @RequestBody Contacto contacto){
        Response response = this.contactoService.createContacto(contacto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
