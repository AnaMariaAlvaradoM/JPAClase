package com.claseJPA.JPAClase.service;


import com.claseJPA.JPAClase.model.Mascota;
import com.claseJPA.JPAClase.repository.IMascotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MascotaService implements IMascotaService{

    @Autowired
    private IMascotaRepository repoMasco;

    @Override
    public List<Mascota> getMascotas() {
        List<Mascota> listaMascotas = repoMasco.findAll();
        return listaMascotas;
    }

    @Override
    public void saveMascota(Mascota masco) {
        repoMasco.save(masco);
    }

    @Override
    public void deleteMascota(Long id_mascota) {
        repoMasco.deleteById(id_mascota);
    }

    @Override
    public Mascota findMascota(Long id_mascota) {
        return repoMasco.findById(id_mascota).orElse(null);
    }

    @Override
    public void editMascota(Long id, String nuevoNombre,
                            String nuevaEspecie, String nuevaRaza) {

        //busco  el objeto original
        Mascota masco = this.findMascota(id);

        //proceso de modificación a nivel lógico
        masco.setNombre(nuevoNombre);
        masco.setEspecie(nuevaEspecie);
        masco.setRaza(nuevaRaza);

        //guardar los cambios
        this.saveMascota(masco);
    }

}
