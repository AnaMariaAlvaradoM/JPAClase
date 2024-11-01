package com.claseJPA.JPAClase.service;

import com.claseJPA.JPAClase.DTO.PersonaMascotaDTO;
import com.claseJPA.JPAClase.model.Mascota;
import com.claseJPA.JPAClase.model.Persona;
import com.claseJPA.JPAClase.repository.IPersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonaService implements IPersonaService{

    @Autowired
    private IPersonaRepository personaRepository;

    @Override
    public List<Persona> getPersonas() {
        List<Persona> listaPersonas = personaRepository.findAll();
        return listaPersonas;
    }

    @Override
    public void savePersona(Persona perso) {
        personaRepository.save(perso);
    }

    @Override
    public void deletePersona(Long id) {
        personaRepository.deleteById(id);
    }

    @Override
    public Persona findPersona(Long id) {
       Persona perso = personaRepository.findById(id).orElse(null);
       return perso;
    }

    @Override
    public void editPersona(Long id, String nombre, String apellido, int edad) {
        // Buscar la persona por ID
        Persona perso = this.findPersona(id);

        // Verificar si el nombre fue enviado (no null o vacío)
        if (nombre != null && !nombre.trim().isEmpty()) {
            perso.setNombre(nombre);
        }

        // Verificar si el apellido fue enviado
        if (apellido != null && !apellido.trim().isEmpty()) {
            perso.setApellido(apellido);
        }

        // Verificar si la edad fue enviada (puedes agregar más validaciones si es necesario)
        if (edad > 0) {
            perso.setEdad(edad);
        }

        // Guardar los cambios
        this.savePersona(perso);

    }

    @Override
    public List<PersonaMascotaDTO> mascotasPorPersona(Long id) {

        // Lista para almacenar los DTOs
        List<PersonaMascotaDTO> listaPersonaMascotaDTO = new ArrayList<>();

        // Encontrar la persona por su ID
        Persona persona = this.findPersona(id);

        // Iterar sobre cada mascota de la persona
        for (Mascota mascota : persona.getMascotas()) {
            PersonaMascotaDTO dto = new PersonaMascotaDTO();
            dto.setNombre(persona.getNombre());
            dto.setNombreMascota(mascota.getNombre());
            listaPersonaMascotaDTO.add(dto);
        }

        return listaPersonaMascotaDTO;
    }


}
