package com.claseJPA.JPAClase.controller;


import com.claseJPA.JPAClase.DTO.PersonaMascotaDTO;
import com.claseJPA.JPAClase.model.Mascota;
import com.claseJPA.JPAClase.model.Persona;
import com.claseJPA.JPAClase.service.IMascotaService;
import com.claseJPA.JPAClase.service.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//Llamando dos anotaciones contrlle y responseBody

public class PersonaController {

    @Autowired
    private IPersonaService persoServ;

    @Autowired
    private IMascotaService mascoServ;

    //Endpoint para obtener todas las personas
    @GetMapping("/personas/traer")
    public List<Persona> getPersonas(){
        return persoServ.getPersonas();
    }
    //Endpoint para crear una nueva persona
    @PostMapping("/personas/crear")
    public String savePersona(@RequestBody Persona perso){
        persoServ.savePersona(perso);
        //devolver una respuesta de ok
        return "La persona se creo con exito";
    }
    //Endpoint para eliminar una persona
    @DeleteMapping("/personas/borrar/{id}")
    public String deletePersona(@PathVariable Long id){
        persoServ.deletePersona(id);
        return "La persona fue eliminada";
    }

    //EndPoint para modificar una persona
    @PutMapping("/personas/editar/{id}")
    public Persona editPersona(@PathVariable Long id,
                               @RequestParam(required = false, name = "nombre") String nombre,
                               @RequestParam(required = false, name = "apellido") String apellido,
                               @RequestParam(required = false, name = "edad") int edad){

        persoServ.editPersona(id, nombre, apellido, edad);

        Persona perso = persoServ.findPersona(id);

        return  perso;
    }

    //4-Obtener
    @GetMapping("/personas/mascotas/{id}")
    public List<PersonaMascotaDTO> mascotaPorPersona(@PathVariable Long id) {
        return persoServ.mascotasPorPersona(id);
    }

    @PostMapping("/personas/{id}/mascotas")
    public String crearMascota(@PathVariable Long id, @RequestBody Mascota mascota) {
        Persona persona = persoServ.findPersona(id); // Buscar persona por ID
        mascota.setDueno(persona); // Asociar mascota a la persona
        mascoServ.saveMascota(mascota); // Guardar mascota
        return "La mascota fue creada correctamente";
    }

}


