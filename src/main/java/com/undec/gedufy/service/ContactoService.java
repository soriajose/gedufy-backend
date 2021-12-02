package com.undec.gedufy.service;

import com.undec.gedufy.dto.Response;
import com.undec.gedufy.model.Contacto;
import com.undec.gedufy.repository.ContactoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactoService {

    @Autowired
    private ContactoRepository contactoRepository;

    public Response createContacto(Contacto contacto){
        Response response = new Response();
        response.setData(this.contactoRepository.save(contacto));
        return response;
    }

}
