package com.undec.gedufy.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "contacto", schema = "gedufy", catalog = "")
public class Contacto {
    private Integer id;
    private String nombre;
    private String correo;
    private String mensaje;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "nombre")
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Basic
    @Column(name = "correo")
    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Basic
    @Column(name = "mensaje")
    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contacto that = (Contacto) o;
        return id == that.id &&
                Objects.equals(nombre, that.nombre) &&
                Objects.equals(correo, that.correo) &&
                Objects.equals(mensaje, that.mensaje);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, correo, mensaje);
    }
}
