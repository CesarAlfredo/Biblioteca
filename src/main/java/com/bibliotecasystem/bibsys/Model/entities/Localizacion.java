package com.bibliotecasystem.bibsys.Model.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "localizaciones")
public class Localizacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String posicion;
    
    private String coordenada;

    private Integer aula;

    private String librero;

    public Localizacion (){
        
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public String getCoordenada() {
        return coordenada;
    }

    public void setCoordenada(String coordenada) {
        this.coordenada = coordenada;
    }

    public Integer getAula() {
        return aula;
    }

    public void setAula(Integer aula) {
        this.aula = aula;
    }

    public String getLibrero() {
        return librero;
    }

    public void setLibrero(String librero) {
        this.librero = librero;
    }
    

}
