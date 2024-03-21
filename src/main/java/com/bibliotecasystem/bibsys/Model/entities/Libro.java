package com.bibliotecasystem.bibsys.Model.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.List;

@Entity
@Table(name = "libros")
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    private Long volumen;

    
    @OneToOne
    @JoinTable(
        name="libros_localizaciones",
        joinColumns = @JoinColumn(name="libro_id"),
        inverseJoinColumns = @JoinColumn(name = "localizacion_id")
    )
    
    private Localizacion localizacion;


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String getTitulo() {
        return titulo;
    }


    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }


    public Long getVolumen() {
        return volumen;
    }


    public void setVolumen(Long volumen) {
        this.volumen = volumen;
    }


    public Localizacion getLocalizacion() {
        return localizacion;
    }


    public void setLocalizacion(Localizacion localizacion) {
        this.localizacion = localizacion;
    }
    
}
