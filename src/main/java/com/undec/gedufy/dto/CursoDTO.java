package com.undec.gedufy.dto;

import com.undec.gedufy.model.Curso;

import java.util.ArrayList;
import java.util.List;

public class CursoDTO {
    private Integer id;
    private String nombre;
    private String descripcion;
    private String imagen;
    private Double precio;
    private Integer cantHoras;
    private String categoria;
    private String url;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Integer getCantHoras() {
        return cantHoras;
    }

    public void setCantHoras(Integer cantHoras) {
        this.cantHoras = cantHoras;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public CursoDTO getCursoDTO(Curso curso) {
        CursoDTO cursoDTO = new CursoDTO();
        cursoDTO.setId(curso.getId());
        cursoDTO.setNombre(curso.getNombre());
        cursoDTO.setDescripcion(curso.getDescripcion());
        cursoDTO.setPrecio(curso.getPrecio());
        cursoDTO.setCantHoras(curso.getCantHoras());
        cursoDTO.setCategoria(curso.getCategoria());
        cursoDTO.setUrl(curso.getUrl());
        cursoDTO.setImagen(curso.getImagen());

        return cursoDTO;
    }

    public List<CursoDTO> getCursoDTOList(List<Curso> cursoList) {
        List<CursoDTO> cursoDTOList = new ArrayList<>();

        for (Curso item : cursoList) {
            CursoDTO cursoDTO = new CursoDTO();
            cursoDTO.setId(item.getId());
            cursoDTO.setNombre(item.getNombre());
            cursoDTO.setDescripcion(item.getDescripcion());
            cursoDTO.setImagen(item.getImagen());
            cursoDTO.setPrecio(item.getPrecio());
            cursoDTO.setCantHoras(item.getCantHoras());
            cursoDTO.setCategoria(item.getCategoria());
            cursoDTO.setUrl(item.getUrl());
            cursoDTOList.add(cursoDTO);
        }
        return cursoDTOList;
    }
}
