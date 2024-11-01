package com.claseJPA.JPAClase.service;

import com.claseJPA.JPAClase.DTO.PersonaMascotaDTO;
import com.claseJPA.JPAClase.model.Persona;

import java.util.List;

public interface IPersonaService {

        //metdo para traer todas las personas
        public List<Persona> getPersonas();

        //metdo para guardar a un persona
        public void savePersona (Persona perso);

        //metdo pra borrar una persona
        public void deletePersona(Long id);

        //metodo para encontrar una personas
        public Persona findPersona (Long id);

        //metdo para editar una persona
        public void editPersona(Long id, String nuevoNombre, String nuevoApellido, int nuevaEdad);


        // Métdo que devuelve una lista de DTOs con el nombre de la persona y sus mascotas
        List<PersonaMascotaDTO> mascotasPorPersona(Long id);

}

