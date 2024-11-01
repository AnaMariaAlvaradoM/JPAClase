package com.claseJPA.JPAClase.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PersonaMascotaDTO {

    private String nombre;
    private String nombreMascota;

    public PersonaMascotaDTO() {
    }

    public PersonaMascotaDTO(String nombre, String nombreMascota) {
        this.nombre = nombre;
        this.nombreMascota = nombreMascota;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombreMascota() {
        return nombreMascota;
    }

    public void setNombreMascota(String nombreMascota) {
        this.nombreMascota = nombreMascota;
    }
}
