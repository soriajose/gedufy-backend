package com.undec.gedufy.dto;

import com.undec.gedufy.model.Contacto;

import java.util.ArrayList;
import java.util.List;

public class ContactoDTO {

    private int id;
    private String nombre;
    private String correo;
    private String mensaje;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public ContactoDTO getContactoDTO(Contacto contacto){
        ContactoDTO contactoDTO = new ContactoDTO();
        contactoDTO.setNombre(contacto.getNombre());
        contactoDTO.setCorreo(contacto.getCorreo());
        contactoDTO.setMensaje(contacto.getNombre());

        return contactoDTO;
    }

    public List<ContactoDTO> getContactoDTOList(List<Contacto> contactoList){
        List<ContactoDTO> contactoDTOList = new ArrayList<>();

        for(Contacto i: contactoList){
            ContactoDTO contactoDTO = new ContactoDTO();
            contactoDTO.setNombre(i.getNombre());
            contactoDTO.setCorreo(i.getCorreo());
            contactoDTO.setMensaje(i.getMensaje());

            contactoDTOList.add(contactoDTO);
        }

        return contactoDTOList;
    }


}
