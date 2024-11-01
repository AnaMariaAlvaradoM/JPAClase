package com.claseJPA.JPAClase.service;


import com.claseJPA.JPAClase.model.Mascota;

import java.util.List;

public interface IMascotaService {

    //métdo para traer a todas las mascota
    //lectura
    public List<Mascota> getMascotas();

    //alta
    public void saveMascota(Mascota masco);

    //baja
    public void deleteMascota(Long id_mascota);

    //lectura de un solo objeto
    public Mascota findMascota(Long id_mascota);

    //edición/modificación
    public void editMascota(Long id,
                            String nuevoNombre,
                            String nuevaEspecie,
                            String nuevaRaza);


}
