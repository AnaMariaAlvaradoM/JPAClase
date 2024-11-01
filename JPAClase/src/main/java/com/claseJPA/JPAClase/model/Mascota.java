package com.claseJPA.JPAClase.model;


import jakarta.persistence.*;

@Entity
public class Mascota {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id_mascota;
    private String nombreMascota;
    private String especie;
    private String raza;


//    @OneToOne(mappedBy = "miMascota")
//    private Persona dueno;


    @ManyToOne //Indica que varias mascotas pueden tener un dueño
    @JoinColumn(name = "id_Persona")
    private Persona dueno;

    public Mascota() {
    }

    public Mascota(Long id_mascota, String nombreMascota, String especie, String raza) {
        this.id_mascota = id_mascota;
        this.nombreMascota = nombreMascota;
        this.especie = especie;
        this.raza = raza;
    }

    public Long getId_mascota() {
        return id_mascota;
    }

    public void setId_mascota(Long id_mascota) {
        this.id_mascota = id_mascota;
    }

    public String getNombre() {
        return nombreMascota;
    }

    public void setNombre(String nombreMascota) {
        this.nombreMascota = nombreMascota;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getNombreMascota() {
        return nombreMascota;
    }

    public void setNombreMascota(String nombreMascota) {
        this.nombreMascota = nombreMascota;
    }

    public Persona getDueno() {
        return dueno;
    }

    public void setDueno(Persona dueno) {
        this.dueno = dueno;
    }
}
