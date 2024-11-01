package com.claseJPA.JPAClase.controller;

import com.claseJPA.JPAClase.model.Mascota;
import com.claseJPA.JPAClase.model.Persona;
import com.claseJPA.JPAClase.service.IMascotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MascotaController {


    @Autowired
    private IMascotaService mascoServ;

    @PostMapping("/mascotas/crear")
    public String savePersona (@RequestBody Mascota masco) {
        mascoServ.saveMascota(masco);

        return "La mascota fue creada correctamente";
    }




}

